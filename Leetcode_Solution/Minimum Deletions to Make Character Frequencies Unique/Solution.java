class Solution {
    public int minDeletions(String s) {
        TreeSet<Character> t=new TreeSet<Character>();
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
             t.add(s.charAt(i));
            if(!h.containsKey(s.charAt(i)))
               {
                   h.put(s.charAt(i),1);
               }
               else
               {
                   h.put(s.charAt(i),h.get(s.charAt(i))+1);
               }
        }
               ArrayList<Integer> l=new ArrayList<Integer>();
               ArrayList<Integer> r=new ArrayList<Integer>();
               Iterator<Character> itr=t.iterator();
               while(itr.hasNext())
               {
                   l.add(h.get(itr.next()));
               }
               int result=0;
               
               while(l.size()!=0)
               {
                   int p=l.remove(0);
                   while(l.contains(p)|| r.contains(p))
                   {
                       result++;
                       p--;
                   }
                   if(p!=0)
                   {
                       r.add(p);
                   }
                   
               }
               
               return result;
        
    }
}
