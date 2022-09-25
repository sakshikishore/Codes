class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String result[]=new String[names.length];
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        for(int i=0;i<heights.length;i++)
        {
            h.put(heights[i],names[i]);
        }
        
        Arrays.sort(heights);
        int j=0;
        for(int i=heights.length-1;i>=0;i--)
        {
            result[j]=h.get(heights[i]);
            j++;
        }
        
        return result;
    }
}
