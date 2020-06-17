class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       
        HashMap<String,List<String>> h=new HashMap<String,List<String>>();
        List<List<String>> list=new ArrayList();
        for(int i=0;i<strs.length;i++)
        {
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String p=new String(c);
            if(!h.containsKey(p))
            {
                List<String> l=new ArrayList();
                l.add(strs[i]);
                h.put(p,l);
            }
            else
            {
                h.get(p).add(strs[i]);
              
            }
        }
        ArrayList<String> k=new ArrayList<String>();
        for(int i=0;i<strs.length;i++)
        {
            char c[]=strs[i].toCharArray();
            Arrays.sort(c);
            String p=new String(c);
            if(!k.contains(p))
            {
            list.add(h.get(p));
            k.add(p);
            }
        }
        
        return list;
        
    }
}
