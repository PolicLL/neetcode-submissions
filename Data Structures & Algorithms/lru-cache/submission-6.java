class LRUCache {

    private Map<Integer, Integer> map;

    private int MAX_SIZE = 0;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();

        MAX_SIZE = capacity;
    }
    
    public int get(int key) {
        if (map.get(key) == null) return -1;

        //System.out.println(map);

        Integer removedValue = map.remove(key);
        map.put(key, removedValue);

        //printMap();

        return removedValue;
    }
    
    public void put(int key, int value) {
        if (map.get(key) != null)
            map.remove(key);
        map.put(key, value);

        if (map.size() > MAX_SIZE) {
            map.remove(map.entrySet().iterator().next().getKey());
        }

        //printMap();
    }

    private void printMap() {
        System.out.println(map);
    }
}
