class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int a=tops[0];
        int b=bottoms[0];
        int result=-1,flag=0,count=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!=a && bottoms[i]!=a)
            {
                 flag=1;
                 break;
            }
            else if(tops[i]!=a)
            {
                count++;
            }
        }
        if(flag==0)
        {
            if(result==-1)
            {
                result=count;
            }
            else
            {
                result=Math.min(result,count);
            }
        }
        count=0;
        flag=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!=b && bottoms[i]!=b)
            {
                 flag=1;
                 break;
            }
            else if(tops[i]!=b)
            {
                count++;
            }
        }
        if(flag==0)
        {
            if(result==-1)
            {
                result=count;
            }
            else
            {
                result=Math.min(result,count);
            }
        }
        count=0;
        flag=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!=b && bottoms[i]!=b)
            {
                 flag=1;
                 break;
            }
            else if(bottoms[i]!=b)
            {
                count++;
            }
        }
        if(flag==0)
        {
            if(result==-1)
            {
                result=count;
            }
            else
            {
                result=Math.min(result,count);
            }
        }
        count=0;
        flag=0;
        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!=a && bottoms[i]!=a)
            {
                 flag=1;
                 break;
            }
            else if(bottoms[i]!=a)
            {
                count++;
            }
        }
        if(flag==0)
        {
            if(result==-1)
            {
                result=count;
            }
            else
            {
                result=Math.min(result,count);
            }
        }
        
        return result;

    }
}
