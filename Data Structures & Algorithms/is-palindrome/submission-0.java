class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder converted = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                converted.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int start = 0;
        int end = converted.length() - 1;
        String clean = converted.toString();

        while(start <= end) {
            if (clean.charAt(start++) != (clean.charAt(end--))) return false;
        }

        return true;
    }
}
