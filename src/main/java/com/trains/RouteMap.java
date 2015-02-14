package com.trains;


import java.util.HashMap;
import java.util.Map;

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


}
