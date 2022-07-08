class Solution {
    public int maximumSwap(int num) {
        String str=Integer.toString(num);
        int arr1[]=new int[str.length()];
        int arr2[]=new int[str.length()];
        for(int i=0;i<str.length();i++)
        {
            arr1[i]=Integer.parseInt(str.substring(i,i+1));
            arr2[i]=arr1[i];
        }
        Arrays.sort(arr1);
        int j=0;
        for(int i=arr1.length-1;i>=0;i--)
        {
            if(arr1[i]!=arr2[j])
            {
                for(int k=arr2.length-1;k>=0;k--)
                {
                    if(arr2[k]==arr1[i])
                    {
                        arr2[k]=arr2[j];
                        arr2[j]=arr1[i];
                        break;
                    }
                }
                break;
            }
            j++;
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++)
        {
            ans=ans*10+arr2[i];
        }
        return ans;
    }
}
