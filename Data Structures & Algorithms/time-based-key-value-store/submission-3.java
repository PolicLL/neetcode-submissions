class TimeMap {

    private Map<String, TreeMap<Integer, String>> values;

    public TimeMap() {
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> map = values.get(key);
        if (map == null) {
            map = new TreeMap<Integer, String>();
        }

        map.put(timestamp, value);
        values.put(key, map);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = values.get(key);
        
        if (map == null) return "";
        String val = map.get(timestamp);

        if (val != null) return val;

        for (int i = timestamp; i >= 0; --i) {
            String temp = map.get(i);
            if (temp != null) return temp;
        }

        return "";
    }
}
