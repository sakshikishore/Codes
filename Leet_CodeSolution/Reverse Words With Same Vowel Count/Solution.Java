class Solution {
    public String reverseWords(String s) {
        String str[]=s.split(" ");
        int cnt=0;
        for(int i=0;i<str[0].length();i++)
        {
            if(str[0].charAt(i)=='a' || str[0].charAt(i)=='e' || str[0].charAt(i)=='i' || str[0].charAt(i)=='o' || str[0].charAt(i)=='u')
            {
                cnt++;
            }
        }
        StringBuffer sb=new StringBuffer("");
        sb.append(str[0]);
        for(int i=1;i<str.length;i++)
        {
            int count=0;
            for(int j=0;j<str[i].length();j++)
            {
                if(str[i].charAt(j)=='a' || str[i].charAt(j)=='e' || str[i].charAt(j)=='i' || str[i].charAt(j)=='o' || str[i].charAt(j)=='u')
                {
                    count++;
                }
            }
            if(count==cnt)
            {
                StringBuffer p=new StringBuffer(str[i]);
                sb.append(" ");
                sb.append(p.reverse());
            }
            else
            {
                sb.append(" ");
                sb.append(str[i]);
            }
        }

        return new String(sb);
    }
}
