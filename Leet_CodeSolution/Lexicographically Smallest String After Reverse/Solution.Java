 class Solution {
    public String lexSmallest(String s) {
        String str1[]=new String[s.length()];
        String str2[]=new String[s.length()];
        String x="";
        char minChar = 'z';
        for (int i = 0; i < s.length(); i++) {
            x=x+s.charAt(i);
            str1[i]=x;
            if (s.charAt(i) < minChar) {
                minChar = s.charAt(i);
            }
        }
        x="";
        for(int i=s.length()-1;i>=0;i--)
        {
            x=s.charAt(i)+x;
            str2[i]=x;
        }
        String result = s;
        String s1 = "";
        for (int i = 0; i < s.length()-1; i++) {
            s1 = s1 + s.charAt(i);
            if (minChar == s.charAt(i)) {
                StringBuffer p=new StringBuffer(s1);
                String t=new String(p.reverse());
                String r1=t+str2[i+1];
                if(r1.compareTo(result)<0)
                {
                    result=r1;
                }
            }
        }
        s1="";
        for(int i=s.length()-1;i>0;i--)
        {
            s1 = s1 + s.charAt(i);
                String r1=str1[i-1]+s1;
                if(r1.compareTo(result)<0)
                {
                    result=r1;
                }
        }
        StringBuffer sb=new StringBuffer(s);
        String r=new String(sb.reverse());
        if(r.compareTo(result)<0)
        {
            return r;
        }

        return result;
    }
}
