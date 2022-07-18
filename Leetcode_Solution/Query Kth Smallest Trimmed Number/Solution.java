class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int result[]=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            String arr[]=new String[nums.length];
            int x=nums[0].length()-queries[i][1];
             int index[]=new int[nums.length];
            for(int j=0;j<nums.length;j++)
            {
                arr[j]=nums[j].substring(x);
                index[j]=j;
                
            }
    
            for(int y=0;y<arr.length;y++)
            {
                for(int z=y+1;z<arr.length;z++)
                {
                    if(arr[y].compareTo(arr[z])>0)
                    {
                        String temp=arr[z];
                        arr[z]=arr[y];
                        arr[y]=temp;
                        
                        int te=index[y];
                        index[y]=index[z];
                        index[z]=te;
                    }
                    else if(arr[y].compareTo(arr[z])==0)
                    {
                        if(index[y]>index[z])
                        {
                              int te=index[y];
                            index[y]=index[z];
                            index[z]=te;
                        }
                    }
                }
            }
            
            
       
            result[i]=index[queries[i][0]-1];        
            
        }
        
        return result;
    }
}
