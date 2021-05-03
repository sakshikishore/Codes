class Solution {
    public String replaceDigits(String s) {
        StringBuffer sb=new StringBuffer(s);
        char ch[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=1;i<s.length();i=i+2)
        {
            int p=(s.charAt(i-1)-'a')+Integer.parseInt(s.substring(i,i+1));
            sb.setCharAt(i,ch[p]);
        }
        s=new String(sb);
        return s;
    }
}
