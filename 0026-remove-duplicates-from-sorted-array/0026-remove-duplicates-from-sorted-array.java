class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            if (numSet.contains(num)) {
                count++;
            } else {
                numSet.add(num);
            }
        }

        int[] temp = numSet.stream().mapToInt(i -> i).toArray();
        Arrays.sort(temp);

        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }

        return nums.length - count;
    }
}