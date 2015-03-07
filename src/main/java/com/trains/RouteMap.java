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

        int distance3 = distanceFirstTwoTowns + distanceSecondTwoTowns;

        return distance3;

    }

    public Boolean checkIfRouteIsValid(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            String towns = input.substring(i, i + 2);
            if (!drawing.containsKey(towns)) {
                String answer = "NO SUCH ROUTE";
                return false;

            }
        }
        String answer = "VALID ROUTE";
        return true;
    }

    public Integer calculateDistanceBetweenFourTowns(String fourTowns) {
        String twoTownsFirst = fourTowns.substring(0,2);
        int distanceFirstTwoTowns = drawing.get(twoTownsFirst);

        String twoTownsSecond = fourTowns.substring(1,3);
        int distanceSecondTwoTowns = drawing.get(twoTownsSecond);

        String twoTownsThird = fourTowns.substring(2,4);
        int distanceSecondTwoTownsThree = drawing.get(twoTownsThird);

        String twoTownsFourth = fourTowns.substring(3,5);
        int distanceSecondTwoTownsFourth = drawing.get(twoTownsFourth);

        int distance3 = distanceFirstTwoTowns + distanceSecondTwoTowns +distanceSecondTwoTownsThree + distanceSecondTwoTownsFourth;
        return distance3;
    }

    public int calculateNoOfTrips(String startTown, String endTown) {
        int maxTrips = 0;
        String endTownNeighbor = "";
        String startTownNeighbor = "";
        String endTownOtherNeighbor = "";
        int maxTowns = 1;
        Set<String> routes = drawing.keySet();
        for (String route : routes) {
            if (route.startsWith(startTown)) {
                String routeReverse = new StringBuffer(route).reverse().toString();
                if (routes.contains(routeReverse)) {
                    maxTrips++;
                }
            }

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

    private boolean neighborsFoundInRoutes(String endTownNeighbor, String startTownNeighbor) {
        if((!startTownNeighbor.equals("")) && ((!endTownNeighbor.equals("")) && !(startTownNeighbor.equals(endTownNeighbor)))){
            String combineNeighbors = startTownNeighbor.concat(endTownNeighbor);
            if (drawing.containsKey(combineNeighbors)) {
                return true;
            }
        }
        return false;
    }
    public int calculateNoOfTripsWithMaxStops(String c, String c1, int i) {
        int maxTrips = calculateNoOfTrips("C","C");
        return maxTrips;
    }
}

//C-D-E-K-C   combinedNeighbors = DE
//C-K-E-D-C
//                if(route.startsWith(endTownNeighbor)){
//                    endTownOtherNeighbor = route.substring(1,2);
//                }
//                if (route.startsWith(endTownOtherNeighbor)&&route.endsWith(endTown)){
//                    maxTowns++;
//                    System.out.println(maxTowns);
//                }
