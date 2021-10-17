package com.mycompany.app;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String sourcePath = "map.json";
        String destinationPath = "inverterMap.json";
        Map<String, List<String>> map = readJsonFromFile(sourcePath);
        MapInverter<String, String> mapInverter = new MapInverter<String, String>(map);
        Map<String, List<String>> invertedMap = mapInverter.invert();
        writeJsonToFile(invertedMap, destinationPath);
    }

    private static Map<String, List<String>> readJsonFromFile(String sourcePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, List<String>> map =  objectMapper.readValue(new File(sourcePath), new TypeReference<Map<String,List<String>>>(){});
        return map;
    }

    private static void writeJsonToFile(Map<String, List<String>> invertedMap, String destinationPath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(destinationPath), invertedMap);
    }
}
