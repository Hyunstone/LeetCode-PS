class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) count++;
        }
        return count;
    }

    private boolean isSymmetric(int number) {
        String strNum = Integer.toString(number);
        int len = strNum.length();
        if (len % 2 != 0) {
            return false;
        }
        String front = strNum.substring(0, len / 2);
        String back = strNum.substring(len / 2);
        int frontCount = caculateUnitNum(front);
        int backCount = caculateUnitNum(back);

        if (frontCount == backCount) {
            return true;
        }
        return false;
    }

    private int caculateUnitNum(String num) {
        int count = 0;
        for (char ch : num.toCharArray()) {
            count += ch - '0';
        }
        return count;
    }
}