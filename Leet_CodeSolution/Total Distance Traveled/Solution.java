class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int result=0;
        if(mainTank>=5)
        {
            while(mainTank>=5)
            {
                result=result+50;
                mainTank=mainTank-5;
                if(additionalTank>0)
                {
                    additionalTank--;
                    mainTank+=1;
                }
            }
            result+=mainTank*10;
        }
        else
        {
            return mainTank*10;
        }
        
        return result;
    }
}
