class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> uniqueValues = new HashSet<>();
        int minValue = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            uniqueValues.add(num);
            minValue = Math.min(minValue, num);
        }

        int operations = uniqueValues.size();
        if (minValue == k) {
            operations--;
        }

        return operations;
    }
}