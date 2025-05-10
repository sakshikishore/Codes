class Solution {
    public int lengthLongestPath(String input) {
        int result = 0;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int i = 0;
        int len = 0, count = 0;
        String str[] = input.split("");
        int flag=0;
        while (i < input.length() && !str[i].equals("\n")) {
            if(str[i].equals("."))
            {
                flag=1;
            }
            len++;
            i++;
        }
        if(flag==1)
        {
            result=len;
        }
        h.put(0, len);
        while (i < str.length) {
            i++;
            flag = 0;
            count = 0;
            len = 0;
            while (i < str.length && str[i].equals("\t")) {
                i++;
                count++;
            }
            while (i < str.length && !str[i].equals("\n")) {
                if (str[i].equals(".")) {
                    flag = 1;
                }
                len++;
                i++;
            }
            int p=len;
            if(h.containsKey(count-1))
            {
             p = len + h.get(count - 1) + 1;
            }
            if (flag == 1) {
                result = Math.max(p, result);
            }
            h.put(count, p);
        }
        return result;
    }
}
