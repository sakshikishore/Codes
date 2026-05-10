import java.util.regex.*;

class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        int arr[] = new int[queries.length];
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < chunks.length; i++) {
            sb.append(chunks[i]);
        }
        String s = new String(sb);
        String[] str = s.trim().split("-+\\s+-+|\\s+-+|-+\\s+|\\s+|--+|^-|-$");
        for (int i = 0; i < str.length; i++) {
            if (!h.containsKey(str[i])) {
                h.put(str[i], 1);
            } else {
                h.put(str[i], h.get(str[i]) + 1);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (h.containsKey(queries[i])) {
                arr[i] = h.get(queries[i]);
            }
        }

        return arr;

    }
}
