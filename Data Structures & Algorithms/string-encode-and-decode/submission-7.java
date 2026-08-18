class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();

        int size = strs.size();

        for(int i = 0; i < size; ++i) {
            String val = strs.get(i);

            if (val.length() == 0) {
                sb.append("null");
            } else {
                sb.append(val);
            }

            if (i < (size - 1))
                sb.append("\n");
        }

        System.out.println(sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("")) return List.of();

        String[] input = str.split("\n");

            System.out.println("size: " + input.length);

        List<String> res = new ArrayList<>();

        for(String s : input) {
            if (s.equals("null")) {
                res.add("");
            } else {
                res.add(s);
            }
        }

        return res;
    }
}
