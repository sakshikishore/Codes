class Solution {
    public int minCharacters(String a, String b) {
        // Case 3
        int count = 0, res = 0;
        int ch1[] = new int[26];
        int ch2[] = new int[26];
        for (int i = 0; i < a.length(); i++) {
            ch1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            ch2[b.charAt(i) - 'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (ch1[i] + ch2[i] > max) {
                max = ch1[i] + ch2[i];
            }
        }
        int flag = 0;
        for (int i = 0; i < 26; i++) {
            if (ch1[i] + ch2[i] != max) {
                count += ch1[i] + ch2[i];
            } else if (flag == 1) {
                count += ch1[i] + ch2[i];
            } else {
                flag = 1;
            }
        }
        res = count;
        // Case1:
        count = 0;
        for (int i = 0; i < 26; i++) {
            if (ch2[i] != 0) {
                int c = 0;
                for (int j = i; j < 26; j++) {
                    c += ch1[j];
                }
                if(i==0 && ch1[0]==0)
                {
                    res=Math.min(res,count+c+ch2[0]);
                }
                else
                {
                    if(i!=0)
                    {
                        res=Math.min(res,count+c);
                    }

                }
                if (c <= ch2[i]) {
                    if(i!=0)
                    {
                    count += c;
                    break;
                    }
                } 
                    if (ch1[25] != 0) {
                        count += ch1[25];
                        ch1[25] = 0;
                        count += ch2[i];
                    } else {
                        count += ch2[i];
                    }
                
            }
        }
        res = Math.min(count, res);
        // Case2

        count = 0;
        ch1 = new int[26];
        ch2 = new int[26];
        for (int i = 0; i < a.length(); i++) {
            ch1[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            ch2[b.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ch1[i] != 0) {
                int c = 0;
                for (int j = i; j < 26; j++) {
                    c += ch2[j];
                }
                 if(i==0 && ch2[0]==0)
                {
                    res=Math.min(res,count+c+ch1[i]);
                }
                else
                {
                    if(i!=0)
                    {
                        res=Math.min(res,count+c);
                    }

                }
                if (c <= ch1[i]) {
                     if(i!=0)
                    {
                    count += c;
                    break;
                    }
                } 
                    if (ch2[25] != 0) {
                        count += ch2[25];
                        ch2[25] = 0;
                        count += ch1[i];
                    } else {
                        count += ch1[i];
                    }
            }
        }
        res = Math.min(count, res);
         

        return res;

    }

}
