class Solution {
    public String maximumXor(String s, String t) {
        int countOne = 0, countZero = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '1') {
                countOne++;
            } else {
                countZero++;
            }
        }
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (countZero != 0) {
                    res.append("1");
                    countZero--;
                } else {
                    res.append("0");
                }
            } else {
                if (countOne != 0) {
                    res.append("1");
                    countOne--;
                } else {
                    res.append("0");
                }
            }
        }

        return new String(res);
    }
}
