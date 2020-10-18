class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double mean=0.0;
        double sum=0.0;
        int p=arr.length*5;
        p=p/100;
        int totalRemainingArray=arr.length-(2*p);
        for(int i=p;i<arr.length-p;i++)
        {
            sum=sum+arr[i];
        }
        
        return sum/totalRemainingArray;
        
    }
}
