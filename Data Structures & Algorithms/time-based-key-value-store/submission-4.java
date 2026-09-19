class TimeMap {

    private Map<String, TreeMap<Integer, String>> values;

    public TimeMap() {
        values = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        values.computeIfAbsent(key, k -> new TreeMap<>())
            .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> map = values.get(key);

        if (map == null) {
            return "";
        }

        Map.Entry<Integer, String> entry = map.floorEntry(timestamp);

        return entry != null ? entry.getValue() : "";
    }
}
