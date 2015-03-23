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
    public void shouldReturnTwoTripsWithMaxThreeStopsBetweenCAndC(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EC", 7);
        Assert.assertEquals(2,routemap.calculateNoOfTripsWithMaxStops("C", "C", 3));
    }

    @Test
    public void shouldReturnOneTripWithMaxTWoStopsBetweenCAndC(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWithMaxStops("C", "C", 2));
    }

    @Test
    public void shouldReturnTripsWithMaxFourStops(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AB", 7);
        routemap.addRoute("BC", 7);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("AD", 7);
        routemap.addRoute("CE", 7);
        routemap.addRoute("EB", 7);
        routemap.addRoute("AE", 7);
        Assert.assertEquals(3,routemap.calculateNoOfTripsWhenStartAndEndStopNotTheSame("A", "C", 4));



        //Step 1: Iterate through list
        //Step 2: Find route that starts with start town, if yes, increment stops AB - 1
        //Step 3: Get route's end town and see if a route begins from there, if yes, increment stops   BC - 2
        //Step 4: Get route from step 3 and find route that begins with that route's end town. If found, increment stops  CD - 3
        //Step 5: Get route from step 4 and find route that begins with that route's end town and ends with end town. If found, increment stops   DC - 4
        //Step 6: If increment stops = 4, trips =1
        //Step 7: End list
    }
    @Test
    public void shouldReturnTripsWithMaxFourStopsOne(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AB", 7);
        routemap.addRoute("BC", 7);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWhenStartAndEndStopNotTheSame("A", "C", 4));
    }

    @Test
    public void shouldReturnTripsWithMaxFourStopsTwo(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AD", 7);
        routemap.addRoute("DC", 7);
        routemap.addRoute("CD", 7);
        routemap.addRoute("DC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWhenStartAndEndStopNotTheSame("A", "C", 4));
    }

    @Test
    public void shouldReturnTripsWithMaxFourStopsThree(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AD", 7);
        routemap.addRoute("DE", 7);
        routemap.addRoute("EB", 7);
        routemap.addRoute("BC", 7);
        Assert.assertEquals(1,routemap.calculateNoOfTripsWhenStartAndEndStopNotTheSame("A", "C", 4));
    }
    @Test
    public void shouldReturnRouteThatStartsWithTown(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AB", 7);
        Assert.assertEquals("AB", routemap.getRouteBeginsWith("A"));

    }
    @Test
    public void shouldReturnRouteNotFoundWhenNoRouteStartingWithTownFound(){
        Map<String,Integer> testInput = new HashMap<String, Integer>();
        RouteMap routemap = new RouteMap(testInput);
        routemap.addRoute("AB", 7);
        Assert.assertEquals("no route found",routemap.getRouteBeginsWith("M"));
    }
}

