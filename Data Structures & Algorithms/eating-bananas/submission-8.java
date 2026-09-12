class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int start = 1, end = piles[piles.length - 1];
        int minSpeed = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int needed = neededHours(piles, mid);
            if (needed <= h && mid < minSpeed) {
                minSpeed = mid;
            }
            if (needed > h) {
                start = mid + 1;
            }
            else end = mid - 1;
        }

        return minSpeed;
    }

    private int neededHours(int[] piles, int speed) {
        int hours = 0;

        for (int i = 0; i < piles.length; ++i) {
            hours += (int) Math.ceil((double) piles[i] / speed);
        }

        return hours;
    }
}
