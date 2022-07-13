class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> l=new ArrayList<Boolean>();
        String str="[a-z]*";
        for(int i=0;i<pattern.length();i++)
        {
          str=str+pattern.substring(i,i+1);
          str=str+"[a-z]*";
        }
        for(int i=0;i<queries.length;i++)
        {
            if(queries[i].matches(str))
            {
                l.add(true);
            }
            else
            {
                l.add(false);
            }
        }
        return l;
    }
}
