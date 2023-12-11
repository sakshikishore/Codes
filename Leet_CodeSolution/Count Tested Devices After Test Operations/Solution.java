class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int test=0;
        for(int i=0;i<batteryPercentages.length;i++)
        {
            int x=Math.max(0,batteryPercentages[i]-test);
            if(x>0)
            {
                test++;
            }
        }
        
        return test;
    }
}
