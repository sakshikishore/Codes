class Solution {
    public boolean closeStrings(String word1, String word2) {
        boolean result=false;
        if(word1.length()!=word2.length())
        {
            result=false;
        }
       else if(word1.equals(word2))
        {
            result=true;
        }
        else
        {
            int ch1[]=new int[26];
            int ch2[]=new int[26];
            ArrayList<Integer> l=new ArrayList<Integer>();
            ArrayList<Integer> m=new ArrayList<Integer>();
            for(int i=0;i<word1.length();i++)
            {
                ch1[word1.charAt(i)-'a']++;
            }
            for(int i=0;i<word2.length();i++)
            {
                ch2[word2.charAt(i)-'a']++;
            }
            int count=0;
            for(int i=0;i<26;i++)
            {
                if(ch1[i]>0)
                {
                    if(ch2[i]==0)
                    {
                        count=1;
                        break;
                    }
                    else
                    {
                        l.add(ch1[i]);
                        m.add(ch2[i]);
                    }
                }
                else if(ch2[i]>0)
                {
                    count=1;   
                    break;
                }
            }

            if(count==0)
            {
                Collections.sort(l);
                Collections.sort(m);

                for(int i=0;i<l.size();i++)
                {
                    //System.out.println(l.get(i)+" "+m.get(i)+" "+l.size());
                    int p=l.get(i);
                    int q=m.get(i);
                    if(p!=q)
                    {
                        count=1;
                        break;
                    }
                }
                if(count==0)
                {
                    result=true;
                }
            }
        }
        
        return result;
    }
}
