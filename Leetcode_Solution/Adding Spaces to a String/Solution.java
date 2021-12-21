class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuffer sb=new StringBuffer(s);
        int l=0;
        for(int i=0;i<spaces.length;i++)
        {
            spaces[i]=spaces[i]+l;
            sb.insert(spaces[i]," ");
            l++;
        }
        
        return sb.toString();
    }
}
