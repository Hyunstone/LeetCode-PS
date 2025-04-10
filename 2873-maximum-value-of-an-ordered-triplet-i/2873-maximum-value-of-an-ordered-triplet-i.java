class Solution {
    public long maximumTripletValue(int[] nums) {
        long max = -1;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    long temp = (long)(nums[i] - nums[j]) * nums[k];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }
        if (max < 0) {
            return 0;
        }
        return max;
    }
}