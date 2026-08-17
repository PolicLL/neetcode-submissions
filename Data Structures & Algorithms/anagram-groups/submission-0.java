class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String value : strs) {
            char[] tempArray = value.toCharArray();
            Arrays.sort(tempArray);
            String sorted = new String(tempArray);
            if (map.containsKey(sorted)) {
                map.get(sorted).add(value);
            }
            else {
                map.put(sorted, new ArrayList(List.of(value)));
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
