class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                count++;
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
        
        int a[]=new int[count];
        int b[]=new int[count];
        int l=0;
        for(Map.Entry<Integer,Integer> m:h.entrySet())
        {
            a[l]=m.getKey();
            b[l]=m.getValue();
            l++;
        }
        for(int i=0;i<count;i++)
        {
            for(int j=i+1;j<count;j++)
            {
                if(b[i]<b[j])
                {
                    int temp=b[i];
                    b[i]=b[j];
                    b[j]=temp;
                    
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
         
            }
        }       
        int result[]=new int[k];
        for(int i=0;i<k;i++)
        {
            result[i]=a[i];
        } 
        
        return result;
    }
}
