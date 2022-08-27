class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<String>> list=new ArrayList();
        List<List<Integer>> result=new ArrayList();
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<nums.length;i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            String s=Integer.toString(nums[i]);
            list.get(i).add(Integer.toString(nums[i]));
                for(int j=i-1;j>=0;j--)
                {
                    if(nums[i]>=nums[j])
                    {
                          for(int k=0;k<list.get(j).size();k++)
                          {
                              String str=list.get(j).get(k);
                              str=str+" "+s;
                              if(!h.contains(str))
                              {
                                  h.add(str);
                                  list.get(i).add(str);
                                  String p[]=str.split(" ");
                                  ArrayList<Integer> l=new ArrayList<Integer>();
                                  for(int x=0;x<p.length;x++)
                                  {
                                      l.add(Integer.parseInt(p[x]));
                                  }
                                  result.add(l);
                              }
                          }
                    }
            }
        }
        
        return result;
    }
}
