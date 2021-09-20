class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int p=(int)Math.pow(2,n);
        l.add(0);
        l.add(1);
        for(int i=2;i<p;i++)
        {
            String str=Integer.toBinaryString(i);
            String s=str.substring(0,1);
            for(int j=0;j<str.length()-1;j++)
            {
                if(str.charAt(j)!=str.charAt(j+1))
                {
                    s=s+"1";
                }
                else
                {
                    s=s+"0";
                }
            }
            l.add(Integer.parseInt(s,2));
        }
        
        return l;
        
    }
}
