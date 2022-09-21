class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String result="";
        HashMap<Character,ArrayList<Integer>> h=new HashMap<Character,ArrayList<Integer>>();
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(s.charAt(i),l);
            }
            else
            {
                ArrayList<Integer> l=h.get(s.charAt(i));
                l.add(i);
                h.put(s.charAt(i),l);
            }
        }
        for(int i=0;i<dictionary.size();i++)
        {
            String str=dictionary.get(i);
            if(str.length()>result.length() || ((str.length()==result.length()) && str.compareTo(result)<0))
            {
                int ch[]=new int[26];
                int flag=0;
                for(int j=0;j<26;j++)
                {
                    ch[j]=-1;
                }
                int index=0;
                for(int j=0;j<str.length();j++)
                {
                    if(h.containsKey(str.charAt(j)))
                    {
                        if(index==0)
                        {
                           ArrayList<Integer> l=h.get(str.charAt(j));
                           ch[str.charAt(j)-'a']=0;
                           index=l.get(0)+1;
                        }
                        else
                        {
                            ArrayList<Integer> l=h.get(str.charAt(j));
                            int a=ch[str.charAt(j)-'a']+1;
                            boolean found=false;
                            for(int k=a;k<l.size();k++)
                            {
                                if(l.get(k)>=index)
                                {
                                    index=l.get(k)+1;
                                    ch[str.charAt(j)-'a']=k;
                                    found=true;
                                    break;
                                }
                            }
                            if(!found)
                            {
                                flag=1;
                                break;
                            }
                        }
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    result=str;
                }
            }
        }
        
        return result;
    }
}
