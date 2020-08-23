class Solution {
    public char findKthBit(int n, int k) {
        String p="0";
        for(int i=1;i<n;i++)
        {
            String l=p;
            p=p.replaceAll("0","a");
            p=p.replaceAll("1","0");
            p=p.replaceAll("a","1");
            StringBuffer sb=new StringBuffer(p);
            String t=new String(sb.reverse());
            String q=l+"1"+t;
            p=q;
        }
      
        return p.charAt(k-1);
    }
}
