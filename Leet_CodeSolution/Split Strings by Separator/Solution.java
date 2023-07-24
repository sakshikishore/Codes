class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        ArrayList<String> result=new ArrayList<String>();
        String s=Character.toString(separator);
        for(int i=0;i<words.size();i++)
        {
             String str[]=words.get(i).split("["+s+"]");
            for(int j=0;j<str.length;j++)
            {
                if(str[j].length()>0)
                {
                    result.add(str[j]);
                }
            }
        }
        
        return result;
        
    }
}
