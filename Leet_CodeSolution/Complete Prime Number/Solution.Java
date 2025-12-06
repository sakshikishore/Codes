import java.math.BigInteger;
class Solution {
    public boolean completePrime(int num) {
        int x = num;
        int r = 0;
        int i = 0;
        int rev = 0;
        while (x > 0) {
            int p = x % 10;
            r = p * (int)Math.pow(10, i) + r;
            i++;
            rev = rev * 10 + p;
            x = x / 10;
            if (!BigInteger.valueOf(r).isProbablePrime(100)) {
                return false;
            }
        }
        x = 0;
        while (rev > 0) {
            int p = rev % 10;
            x = x * 10 + p;
            if (!BigInteger.valueOf(x).isProbablePrime(100)) {
                return false;
            }
            rev = rev / 10;
        }

        return true;
    }
}
