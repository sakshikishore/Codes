class Solution {
    public int numberCount(int a, int b) {
        int count=0;
        for(int i=a;i<=b;i++)
        {
             int c[]=new int[10];
             int num=i,flag=0;
             while(num>0)
             {
                int r=num%10;
                c[r]++;
                if(c[r]==2)
                 {
                    flag=1;
                    break;
                 }
                 num=num/10;
             }

             if(flag==0)
             {
                count++;
             }
        }

        return count;
    }
}
