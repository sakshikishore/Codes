class Solution {
    public int minRotations(int n, String s) {
        int suf[] = new int[s.length()];
        int curr = 0;
        int lastDigit = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - '0';
            if (i == s.length() - 1) {
                lastDigit = digit;
            }
            int a = Math.abs(digit - curr);
            int b = 0;
            if (digit > curr) {
                b = curr - digit + 10;
            } else {
                b = digit - curr + 10;
            }
            if (i == s.length() - 1) {
                suf[i] = Math.min(a, b);
            } else {
                suf[i] = suf[i + 1] + Math.min(a, b);
            }
            curr = digit;
        }
        int ans = suf[0];
        int pref = 0;
        curr = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            int min = Integer.MAX_VALUE;
            int a = Math.abs(digit - curr);
            int b = 0;
            if (digit > curr) {
                b = curr - digit + 10;
            } else {
                b = digit - curr + 10;
            }
            min = Math.min(a, b);
            if (i == 0) {
                pref = min;
            } else {
                int p = suf[i] - suf[suf.length - 1];
                a = Math.abs(lastDigit - curr);
                b = 0;
                if (lastDigit > curr) {
                    b = curr - lastDigit + 10;
                } else {
                    b = lastDigit - curr + 10;
                }
                int x = Math.min(a, b);
                ans = Math.min(ans, pref + x + p);
                pref = pref + min;

            }

            curr = digit;
        }

        return ans;

    }
}
