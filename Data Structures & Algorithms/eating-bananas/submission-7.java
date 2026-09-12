class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int start = 1, end = piles[piles.length - 1];
        int minSpeed = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int needed = hours(piles, mid);
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

    private int hours(int[] piles, int speed) {
        int hour = 0;

        for (int i = 0; i < piles.length; ++i) {
            hour += (int) Math.ceil((double) piles[i] / speed);
        }

        System.out.println("For speed " + speed + " res is : " + hour);

        return hour;
    }
}
