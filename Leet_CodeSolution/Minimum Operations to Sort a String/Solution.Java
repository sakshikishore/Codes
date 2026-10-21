class Solution {
    public int minOperations(String s) {
        if (s.length() == 1) {
            return 0;
        }
        int arr[] = new int[26];
        int low = 26, high = -1;
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if (s.charAt(i) - 'a' < low) {
                low = s.charAt(i) - 'a';
            }
            if (s.charAt(i) - 'a' > high) {
                high = s.charAt(i) - 'a';
            }
            if (i != 0) {
                if (s.charAt(i) < s.charAt(i - 1)) {
                    flag = 1;
                }
            }
        }
        if (flag == 0) {
            return 0;
        }
        if (s.length() == 2) {
            return -1;
        }
        if (s.charAt(0) - 'a' == high && s.charAt(s.length() - 1) - 'a' == low) {
            if (arr[low] == 1 && arr[high] == 1) {
                return 3;
            } else {
                return 2;
            }
        }
        if (s.charAt(0) - 'a' == low || s.charAt(s.length() - 1) - 'a' == high) {
            return 1;
        }
        return 2;

    }
}
