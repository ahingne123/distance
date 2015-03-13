package com.trains;

import com.trains.RouteMap;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RouteMapTest {
    @Test
    public void shouldCalculateDistanceBetweenTwoTowns() {
       Map<String,Integer> testInput = new HashMap<String, Integer>();
        testInput.put("AB",5);
        testInput.put("BC",4);
        RouteMap routemap = new RouteMap(testInput);
        Assert.assertEquals(Integer.valueOf(5), routemap.getDistanceBetweenTowns("AB"));
        Assert.assertEquals(Integer.valueOf(4), routemap.getDistanceBetweenTowns("BC"));
    }

    @Test
    public void shouldAddRoutes(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routeMap = new RouteMap(testInput);
        routeMap.addRoute("BC", 6);
        Assert.assertEquals(Integer.valueOf(6), routeMap.getDistanceBetweenTowns("BC"));
    }

    @Test
    public void shouldCalculateDistanceBetweenThreeTowns(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AB", 5);
        routemap.addRoute("BC", 4);
        Assert.assertEquals(Integer.valueOf(9),routemap.calculateDistanceBetweenThreeTowns("ABC"));
    }
    @Test
    public void shouldCalculateDistanceBetweenFourTowns(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AE", 7);
        routemap.addRoute("EB", 3);
        routemap.addRoute("BC", 4);
        routemap.addRoute("CD", 8);
        Assert.assertEquals(Integer.valueOf(22),routemap.calculateDistanceBetweenFourTowns("AEBCD"));
    }

    @Test
    public void shouldReturnOneWhenRouteAndItsReverseRouteExists(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTrips("C", "C",2));
    }

    @Test
    public void shouldReturnTwoTripsWhenRouteOneRouteExistBetweenStartAndEndTown(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTrips("C", "C",2));
    }

    @Test
    public void shouldReturnOneTripWithMaxTWoStops(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWithMaxStops("C", "C", 2));
    }

    @Test
    public void shouldReturnTwoTripsWithMaxThreeStopsWhenOnlyOneTripExistsHasTwoStops(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EC", 7);
        Assert.assertEquals(2,routemap.calculateNoOfTripsWithMaxStops("C", "C", 3));
    }

    @Test
    public void shouldReturnOneTripWithMaxTWoStopsWhenOnlyOneTripHasTwoStops(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWithMaxStops("C", "C", 2));
    }
}
