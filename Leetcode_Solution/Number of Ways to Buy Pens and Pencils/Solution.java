class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long result=0;
        int totalPen=0,totalPencil=0;
        if(total>=cost1)
        {
            totalPen=total/cost1;
        }
        if(total>=cost2)
        {
            totalPencil=total/cost2;
        }
        
        if(totalPen>0 || totalPencil>0)
        { 
            for(int i=0;i<=totalPen;i++)
            {
                if(i==0)
                {
                  result+=totalPencil+1; // +1 is for 0 Pencil
                }
                else
                {
                    int remainingPrice=total-(i*cost1);
                    if(remainingPrice>=cost2)
                    {
                        totalPencil=remainingPrice/cost2;
                        result+=totalPencil+1; // +1 is for 0 Pencil
                    }
                    else
                    {
                        result+=1;
                    }

                }
            }
        }
        else
        {
            result=1; // For 0 Pencil and 0 Pen
        }
        
        return result;
        
    }
}
