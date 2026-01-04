class Solution {
    public String reversePrefix(String s, int k) {
        String str=s.substring(0,k);
        StringBuffer sb=new StringBuffer(str);
        String p=new String(sb.reverse());
        return p+s.substring(k);
    }
}

//Another Solution

class Solution {
    public String reversePrefix(String s, int k) {
        char ch[]=s.toCharArray();
        int i=0,j=k-1;
        while(i<j)
        {
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }

        return new String(ch);
    }
}
