package Leetcode;


class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = values[0];

        for (int i = 1; i < n; i++) {
            maxScore = Math.max(maxScore, dp[i - 1] + values[i] - i);
            dp[i] = Math.max(dp[i - 1], values[i] + i);
        }
        return maxScore;
    }
}

