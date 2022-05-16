class Solution {
    public int divisorSubstrings(int num, int k) {
        int count=0;
        String str=Integer.toString(num);
        for(int i=0;i<=str.length()-k;i++)
        {
            int p=Integer.parseInt(str.substring(i,i+k));
            if(p!=0)
            {
                if(num%p==0)
                {
                    count++;
                }
            }
        }
               
               return count;
    }
}
