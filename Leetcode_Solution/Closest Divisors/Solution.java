class Solution {
    public int[] closestDivisors(int num) {
        int x=(int)Math.sqrt(num+2);
        int arr[]=new int[2];
        int flag=1;
        int i=x,j=x;
        while(flag!=0)
        {
            if(i*j==num+1 || i*j==num+2)
            {
                arr[0]=i;
                arr[1]=j;
                break;
            }
            else if(i*j<num+2)
            {
                j++;
            }
            else
            {
                i--;
            }
        }
        
        return arr;
    }
}
