class Solution {
    public int countGoodSubstrings(String s) {
        ArrayList<String> str =new ArrayList<String>();
        int count=0;
        for(int i=0;i<s.length()-2;i++)
        {
            str.add(s.substring(i,i+3));
        }
        for(int i=0;i<str.size();i++)
        {
            if(str.get(i).charAt(0)!=str.get(i).charAt(1) && str.get(i).charAt(1)!=str.get(i).charAt(2) && str.get(i).charAt(0)!=str.get(i).charAt(2))               
            {
                count++;
            }
        }
        
        return count;
    }
}
