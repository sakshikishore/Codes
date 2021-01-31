class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int max=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=lowLimit;i<=highLimit;i++)
        {
            int n=i;
            int sum=0;
            while(n!=0)
            {
                int r=n%10;
                sum=sum+r;
                n=n/10;
            }
            if(!h.containsKey(sum))
            {
                h.put(sum,1);
            }
            else
            {
                h.put(sum,h.get(sum)+1);
            }
            if(h.get(sum)>max)
            {
                max=h.get(sum);
            }
        }
        
        return max;
        
        
    }
}
