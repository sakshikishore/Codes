class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String> hset=new HashSet<String>();
        HashMap<Character,ArrayList<String>> map=new HashMap<Character,ArrayList<String>>();
        long result=0;
        for(int i=0;i<ideas.length;i++)
        {
            hset.add(ideas[i]);
            if(!map.containsKey(ideas[i].charAt(0)))
            {
                ArrayList<String> list=new ArrayList<String>();
                list.add(ideas[i]);
                map.put(ideas[i].charAt(0),list);
            }
            else
            {
                ArrayList<String> list=map.get(ideas[i].charAt(0));
                list.add(ideas[i]);
                map.put(ideas[i].charAt(0),list);
            }
        }
        for(int i=0;i<25;i++)
        {
            char ch=(char)(97+i);
            
            if(map.containsKey(ch))
            {
                 ArrayList<String> al=map.get(ch);
                 ArrayList<String> alist=new ArrayList<String>();
                 for(int k=0;k<al.size();k++)
                 {
                     alist.add(al.get(k).substring(1));
                 }
                 for(int j=i+1;j<26;j++)
                 {
                     long count=0;
                     char p=(char)(97+j);
                     if(map.containsKey(p))
                     {
                         for(int k=0;k<al.size();k++)
                         {
                            if(!hset.contains(p+alist.get(k)))
                            {
                                count++;
                            }
                         }
                        ArrayList<String> l=map.get((char)(97+j));
                        for(int k=0;k<l.size();k++)
                        {
                            String str=ch+l.get(k).substring(1);
                            if(!hset.contains(str))
                            {
                                result+=2*count;
                            }
                        }
                     }
                 }
            }
        }

        return result;

        
    }
}
