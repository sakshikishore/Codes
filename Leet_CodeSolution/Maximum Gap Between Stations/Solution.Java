class Solution {
    public int maximumGap(String skill, String station) {
        int ans = 0;
        int suf[] = new int[station.length()];
        int j = skill.length() - 1;
        HashMap<Character, ArrayList<Integer>> h = new HashMap<Character, ArrayList<Integer>>();
        for (int i = station.length() - 1; i >= 0; i--) {
            int p = station.length() - i - 1;
            char c = station.charAt(p);
            if (!h.containsKey(c)) {
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(p);
                h.put(c, l);
            } else {
                ArrayList<Integer> l = h.get(c);
                l.add(p);
                h.put(c, l);
            }

            if (j >= 0 && station.charAt(i) == skill.charAt(j)) {
                if (i == station.length() - 1) {
                    suf[i] = 1;
                } else {
                    suf[i] = 1 + suf[i + 1];
                }
                j--;
            } else {
                if(i<station.length() - 1)
                suf[i] = suf[i + 1];
            }
        }
        int start = -1;
        for (int i = 0; i < skill.length(); i++) {
            if (i == 0) {
                ArrayList<Integer> l = h.get(skill.charAt(i));
                start = l.get(0);
                System.out.println(start);
            } else {
                ArrayList<Integer> l = h.get(skill.charAt(i));
                int x = l.get(l.size() - 1);
                if (suf[x] >= skill.length() - i) {
                    ans = Math.max(ans, x - start);
                } else {
                    int low = 0, high = l.size()-1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if(l.get(mid)<=start)
                        {
                            low=mid+1;
                            continue;
                        }
                        if (suf[l.get(mid)] >= skill.length() - i) {
                            x = l.get(mid);
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    ans = Math.max(ans, x - start);
                }
                   int low = 0,high = l.size()-1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if(l.get(mid)<=start)
                        {
                            low=mid+1;
                            continue;
                        }
                        if (suf[l.get(mid)] >= skill.length() - i) {
                            x = l.get(mid);
                        }
                        high=mid-1;
                    }

                start = x;
            }
        }

        return ans;
    }
}
