class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean result=false;
        if(n>0)
        {
        for(int i=0;i<flowerbed.length;i++)
        {
            if(i==0)
            {
                if(flowerbed[0]==0)
                {
                    if(i+1<=flowerbed.length-1)
                    {
                        if(flowerbed[i+1]==0)
                        {
                            flowerbed[i]=1;
                            n--;
                             if(n==0)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                             n--;
                             if(n==0)
                            {
                                break;
                            }
                    }
                }
            }
            else if(i==flowerbed.length-1)
            {
                if(flowerbed[i]==0)
                {
                     if(i-1>=0)
                    {
                        if(flowerbed[i-1]==0)
                        {
                            flowerbed[i]=1;
                            n--;
                            if(n==0)
                            {
                                break;
                            }
                        }
                    }
                    else
                    {
                             n--;
                             if(n==0)
                            {
                                break;
                            }
                    }
                }
            }
            else
            {
                if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0)
                {
                    flowerbed[i]=1;
                    n--;
                    if(n==0)
                    {
                        break;
                    }
                }
                
            }
        }
    }
        if(n==0)
        {
            result= true;
        }
        
        return result;
        
    }
}
