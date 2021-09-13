class Solution {
    public String reversePrefix(String word, char ch) {
        int index=word.indexOf(ch);
        String str=word.substring(0,index+1);
        StringBuffer sb=new StringBuffer(str);
        String s=new String(sb.reverse());
        
        return s+word.substring(index+1);     
    }
}
