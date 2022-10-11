class Solution {
    public int countPalindromicSubsequence(String s) {
        int result=0;
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
                if(l.size()==2)
                {
                    l.remove(1);
                }
                l.add(i);
                h.put(s.charAt(i),l);
            }
        }
        
        for(Map.Entry<Character,ArrayList<Integer>> entry:h.entrySet())
        {
            char c=entry.getKey();
            ArrayList<Integer> value=entry.getValue();
            if(value.size()==2)
            {
                int start=value.get(0);
                int end=value.get(1);
                HashSet<Character> hset=new HashSet<Character>();
                for(int k=start+1;k<end;k++)
                {
                    hset.add(s.charAt(k));
                }
                
                result+=hset.size();
            }
        }
        
        return result;
        
    }
}
