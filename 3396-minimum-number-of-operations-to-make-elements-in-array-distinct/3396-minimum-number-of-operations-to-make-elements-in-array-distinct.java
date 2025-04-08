class Solution {
    static int count = 0;
    public int minimumOperations(int[] nums) {
        return execute(nums, 0);
    }

    private int execute(int[] nums, int count) {
        if (isDistinct(nums)) {
            return count;
        } else if (nums.length < 3) {
            return isDistinct(nums) ? count : count + 1;
        } else {
            int[] arr = Arrays.copyOfRange(nums, 3, nums.length);
            return execute(arr, count + 1);
        }
    }
    
    private Boolean isDistinct(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return false;
            }
        }
        return true;
    }
}