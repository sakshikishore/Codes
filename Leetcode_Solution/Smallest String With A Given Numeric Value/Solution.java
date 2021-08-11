class Solution {
    public String getSmallestString(int n, int k) {
        StringBuffer result=new StringBuffer();
        int i=1;
        while((26*(n-i)>=k-1) && i<=n)
        {
            result=result.append("a");
            i++;
            k--;
        }
        if(26*(n-i)<k-1)
            {
                int p= k-(26*(n-i));
                result=result.append(Character.toString((char)(97+p-1)));
                k=k-p;
            }
        i=i+1;
        while(i<=n)
        {
         result=result.append("z");
         i++;
        }
        return result.toString();
        
    }
}
