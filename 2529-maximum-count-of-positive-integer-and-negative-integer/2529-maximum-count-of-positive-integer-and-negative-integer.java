class Solution {
    public int maximumCount(int[] nums) {
        int posNum = 0;
        int negNum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negNum++;
            }
            else if (nums[i] == 0) {
                continue;
            } else {
                posNum = nums.length - i;
                break;
            }
        }

        if (negNum > posNum) {
            return negNum;
        } else {
            return posNum;
        }
    }
}