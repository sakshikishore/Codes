class Solution {
    public int[] shortestToChar(String S, char C) {
        int arr[]=new int[S.length()];
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)==C)
            {
                l.add(i);
            }
                
        }
        int p=0;
        for(int i=0;i<S.length();i++)
        {
            if(l.get(p)>=i)
            {
                arr[i]=l.get(p)-i;
            }
            
            else if(p+1<l.size() && l.get(p)<i && l.get(p+1)>=i)
            {
                if((i-l.get(p))<(l.get(p+1)-i))
                   {
                       arr[i]=i-l.get(p);
                   }
                   else
                   {
                       p++;
                       arr[i]=l.get(p)-i;
                   }
            }
            else
            {
               arr[i]=Math.abs(l.get(p)-i);
            }
        }
        
         return arr;
    }
                   
           
}
