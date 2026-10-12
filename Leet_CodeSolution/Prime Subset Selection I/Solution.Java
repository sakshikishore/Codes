class Solution {
    public List<Integer> maxPrimes(int n, int s) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            int flag = 0;
            if(i%2==0 && i!=2)
            {
                continue;
            }
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = 1;
                }
            }
            if (flag == 0) {

                sum += i;
                if (sum <= s) {
                    result.add(i);
                }
                if (sum > s || sum == s) {
                    break;
                }
            }
        }

        return result;
    }
}
