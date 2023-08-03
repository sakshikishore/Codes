class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int arr[]=new int[3];
        int flag=0;
        int a=0,b=0,c=0;
        for(int i=0;i<triplets.length;i++)
        {
                if((triplets[i][0]==target[0]) && (triplets[i][1]==target[1]) && (triplets[i][2]==target[2]))
                {
                       return true;
                }
                if(triplets[i][0]==target[0])
                {
                    if(triplets[i][1]<=target[1] && triplets[i][2]<=target[2])
                    {
                        a++;
                    }
                    arr[0]++;
                }
                if(triplets[i][1]==target[1])
                {
                    if(triplets[i][0]<=target[0] && triplets[i][2]<=target[2])
                    {
                        b++;
                    }
                    arr[1]++;
                }
                if(triplets[i][2]==target[2])
                {
                    if(triplets[i][1]<=target[1] && triplets[i][0]<=target[0])
                    {
                        c++;
                    }
                    arr[2]++;
                }
        }

        if(arr[0]<1 || arr[1]<1 || arr[2]<1)
        {
            return false;
        }
        if(a>=1 && b>=1 && c>=1)
        {
            
            return true;
        }

        return false;

    }
}
