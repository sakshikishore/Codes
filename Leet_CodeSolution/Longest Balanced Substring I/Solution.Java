class Solution {
    public int longestBalanced(String s) {
        int ans = 1;
        if (s.length() > 1) {
            ans = 2;
        }
        for (int i = 0; i < s.length(); i++) {
            int ch[] = new int[26];
            if (s.length() - i > ans) {

                for (int j = i; j < s.length(); j++) {
                    ch[s.charAt(j) - 'a']++;
                    if (j > i + 1 && j + 1 - i > ans) {
                        int val = ch[s.charAt(i) - 'a'];
                        int flag = 0;
                        for (int k = 0; k < 26; k++) {
                            if (ch[k] != 0) {
                                if (ch[k] != val) {
                                    flag = 1;
                                    break;
                                }
                            }
                        }
                        if (flag == 0) {
                            ans = j - i + 1;
                        }
                    }
                }
            } else {
                break;
            }
        }

        return ans;
    }
}
