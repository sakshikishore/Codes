class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        char c[]=p.toCharArray();
        Arrays.sort(c);
        String k=new String(c);
        for(int i=0;i<=s.length()-p.length();i++)
        {
            String str=s.substring(i,i+p.length());
            char d[]=str.toCharArray();
            Arrays.sort(d);
            String l=new String(d);
            if(l.equals(k))
            {
                result.add(i);
            }
            
        }
        return result;
        
    }
}
