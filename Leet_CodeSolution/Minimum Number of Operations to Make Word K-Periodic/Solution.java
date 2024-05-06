class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
       int i=0;
       int max=1;
       HashMap<String,Integer> h=new HashMap<String,Integer>();
       while(i<word.length())
       {
          String str=word.substring(i,i+k);
          if(!h.containsKey(str))
          {
            h.put(str,1);
          }
          else
          {
            h.put(str,h.get(str)+1);
            max=Math.max(max,h.get(str));
          }
          i=i+k;
       }

       return (word.length()/k)-max;
    }
}
