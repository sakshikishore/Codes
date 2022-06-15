class Solution {
    public int longestStrChain(String[] words) {
        int max=1;
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        List<ArrayList<String>> list=new ArrayList();
        for(int i=0;i<16;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        for(int i=0;i<words.length;i++)
        {
            if(words[i].length()==1)
            {
                h.put(words[i],1);
            }
            
            list.get(words[i].length()-1).add(words[i]);
                
        }
        
        for(int i=0;i<list.size();i++)
        {
            for(int j=0;j<list.get(i).size();j++)
            {
                String str=list.get(i).get(j);
                if(!h.containsKey(str))
                {
                    h.put(str,1);
                }
               if(i+1<16)
               {
                   for(int k=0;k<list.get(i+1).size();k++)
                   {
                        String s=list.get(i+1).get(k);
                            int y=0;
                            int count=0;
                            for(int x=0;x<str.length();x++)
                            {
                                if(str.charAt(x)!=s.charAt(y))
                                {
                                    count++;
                                    y++;
                                    x--;
                                    if(count==2)
                                    {
                                        break;
                                    }
                                }
                                else
                                {
                                    y++;
                                }
                            }
                            if(y==s.length()-1 && count==0)
                            {
                                count=1;
                            }
                           if(count==1)
                           {
                               if(h.containsKey(s))
                               {
                                   if(h.get(s)<h.get(str)+1)
                                   {
                                         h.put(s,h.get(str)+1);
                                   }
                               }
                               else
                               {
                                     h.put(s,h.get(str)+1);
                               }
                               if(h.get(s)>max)
                               {
                                   max=h.get(s);
                               }
                           }
                        
                   }
               }
            }
        }
        
        return max;
        
    }
}
