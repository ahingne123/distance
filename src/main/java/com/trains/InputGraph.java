package com.trains;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InputGraph {
    private Map<String, Integer> differentRoutes = new HashMap<>();

    public Map<String, Integer> read(BufferedReader bufferedReader) throws IOException {

        String line = bufferedReader.readLine();

        String parts[] = line.split(" *: *", 2);
        String townsWithDistance[] = parts[1].split(",");

        bufferedReader.close();
        for (int i = 0; i < townsWithDistance.length; i++) {
            String towns = townsWithDistance[i].substring(0, 2);
            int distance = Integer.parseInt(townsWithDistance[i].substring(2, 3));
            differentRoutes.put(towns, distance);
        }
        return differentRoutes;

    }
}
