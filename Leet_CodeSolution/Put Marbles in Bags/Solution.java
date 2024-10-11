class Solution {
    public long putMarbles(int[] weights, int k) {
     ArrayList<Integer> l=new ArrayList<Integer>();
     for(int i=0;i<weights.length-1;i++)
     {
         l.add(weights[i]+weights[i+1]);
     }
     Collections.sort(l);
     long min=weights[0]+weights[weights.length-1];
     long max=weights[0]+weights[weights.length-1];
     for(int i=0;i<k-1;i++)
     {
         min+=l.get(i);
         max+=l.get(l.size()-i-1);
     }

     return max-min;

    }
}
