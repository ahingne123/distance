package com.trains;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RouteMap {
    private Map<String, Integer> drawing = new HashMap<String, Integer>();
    String route;
    String newRoutesEndTown;

    public RouteMap(Map<String, Integer> input) {
        this.drawing = input;
    }

    public Integer getDistanceBetweenTowns(String towns) {
        return drawing.get(towns);
    }

    public void addRoute(String route, int distance) {
        drawing.put(route, distance);
    }

    public Integer calculateDistanceBetweenThreeTowns(String threeTowns) {

        String firstTwoTowns = threeTowns.substring(0, 2);
        int distanceFirstTwoTowns = drawing.get(firstTwoTowns);
        String secondTwoTowns = threeTowns.substring(1, 3);
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
        String firstTwoTowns = fourTowns.substring(0, 2);
        int distanceFirstTwoTowns = drawing.get(firstTwoTowns);

        String secondTwoTowns = fourTowns.substring(1, 3);
        int distanceSecondTwoTowns = drawing.get(secondTwoTowns);

        String thirdTwoTowns = fourTowns.substring(2, 4);
        int distanceThirdTwoTowns = drawing.get(thirdTwoTowns);

        String distanceFourthTwoTowns = fourTowns.substring(3, 5);
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

            if (twoStopRouteExists(startTown, routes, route)) {
                maxTrips++;
            }
            if (maxTrips != 0 && maxNoOfStops == 2) {
                break;
            }
            if (route.startsWith(startTown)) {
                startTownNeighbor = route.substring(1, 2);
            }
            if (route.endsWith(endTown)) {
                endTownNeighbor = route.substring(0, 1);
            }
            if (neighborsFoundInRoutes(endTownNeighbor, startTownNeighbor)) {
                maxTrips++;
                startTownNeighbor = "";
                endTownNeighbor = "";
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
        if ((!startTownNeighbor.equals("")) && ((!endTownNeighbor.equals("")) && !(startTownNeighbor.equals(endTownNeighbor)))) {
            String combineNeighbors = startTownNeighbor.concat(endTownNeighbor);
            if (drawing.containsKey(combineNeighbors)) {
                return true;
            }
        }
        return false;
    }

    public int calculateNoOfTripsWithMaxStops(String startTown, String endTown, int stops) {
        int maxTrips = calculateNoOfTrips("C", "C", stops);
        return maxTrips;
    }

    public int calculateNoOfTripsWhenStartAndEndStopNotTheSame(String startTown, String endTown, int stops) {

        int maxTrips = 0;
        int incrementStops = 0;

        Set<String> routes = drawing.keySet();
        for (String route : routes) {
            if (route.startsWith(startTown)) {
                incrementStops++;
                String endingTown = getRoutesEndTown(route);

                ArrayList<String> nextSetOfRoutes;
                nextSetOfRoutes = getNextSetOfRoutes(endingTown);
                incrementStops++;
                for (String aRoute : nextSetOfRoutes) {
                    endingTown = getRoutesEndTown(aRoute);
                    String individualRoute = getIndividualRouteWithEndingTown(endingTown);
                    String moreRoute = areThereMoreRoutesWithThatIndividualRoute(endingTown, individualRoute);
                    incrementStops++;
                    if (moreRoute.equals("same route")) {
                        endingTown = getRoutesEndTown(individualRoute);
                    } else {
                        endingTown = getRoutesEndTown(moreRoute);
                    }
                    individualRoute = getIndividualRouteWithEndingTown(endingTown);
                    incrementStops++;
                    if (incrementStops > 3 && !individualRoute.endsWith("C")) {
                        String routeEndingInC = findIfThereIsARouteThatEndsInC(individualRoute);
                        if (routeEndingInC != null) {
                            maxTrips++;
                        }
                    }
                    if (incrementStops > 3 && individualRoute.endsWith("C")) {
                        maxTrips++;
                    }
                }

            }

        }
        return maxTrips;
    }

    private String areThereMoreRoutesWithThatIndividualRoute(String endingTown, String individualRoute) {
        Set<String> routes = drawing.keySet();
        String sameRoute = "";
        for (String route : routes) {
            if (route.startsWith(endingTown)) {
                if (route.equals(individualRoute)) {
                    sameRoute = "same route";
                } else {
                    sameRoute = route;
                }
            }
        }
        return sameRoute;
    }

    private String findIfThereIsARouteThatEndsInC(String individualRoute) {
        Set<String> routes = drawing.keySet();
        String beginWith = individualRoute.substring(0, 1);
        for (String route : routes) {
            if (route.startsWith(beginWith) && route.endsWith("C")) {
                return route;
            }
        }
        return null;
    }

    private String getIndividualRouteWithEndingTown(String endingTown) {
        Set<String> routes = drawing.keySet();
        for (String route : routes) {
            if (route.startsWith(endingTown)) {
                return route;
            }
        }
        return null;
    }

    private String getRoutesEndTown(String route) {
        String routeEndTown = route.substring(1, 2);
        return routeEndTown;
    }

    public ArrayList<String> getNextSetOfRoutes(String town) {
        Set<String> routes = drawing.keySet();
        ArrayList<String> ofRoutes = new ArrayList<>();
        for (String route : routes) {
            if (route.startsWith(town)) {
                ofRoutes.add(route);
            }
        }
        return ofRoutes;
    }
}



//Step 7: End list

//getting rid of comments
//renaming variables
//removing duplication using methods
//commit
//debug why comp test is failing
//another test for scenario failing
