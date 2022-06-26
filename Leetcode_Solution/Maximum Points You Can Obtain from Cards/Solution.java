class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int x=cardPoints.length-k;
        int totalSum=0,sum=0,max=0;
        for(int i=0;i<cardPoints.length;i++)
        {
            totalSum+=cardPoints[i];
            if(i==x-1)
            {
                sum=totalSum;
            }
        }
        
        max=Math.max(max,totalSum-sum);
        int j=0;
        for(int i=x;i<cardPoints.length;i++)
        {
            sum-=cardPoints[j];
            sum+=cardPoints[i];
            max=Math.max(max,totalSum-sum);
            j++;
        }
        
        return max;
        
    }
}
