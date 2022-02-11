class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int result[]=new int[nums.length];
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> m=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                l.add(nums[i]);
            }
            else
            {
                m.add(nums[i]);
            }
        }
        Collections.sort(l);
        Collections.sort(m);
        int p=0,q=m.size()-1;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                result[i]=l.get(p);
                p++;
            }
            else
            {
                result[i]=m.get(q);
                q--;
            }
        }
        
        return result;
    }
}
