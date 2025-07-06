import java.util.regex.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        HashMap<String, PriorityQueue<String>> h = new HashMap<String, PriorityQueue<String>>();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < code.length; i++) {
            if (code[i].length() != 0 && ((businessLine[i].equals("electronics")) || (businessLine[i].equals("grocery"))
                    || (businessLine[i].equals("pharmacy")) || (businessLine[i].equals("restaurant"))) && isActive[i]) {
                Pattern p = Pattern.compile("^\\w+$");
                Matcher m = p.matcher(code[i]);
                if (m.find()) {
                    if (h.containsKey(businessLine[i])) {
                        PriorityQueue<String> pq = h.get(businessLine[i]);
                        pq.add(code[i]);
                    } else {
                        PriorityQueue<String> pq = new PriorityQueue<String>();
                        pq.add(code[i]);
                        h.put(businessLine[i], pq);
                    }
                }
            }
        }
        String str[] = { "electronics", "grocery", "pharmacy", "restaurant" };
        for (int i = 0; i < 4; i++) {
            if (h.containsKey(str[i])) {
                PriorityQueue<String> pq = h.get(str[i]);
                while (pq.size() > 0) {
                    res.add(pq.poll());
                }
            }
        }

        return res;

    }
}
