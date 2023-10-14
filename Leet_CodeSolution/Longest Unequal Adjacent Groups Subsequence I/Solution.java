class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int p=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<groups.length;i++)
        {
            if(groups[i]==p)
            {
                l.add(i);
                p=p^1;
            }
        }
        p=1;
         for(int i=0;i<groups.length;i++)
        {
            if(groups[i]==p)
            {
                m.add(i);
                p=p^1;
            }
        }
        ArrayList<String> result=new ArrayList<String>();
        
        if(l.size()>m.size())
        {
           for(int i=0;i<l.size();i++)
           {
               result.add(words[l.get(i)]);
           }
        }
        else
        {
             for(int i=0;i<m.size();i++)
           {
               result.add(words[m.get(i)]);
           }
        }
        
        
        return result;
    }
}
