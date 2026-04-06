class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!freq.containsKey(s.charAt(i))) {
                freq.put(s.charAt(i), 1);
            } else {
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            }
        }
        int j = 25;
        for (int i = 0; i < 13; i++) {
            char c = (char) (97 + i);
            char m = (char) (97 + j);
            int freq1 = 0, freq2 = 0;
            if (freq.containsKey(c)) {
                freq1 = freq.get(c);
            }
            if (freq.containsKey(m)) {
                freq2 = freq.get(m);
            }
            sum += Math.abs(freq1 - freq2);
            j--;
        }
        j = 9;
        for (int i = 0; i < 5; i++) {
            char c = (char) (48 + i);
            char m = (char) (48 + j);
            int freq1 = 0, freq2 = 0;
            if (freq.containsKey(c)) {
                freq1 = freq.get(c);
            }
            if (freq.containsKey(m)) {
                freq2 = freq.get(m);
            }
            sum += Math.abs(freq1 - freq2);
            j--;
        }

        return sum;
    }
}
