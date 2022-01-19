class Solution {
    public int maxSatisfaction(int[] arr) {
        Arrays.sort(arr);
        int i=0;
        int sum=0;
        int max=0;
        if(arr[arr.length-1]>0)
        {
        while(arr[i]<0)
        {
            int l=1;
            for(int j=i;j<arr.length;j++)
            {
               sum+= arr[j]*l;
               l++;
            }
            i++;
            if(sum>max)
            {
                max=sum;
            }
            sum=0;
        }
        int k=1;
        for(int p=i;p<arr.length;p++)
        {
            sum=sum+arr[p]*k;
            k++;
        }
        
        if(sum>max)
        {
            max=sum;
        }
        }
        
        return max;
    }
}
