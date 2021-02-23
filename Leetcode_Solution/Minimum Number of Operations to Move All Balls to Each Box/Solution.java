class Solution {
    public int[] minOperations(String boxes) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<boxes.length();i++)
        {
            if(boxes.charAt(i)=='1')
            {
                l.add(i);
            }
        }
       int result[]=new int[boxes.length()];
       for(int i=0;i<boxes.length();i++)
       {
           for(int j=0;j<l.size();j++)
           {
               result[i]=result[i]+Math.abs(i-l.get(j));
           }
       }
        
        return result;
    }
}
