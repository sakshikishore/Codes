class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> list=new ArrayList();
        HashMap<ArrayList<Integer>,Integer> h1=new HashMap<ArrayList<Integer>,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
            for(int j=i+1;j<nums.length;j++)
            {
                int x=-nums[i]-nums[j];
                if(h.containsKey(x))
                {
                    ArrayList<Integer> p=new ArrayList<Integer>();
                    p.add(nums[i]);
                    p.add(nums[j]);
                    p.add(x);
                    Collections.sort(p);
                    if(!h1.containsKey(p))
                    {
                        list.add(p);
                        h1.put(p,1);
                    }
                }
                if(!h.containsKey(nums[j]))
                {
                 h.put(nums[j],1);
                }
            }
        }
        
        return list;
    }
}
