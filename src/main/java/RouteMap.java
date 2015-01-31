package main.java;


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
}
