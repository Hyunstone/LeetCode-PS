class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> leftNums = new ArrayList<>();
        List<Integer> rightNums = new ArrayList<>();
        List<Integer> pivotNums = new ArrayList<>();

        for (int num: nums) {
            if (num < pivot) {
                leftNums.add(num);
            } else if (num > pivot) {
                rightNums.add(num);
            } else {
                pivotNums.add(num);
            }
        }

        leftNums.addAll(pivotNums);
        leftNums.addAll(rightNums);

        return leftNums.stream().mapToInt(i -> i).toArray();
    }
}