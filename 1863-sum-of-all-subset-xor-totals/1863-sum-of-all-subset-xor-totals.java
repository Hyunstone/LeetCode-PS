class Solution {
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int answer = 0;

        for (int i = 0; i < 1 << n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1) {
                    sum ^= nums[j];
                }
            }
            answer += sum;    
        }

        return answer;
    }
}