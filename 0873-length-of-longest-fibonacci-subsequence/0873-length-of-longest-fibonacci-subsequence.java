class Solution {
    Map<Integer, Boolean> numMap = new HashMap<>();
    public int lenLongestFibSubseq(int[] arr) {
        for (int num : arr) {
            numMap.put(num, true);
        }
        int max = 2;
        int arrLen = arr.length;

        for (int i = 0; i < arrLen; i++) {
            for (int j = i + 1; j < arrLen; j++) {
                int temp = 2;
                int a = arr[j];
                int b = arr[i] + arr[j];

                while(numMap.containsKey(b)) {
                    int tem = a;
                    a = b;
                    b = tem + b;
                    temp++;
                }

                if (temp > max) {
                    max = temp;
                }
            }
        }

        if (max == 2) {
            return 0;
        } 
        return max;
    }
}