package com.trains;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RouteMap {
    private Map<String, Integer> drawing = new HashMap<String, Integer>();

    public RouteMap(Map<String,Integer> input) {
        this.drawing = input;
    }

    public Integer getDistanceBetweenTowns(String towns) {
        return drawing.get(towns);
    }

    public void addRoute(String route, int distance) {
        drawing.put(route,distance);
    }

    public Integer calculateDistanceBetweenThreeTowns(String threeTowns) {

        String firstTwoTowns = threeTowns.substring(0,2);
        int distanceFirstTwoTowns = drawing.get(firstTwoTowns);

        String secondTwoTowns = threeTowns.substring(1,3);
        int distanceSecondTwoTowns = drawing.get(secondTwoTowns);

        int totalDistance = distanceFirstTwoTowns + distanceSecondTwoTowns;

        return totalDistance;

    }

    public Boolean checkIfRouteIsValid(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            String towns = input.substring(i, i + 2);
            if (!drawing.containsKey(towns)) {
                return false;

            }
        }
        return true;
    }

    public Integer calculateDistanceBetweenFourTowns(String fourTowns) {
        String firstTwoTowns = fourTowns.substring(0,2);
        int distanceFirstTwoTowns = drawing.get(firstTwoTowns);

        String secondTwoTowns = fourTowns.substring(1,3);
        int distanceSecondTwoTowns = drawing.get(secondTwoTowns);

        String thirdTwoTowns = fourTowns.substring(2,4);
        int distanceThirdTwoTowns = drawing.get(thirdTwoTowns);

        String distanceFourthTwoTowns = fourTowns.substring(3,5);
        int distanceSecondTwoTownsFourth = drawing.get(distanceFourthTwoTowns);

        int totalDistance = distanceFirstTwoTowns + distanceSecondTwoTowns + distanceThirdTwoTowns + distanceSecondTwoTownsFourth;
        return totalDistance;
    }

    public int calculateNoOfTrips(String startTown, String endTown, int maxNoOfStops) {
        int maxTrips = 0;
        String endTownNeighbor = "";
        String startTownNeighbor = "";
        Set<String> routes = drawing.keySet();
        for (String route : routes) {

            if(twoStopRouteExists(startTown, routes, route)){
                maxTrips++;
            }
            if(maxTrips!=0 && maxNoOfStops==2){
                break;
            }
            //how can we refactor the below 3 if's
            if (route.startsWith(startTown)) {
                startTownNeighbor = route.substring(1, 2);
            }
            if (route.endsWith(endTown)) {
                endTownNeighbor = route.substring(0, 1);
            }
            if (neighborsFoundInRoutes(endTownNeighbor, startTownNeighbor)) {
                    maxTrips++;
                    startTownNeighbor="";
                    endTownNeighbor="";
                }

            }
            return maxTrips;
        }

    private boolean twoStopRouteExists(String startTown, Set<String> routes, String route) {
        if (route.startsWith(startTown)) {
            String routeReverse = new StringBuffer(route).reverse().toString();
            if (routes.contains(routeReverse)) {
               return true;

            }
        }
        return false;
    }

    private boolean neighborsFoundInRoutes(String endTownNeighbor, String startTownNeighbor) {
        if((!startTownNeighbor.equals("")) && ((!endTownNeighbor.equals("")) && !(startTownNeighbor.equals(endTownNeighbor)))){
            String combineNeighbors = startTownNeighbor.concat(endTownNeighbor);
            if (drawing.containsKey(combineNeighbors)) {
                return true;
            }
        }
        return false;
    }
    public int calculateNoOfTripsWithMaxStops(String startTown, String endTown, int stops) {
        int maxTrips = calculateNoOfTrips("C","C",stops);
        return maxTrips;
    }
}
