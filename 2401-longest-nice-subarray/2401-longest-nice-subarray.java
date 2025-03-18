class Solution {
    public int longestNiceSubarray(int[] nums) {
        int answer = 0;
        int mask = 0;

        for (int l = 0, r = 0; r < nums.length; r++) {
            while((mask & nums[r]) != 0) {
                mask ^= nums[l++];
            }
            mask |= nums[r];
            answer = Math.max(answer, r - l + 1);
        }

        return answer;
    }
}