class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> result=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<words.size();i++)
        {
            if(words.get(i).equals("prev"))
            {
               count++;
               if(l.size()<count)
               {
                   result.add(-1);
               }
               else
               {
                   result.add(l.get(l.size()-count));
               }
            }
            else
            {
                count=0;
                l.add(Integer.parseInt(words.get(i)));
            }
        }
        
        return result;

        }
}
