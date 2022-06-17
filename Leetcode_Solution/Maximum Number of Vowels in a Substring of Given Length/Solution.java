class Solution {
    public int maxVowels(String s, int k) {
        int arr[]=new int[s.length()];
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u')
            {
                sum=sum+1;
                arr[i]=sum;
            }
            else
            {
                arr[i]=sum;
            }
        }
        int max=0;
        for(int i=0;i<=s.length()-k;i++)
        {
            if(i-1<0)
            {
                if(arr[i+k-1]>max)
                {
                    max=arr[i+k-1];
                }
            }
            else
            {
                int p=arr[i+k-1]-arr[i-1];
                if(p>max)
                {
                    max=p;
                }
            }
        }
        
        return max;
        
    }
}
