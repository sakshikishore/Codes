class Solution {
    public String trimTrailingVowels(String s) {
        int j = s.length() - 1;
        while (j >= 0 && (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o'
                || s.charAt(j) == 'u')) {
            j--;
        }
        if (j == -1) {
            return "";
        }

        return s.substring(0, j + 1);
    }
}
