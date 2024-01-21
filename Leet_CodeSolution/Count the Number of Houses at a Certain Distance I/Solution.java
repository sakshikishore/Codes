class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int result[]=new int[n];
        if(x>y)
        {
            int temp=x;
             x=y;
             y=temp;
        }
        for(int i=1;i<=n;i++)
        {
           for(int j=i+1;j<=n;j++)
           {
                   int minJump=Math.abs((x-i))+1+Math.abs((j-y));
                   minJump=Math.min(minJump,(j-i));
                   result[minJump-1]+=2;

           }
        }
        
        return result;
        
        
    }
}
