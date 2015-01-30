package main.java;

import junit.framework.Assert;
import org.junit.Test;

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

//    @Test
//    public void shouldCalculateDistanceBetweenThreeTowns() {
//        String testInput = "Graph: AB5 BC4";
//        RouteMap routemap = new RouteMap(testInput);
//        routemap.getDistanceBetweenTowns("ABC");
//        Assert.assertEquals(Integer.valueOf(9), routemap.getDistanceBetweenTowns("ABC"));
//    }

}
