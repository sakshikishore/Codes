class Solution {
    public int maxDifference(String s) {
        int arr[] = new int[26];
        int minEven = 100, maxOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                if (arr[i] % 2 == 0) {
                    if (arr[i] < minEven) {
                        minEven = arr[i];
                    }
                } else {
                    if (arr[i] > maxOdd) {
                        maxOdd = arr[i];
                    }
                }
            }
        }

        return maxOdd - minEven;
    }
}
