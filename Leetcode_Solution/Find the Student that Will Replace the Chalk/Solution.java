class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i=0;i<chalk.length;i++)
        {
            sum+=chalk[i];
        }
        
        long r=k%sum;
        for(int i=0;i<chalk.length;i++)
        {
            if(chalk[i]>r)
            {
                return i;
            }
            else
            {
                r=r-chalk[i];
            }
        }
        
        return 0;
    }
}
