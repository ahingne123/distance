package com.trains;


import org.junit.Test;
import junit.framework.Assert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputGraphTest {


    @Test
    public void testInputGraph() throws IOException {
        InputGraph inputGraph = new InputGraph();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/ThoughtWorker/if-day/Trains/src/test/testInput"));
        Map<String, Integer> routes;
        routes = inputGraph.read(bufferedReader);

        Map<String, Integer> expectedRoute = new HashMap<>();
        expectedRoute.put("AB", 5);
        expectedRoute.put("BC", 4);
        Assert.assertEquals(expectedRoute, routes);

    }


}
