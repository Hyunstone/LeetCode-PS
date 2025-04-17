class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            for (int left = 0; left < right; left++) {
                if ((nums[left] == nums[right]) && ((left * right) % k == 0)) {
                    count++;
                }
            }
        }
        return count;
    }
}