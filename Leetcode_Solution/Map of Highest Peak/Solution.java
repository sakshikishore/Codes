class Solution {
    public int[][] highestPeak(int[][] isWater) {
        Queue<String> q=new LinkedList<String>();
        for(int i=0;i<isWater.length;i++)
        {
            for(int j=0;j<isWater[0].length;j++)
            {
                if(isWater[i][j]!=1)
                {
                    isWater[i][j]=-1;
                }
                else
                {
                    isWater[i][j]=0;
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    q.add(str);
                }
            }
        }
        while(q.size()>0)
        {
            String s[]=q.poll().split(" ");
            int i=Integer.parseInt(s[0]);
            int j=Integer.parseInt(s[1]);
            if(i-1>=0)
            {
                if(isWater[i-1][j]==-1)
                {
                    isWater[i-1][j]=isWater[i][j]+1;
                    String str=Integer.toString(i-1)+" "+Integer.toString(j);
                    q.add(str);
                }
            }
            if(i+1<isWater.length)
            {
                if(isWater[i+1][j]==-1)
                {
                    isWater[i+1][j]=isWater[i][j]+1;
                    String str=Integer.toString(i+1)+" "+Integer.toString(j);
                    q.add(str);
                }
            }
            if(j-1>=0)
            {
                if(isWater[i][j-1]==-1)
                {
                    isWater[i][j-1]=isWater[i][j]+1;
                    String str=Integer.toString(i)+" "+Integer.toString(j-1);
                    q.add(str);
                }
            }
            if(j+1<isWater[0].length)
            {
                if(isWater[i][j+1]==-1)
                {
                    isWater[i][j+1]=isWater[i][j]+1;
                    String str=Integer.toString(i)+" "+Integer.toString(j+1);
                    q.add(str);
                }
            }
            
        }
       
        return isWater;

    }
}
