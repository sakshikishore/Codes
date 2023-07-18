class Solution {
    public int candy(int[] ratings) {
        int index=0;
        int result=1;
        int prev=1;
        int val=1;
        for(int i=1;i<ratings.length;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                 index=i;
                 prev++;
                 val=prev;
                 result+=prev;
            }
            else if(ratings[i]==ratings[i-1])
            {
                 index=i;
                 prev=1;
                 val=1;
                 result+=prev;
            }
            else
            {
                if(val>1)
                {
                  prev=1;
                  val--;
                  result=result+(i-index);
                  continue; 
                }
                prev=1;
                int n=i-index+1;
                result+=n;
            }

        }

        return result;
    }
}
