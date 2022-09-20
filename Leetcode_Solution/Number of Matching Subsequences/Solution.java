class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
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
        
        for(int i=0;i<words.length;i++)
        {
            int flag=0;
            int index=-1;
            String str=words[i];
            int ch[]=new int[26];
            for(int k=0;k<26;k++)
            {
                ch[k]=-1;
            }
            for(int j=0;j<str.length();j++)
            {
                if(h.containsKey(str.charAt(j)))
                {
                    ArrayList<Integer> l=h.get(str.charAt(j));
                    if(index==-1)
                    {
                        index=l.get(0);
                        ch[str.charAt(j)-'a']=0;
                    }
                    else
                    {
                        int p=ch[str.charAt(j)-'a']+1;
                        int found=0;
                        for(int k=p;k<l.size();k++)
                        {
                            if(l.get(k)>index)
                            {
                                found=1;
                                index=l.get(k);
                                ch[str.charAt(j)-'a']=k;
                                break;
                            }
                        }
                        if(found==0)
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
                count++;
            }
        }
        
        return count;
    }
}
