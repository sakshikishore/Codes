class Solution {
    public boolean checkDistances(String s, int[] distance) {
      HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),i);
            }
            else
            {
                int index=s.charAt(i)-'a';
                int firstIndex=h.get(s.charAt(i));
                int dist=i-firstIndex-1;
                if(distance[index]!=dist)
                {
                    return false;
                }
            }
        }
        
        return true;
    }
}
