class Solution {
    public String thousandSeparator(int n) {
        String str=Integer.toString(n);
        int count=0;
        String s="";
        for(int i=str.length()-1;i>=1;i--)
        {
            count++;
            s=str.substring(i,i+1)+s;
            if(count%3==0)
            {
                s="."+s;
            }
        }
        
        s=str.substring(0,1)+s;
        
        
        return s;
        
    }
}
