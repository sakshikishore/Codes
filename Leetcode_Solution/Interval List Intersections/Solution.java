class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n=firstList.length+secondList.length;
        int result[][]=new int[n][2];
        int p[][];
        int count=0;
        if(firstList.length==0 || secondList.length==0)
        {
            p=new int[0][0];
        }
        else
        {
            for(int i=0;i<n;i++)
            {
                result[i][0]=-1;
                result[i][1]=-1;
            }
            for(int i=0; i<firstList.length; i++)
            {
                for(int j=0;j<secondList.length;j++)
                {
                    if(secondList[j][0]==firstList[i][0])
                    {
                        result[count][0]=secondList[j][0];
                        if(secondList[j][1] == firstList[i][1])
                        {
                            result[count][1]=secondList[j][1];
                        }
                        else if(secondList[j][1]<firstList[i][1])
                        {
                            result[count][1]=secondList[j][1];
                        }
                        else
                        {
                            result[count][1]=firstList[i][1];
                        }
                        count++;
                    }
                    else if(secondList[j][1]==firstList[i][1])
                    {
                        result[count][1]=secondList[j][1];
                        if(secondList[j][0]<firstList[i][0])
                        {
                            result[count][0]=firstList[i][0];
                        }
                        else
                        {
                            result[count][0]=secondList[j][0];
                        }
                        System.out.println(result[count][0]);
                        count++;
                    }
                    else if(firstList[i][0]==secondList[j][1])
                    {
                        result[count][0]= firstList[i][0];
                        result[count][1]= firstList[i][0];
                         count++;
                    }
                    else if(firstList[i][1]==secondList[j][0])
                    {
                        result[count][0]= firstList[i][1];
                        result[count][1]= firstList[i][1];
                        count++;
                    }
                    else if(firstList[i][0]<secondList[j][0] && firstList[i][1]> secondList[j][1])
                    {
                        result[count][0]= secondList[j][0];
                        result[count][1]= secondList[j][1];
                        count++;
                    }
                     else if(firstList[i][0]>secondList[j][0] && firstList[i][1]<secondList[j][1])
                    {
                        result[count][0]= firstList[i][0];
                        result[count][1]= firstList[i][1];
                        count++;
                    }
                    else if(firstList[i][0]>secondList[j][0] && firstList[i][0]<secondList[j][1])
                       
                    {
                        if(firstList[i][1]<secondList[j][1])
                        {
                             result[count][0]= firstList[i][0];
                             result[count][1]= firstList[i][1];
                             count++;
                        }
                        else
                        {
                             result[count][0]= firstList[i][0];
                             result[count][1]= secondList[j][1];
                             count++;
                        }
                    }
                    else if(secondList[j][0]>firstList[i][0] && secondList[j][0]<firstList[i][1])
                    {
                         if(firstList[i][1]>secondList[j][1])
                        {
                             result[count][0]= secondList[j][0];
                             result[count][1]= secondList[j][1];
                             count++;
                        }
                        else
                        {
                             result[count][0]= secondList[j][0];
                             result[count][1]= firstList[i][1];
                             count++;
                        }
                    }
                }
            }
        }
        p=new int[count][2];
        for(int i=0;i<count;i++)
        {
            p[i][0]=result[i][0];
            p[i][1]=result[i][1];
        }
        
        return p;
    }
}
