class Solution {
   public static ArrayList<String> allBinaryStrings;
    public static void  allPossibleBinaryStrings(int arr[],int n,int i)
    {
        if(allBinaryStrings.size()==17)
        {
            return;
        }
        else
        {
            if(i==n)
            {
                storeBinaryStrings(arr,n);
                return;
            }
            arr[i]=0;
            allPossibleBinaryStrings(arr,n,i+1);
            arr[i]=1;
            allPossibleBinaryStrings(arr,n,i+1);
        }
    }
    public static void  storeBinaryStrings(int arr[],int n)
    {
            String str="";
            for(int i=0;i<n;i++)
            {
               str=str+Integer.toString(arr[i]);
            }
            allBinaryStrings.add(str);    
    }
    public String findDifferentBinaryString(String[] nums) {
        ArrayList<String> l=new ArrayList<String>();
        allBinaryStrings =new ArrayList<String>();
        String result="";
        for(int i=0;i<nums.length;i++)
        {
            l.add(nums[i]);
        }
        int arr[]=new int[nums.length];
        allPossibleBinaryStrings(arr,nums.length,0);
        for(int i=0;i<allBinaryStrings.size();i++)
        {
            if(!l.contains(allBinaryStrings.get(i)))
            {
                result=allBinaryStrings.get(i);
                break;
            }
        }
        
        return result;
    }
}
