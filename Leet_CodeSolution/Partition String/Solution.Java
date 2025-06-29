class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> hset=new HashSet<String>();
        ArrayList<String> result=new ArrayList<String>();
        String str="";
        for(int i=0;i<s.length();i++)
        {
            str+=s.charAt(i);
            if(!hset.contains(str))
            {
                result.add(str);
                hset.add(str);
                str="";
            }
        }

        return result;
    }
}
