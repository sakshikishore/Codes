class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int count=0;
        int i=0;
        String p=word;
        while(true)
        {
           if(p.length()<=k)
           {
               return count+1;
           }
           p=p.substring(k);
           if(p.equals(word.substring(0,p.length())))
           {
               return count+1;
           }
           else
           {
               count++;
           }
        }
    
    }
}
