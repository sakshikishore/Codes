class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<Integer>();
        String str[] = num.split("");
        List<List<String>> list = new ArrayList();
        List<String> l = new ArrayList<String>();
        l.add(str[0]);
        list.add(l);
        for (int i = 1; i < str.length; i++) {
            long x = Long.parseLong(str[i]);
            String s = str[i];
            List<String> al = new ArrayList<String>();
            for (int j = i - 1; j >= 0; j--) {
                if (s.length() == 1 || s.charAt(0) != '0') {
                    l = list.get(j);
                    for (int p = 0; p < l.size(); p++) {
                        String s1 = l.get(p);
                        String st[] = s1.split(" ");
                        if (st.length == 1) {
                            al.add(st[0] + " " + s);
                        } else {
                            int a = Integer.parseInt(st[st.length - 1]);
                            int b = Integer.parseInt(st[st.length - 2]);
                            if (a + b == x) {

                                al.add(s1 + " " + s);
                            }
                        }
                    }

                }

                long y = Long.parseLong(str[j]);
                y = y * ((long) Math.pow(10, s.length())) + x;
                if (y > Integer.MAX_VALUE) {
                    break;
                } else {
                    x = y;
                    s = str[j] + s;
                }
            }
            if (x <= Integer.MAX_VALUE) {
                if (s.charAt(0) != '0') {
                    al.add(s);
                }
            }

            if (al.size() == 0) {
                return result;
            }
            list.add(al);
        }

        List<String> alist = list.get(list.size() - 1);
        for (int i = 0; i < alist.size(); i++) {
            String z[] = alist.get(i).split(" ");
            if (z.length > 2) {
                for (int c = 0; c < z.length; c++) {
                    result.add(Integer.parseInt(z[c]));
                }
                break;
            }
        }

        return result;
    }
}
