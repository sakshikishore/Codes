class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuffer sb=new StringBuffer(s);
        int i=0;
        while(i<sb.length()-1)
        {
            int flag=0;
            for(int j=i+1;j<sb.length() && j-i<=k; j++)
            {
                if(sb.charAt(j)==sb.charAt(i)){
                    sb.deleteCharAt(j);
                    flag=1;
                    break;
                }
            }

            if(flag==0)
            {
                i++;
            }
            else
            {
                i=0;
            }
        }

        return new String(sb);
    }
}
