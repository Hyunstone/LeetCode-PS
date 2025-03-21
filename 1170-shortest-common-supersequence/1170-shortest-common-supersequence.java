class Solution {
    int[][]dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n;
        int j = m;

        while (i > 0 || j > 0) {
            if (i == 0) {
                lcs.append(str2.charAt(j - 1));
                j--;
            } else if (j == 0) {
                lcs.append(str1.charAt(i - 1));
                i--;
            } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                lcs.append(str1.charAt(i - 1));
                i--;
            } else {
                lcs.append(str2.charAt(j - 1));
                j--;
            }
        }
        return lcs.reverse().toString();
    }
}

