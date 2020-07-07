class Solution {
    public int balancedStringSplit(String s) {
        int arr[]=new int[2];
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='R')
            {
                arr[1]++;
                if(arr[1]==arr[0])
                {
                    count++;
                    arr[0]=0;
                    arr[1]=0;
                }
            }
            else
            {
                arr[0]++;
                if(arr[1]==arr[0])
                {
                    count++;
                    arr[0]=0;
                    arr[1]=0;
                }
            }
        }
        
        return count;
        
    }
}
