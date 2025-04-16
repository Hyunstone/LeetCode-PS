class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        int pairCnt = 0;
        long result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            int prev = freq.getOrDefault(num, 0);
            pairCnt += prev;
            freq.put(num, prev + 1);

            while(pairCnt >= k) {
                result += (nums.length - right);
                int leftNum = nums[left];
                int count = freq.get(leftNum);
                pairCnt -= (count - 1);
                freq.put(leftNum, count - 1);
                left++;
            }
        }
        return result;
    }
}