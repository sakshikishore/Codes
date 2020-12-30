class Solution {
    public int distributeCandies(int[] candyType) {
        int p=candyType.length/2;
        int result=0;
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<candyType.length;i++)
        {
            h.add(candyType[i]);
        }
            if(h.size()>p)
            {
                result=p;
            }
            else
            {
                result=h.size();
            }
        return result;
        
    }
}
