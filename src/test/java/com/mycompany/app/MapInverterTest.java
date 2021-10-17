package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MapInverterTest {
    private Map<Integer, List<Integer>> map;
    private MapInverter<Integer, Integer> mapInverter;

    @Before
    public void setup() {        
    }

    @Test
    public void GivenEmptyMap_ShouldReturnEmptyMap () {
        map = new HashMap<>();
        mapInverter = new MapInverter<>(map);
        Map<Integer, List<Integer>> actual = mapInverter.invert();
        assertTrue(actual.isEmpty());
    }

    @Test
    public void GivenAMapWith1KeyWhoseValueisASingleton_ShouldReplaceKeyAndValue () {
        map = new HashMap<>();
        map.put(1, List.of(2));
        mapInverter = new MapInverter<>(map);
        Map<Integer, List<Integer>> actual = mapInverter.invert();
        assertEquals(Map.of(2, List.of(1)), actual);
    }    
}
