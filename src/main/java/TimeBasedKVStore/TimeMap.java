package TimeBasedKVStore;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> kvStore;

    public TimeMap() {
        kvStore = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeStampValue;

        if(kvStore.containsKey(key)){
            timeStampValue = kvStore.get(key);
        }else{
            timeStampValue = new TreeMap<>();
        }

        timeStampValue.put(timestamp, value);
        kvStore.put(key, timeStampValue);
    }

    public String get(String key, int timestamp) {
        if(!kvStore.containsKey(key))
            return "";

        TreeMap<Integer, String> timeStampValues = kvStore.get(key);

        SortedMap<Integer, String> sortedMap = timeStampValues.headMap(timestamp, true);

        if(sortedMap.isEmpty())
            return "";

        return sortedMap.get(sortedMap.lastKey());
    }
}
