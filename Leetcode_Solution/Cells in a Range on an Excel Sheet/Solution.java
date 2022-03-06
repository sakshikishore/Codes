class Solution {
    public List<String> cellsInRange(String s) {
        ArrayList<String> l=new ArrayList<String>();
        int r1=Integer.parseInt(s.substring(1,2));
        int r2=Integer.parseInt(s.substring(4));
        int c1=s.charAt(0)-'A';
        int c2=s.charAt(3)-'A';
        for(int i=c1;i<=c2;i++)
        {
            for(int j=r1;j<=r2;j++)
            {
                String str=((char)(65+i))+Integer.toString(j);
                l.add(str);
            }
        }
        
        return l;
    }
}
