class Solution {
    public String digitSum(String s, int k) {
        String str=s;
        while(str.length()>k)
        {
            String r="";
            for(int j=0;j<str.length();j=j+k)
            {
                String p="";
                if(j+k>str.length())
                {
                    p=str.substring(j);
                }
                else
                {
                p=str.substring(j,j+k);
                }
                int sum=0;
                for(int i=0;i<p.length();i++)
                {
                    sum+=Integer.parseInt(p.substring(i,i+1));
                }
                r=r+Integer.toString(sum);
            }
            str=r;
        }
        
        return str;
    }
}
