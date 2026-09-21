class Solution {
    public int minOperations(String s) {
        StringBuffer sb = new StringBuffer(s);
        int ans = Integer.MAX_VALUE;
        for (int k = 0; k < s.length(); k++) {
            int i = 0, j = s.length() - 1;
            int count = k;
            while (i < j) {
                if (sb.charAt(i) != sb.charAt(j)) {
                    int x = sb.charAt(i) - 'a';
                    int y = sb.charAt(j) - 'a';
                    if (x > y) {
                        count += Math.min(x - y, 26 - x + y);
                    } else {
                        count += Math.min(y - x, 26 + x - y);
                    }
                }
                i++;
                j--;
            }
            ans = Math.min(ans, count);
            char c=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
        }

        return ans;
    }
}
