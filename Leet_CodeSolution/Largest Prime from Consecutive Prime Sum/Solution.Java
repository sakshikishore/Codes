import java.math.BigInteger;

class Solution {
    public int largestPrime(int n) {
        int sum = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            int flag = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                if (sum + i > n) {
                    return result;
                }
                sum += i;
                if (i == 2 || i == 3) {
                    result = sum;
                } else {
                    flag=0;
                    for (int j = 2; j * j <= sum; j++) {
                        if (sum % j == 0) {
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==0)
                    {
                        result=sum;
                    }
                    
                }

            }
        }

        return sum;

    }
}
