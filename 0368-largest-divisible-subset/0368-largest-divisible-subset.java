class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (dp[max] < dp[i]) {
                max = i;
            }
        }

        int m = dp[max];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = max; m > 0; --i) {
            if (nums[max] % nums[i] == 0 && dp[i] == m) {
                arr.add(nums[i]);
                max = i;
                --m;
            }
        }
        if (arr.size() == 0) {
            arr.add(nums[0]);
            return arr;
        }
        return arr;
    }
}