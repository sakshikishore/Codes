class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = 0, x = n;
        int sum = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x = x / 10;
        }
        int max = 0, min = 0;
        if (n > rev) {
            max = n;
            min = rev;
        } else {
            min = n;
            max = rev;
        }
        for (int i = min; i <= max; i++) {
            if (i == 1) {
                continue;
            }
            int flag = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
