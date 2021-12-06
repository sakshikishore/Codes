class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> h1=new HashMap<String,Integer>();
        HashMap<String,Integer> h2=new HashMap<String,Integer>();
        int count=0;
        ArrayList<String> l=new ArrayList<String>();
        for(int i=0;i<words1.length;i++)
        {
            if(!h1.containsKey(words1[i]) && !l.contains(words1[i]))
            {
                h1.put(words1[i],1);
            }
            else
            {
                l.add(words1[i]);
                h1.remove(words1[i]);
            }
        }
        
        l=new ArrayList<String>();
        
        for(int i=0;i<words2.length;i++)
        {
            if(!h2.containsKey(words2[i]) && !l.contains(words2[i]))
            {
                h2.put(words2[i],1);
            }
            else
            {
                l.add(words2[i]);
                h2.remove(words2[i]);
            }
        }
         for(int i=0;i<words2.length;i++)
        {
            if(h2.containsKey(words2[i]) && h1.containsKey(words2[i]))
            {
                count++;
            }
        }
       
        return count;
        
    }
}
