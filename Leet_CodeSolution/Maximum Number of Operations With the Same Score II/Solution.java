class Solution {
    public int Solve(int nums[],int i,int j,int score,HashMap<String,Integer> map)
    {
        if(i>=j)
        {
            return 0;
        }
     
        String str=Integer.toString(i)+" "+Integer.toString(j);
        if(map.containsKey(str))
        {
            return map.get(str);
        }
        int a=0,b=0,c=0;
        if(nums[i]+nums[i+1]==score)
        {
            a=1+Solve(nums,i+2,j,score,map);
        }
        else
        {
            a=Solve(nums,1,0,score,map);
        }
        if(nums[i]+nums[j]==score)
        {
            b=1+Solve(nums,i+1,j-1,score,map);
        }
        else
        {
            b=Solve(nums,1,0,score,map);
        }
        if(nums[j]+nums[j-1]==score)
        {
            c=1+Solve(nums,i,j-2,score,map);
        }
        else
        {
            c=Solve(nums,1,0,score,map);
        }
         
        int p=Math.max(a,b);
        int max= Math.max(p,c);
        map.put(str,max);
        return max;
    }
    public int maxOperations(int[] nums) {
        HashMap<String,Integer> map=new HashMap<String,Integer>();
       int a=Solve(nums,0,nums.length-1,nums[0]+nums[1],map);
        int b=0;
        if(nums[nums.length-1]+nums[nums.length-2] !=nums[0]+nums[1])
        {
            map=new HashMap<String,Integer>();
            b=Solve(nums,0,nums.length-1,nums[nums.length-1]+nums[nums.length-2],map);
        }
        int c=0;
        if(nums[nums.length-1]+nums[nums.length-2] !=nums[0]+nums[nums.length-1] && nums[0]+nums[nums.length-1]!=nums[0]+nums[1])
        {
          map=new HashMap<String,Integer>();
           c=Solve(nums,0,nums.length-1,nums[0]+nums[nums.length-1],map);
          }
       int p=Math.max(a,b);
       
      return Math.max(p,c);
    }
}
