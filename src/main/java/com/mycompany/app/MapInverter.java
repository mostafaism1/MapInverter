package com.mycompany.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapInverter<K, V> {
    private Map<K, List<V>> map;

    public MapInverter(Map<K, List<V>> map) {
        this.map = map;
    }
    
    public Map<V, List<K>> invert() {
        Map<V, List<K>> result = new HashMap<>();
        for (Entry<K, List<V>> entry : map.entrySet()) {
            for (V value: entry.getValue()) {
                if (result.containsKey(value)) {
                    result.get(value).add(entry.getKey());
                }
                else {
                    List<K> list = new ArrayList<>();
                    list.add(entry.getKey());
                    result.put(value, list);
                }
            }            
        }
        
        return result;
    }    
}
