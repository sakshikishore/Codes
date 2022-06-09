class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int arr[]=new int[target+1];
        ArrayList<ArrayList<String>> list=new ArrayList();
        for(int i=0;i<=target;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        arr[0]=1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<=target)
            {
               for(int j=nums[i];j<=target;j++)
               {
                   arr[j]+=arr[j-nums[i]];
                   if(j-nums[i]==0)
                   {
                       list.get(j).add(Integer.toString(j));
                       
                   }
                   else
                   {
                       int x=j-nums[i];
                       if(arr[j-nums[i]]>0)
                       {
                           for(int p=0;p<list.get(x).size();p++)
                           {
                    String str=list.get(x).get(p)+" "+Integer.toString(nums[i]);
                               list.get(j).add(str);
                           }
                       }
                   }
               }
            }
        }
        List<List<Integer>> result=new ArrayList();
        
            for(int j=0;j<list.get(target).size();j++)
            {
              String s[]=list.get(target).get(j).split(" ");
              ArrayList<Integer> r=new ArrayList<Integer>();
              for(int i=0;i<s.length;i++)
              {
                  r.add(Integer.parseInt(s[i]));
              }
              result.add(r);
            }
        
                            
        return result;
        
    }
}
