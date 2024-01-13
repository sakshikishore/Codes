class Solution {
    int min=Integer.MAX_VALUE;
    public void Solve(int[] cookies, int k, int[] scores, int index)
    {
        if(index==cookies.length)
        {
            int max=0;
            for(int i=0;i<scores.length;i++)
            {
                if(scores[i]>max)
                {
                    max=scores[i];
                }
            }
            if(max<min)
            {
                min=max;
            }
            return;
        }

        for(int i=0;i<k;i++)
        {
            scores[i]+=cookies[index];
            Solve(cookies,k,scores,index+1);
            scores[i]-=cookies[index];
        }
    }
    public int distributeCookies(int[] cookies, int k) {
       int score[]=new int[k];
       Solve(cookies,k,score,0);

       return min;
    }
}
