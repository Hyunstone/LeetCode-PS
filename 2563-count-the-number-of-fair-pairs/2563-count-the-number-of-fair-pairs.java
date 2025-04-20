class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        long answer = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = findLowerBound(nums, i + 1, nums.length - 1, lower - nums[i]);
            int right = findUpperBound(nums, i + 1, nums.length - 1, upper - nums[i]);
            if (left <= right) {
                answer += right - left + 1;
            }
        }
        return answer;
    }

    private int findLowerBound(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int findUpperBound(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}