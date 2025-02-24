class Solution {
    public String orderlyQueue(String s, int k) {
        if(k>1)
        {
            char c[]=s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
        else
        {
            char c[]=s.toCharArray();
            String res=s;
            for(int i=1;i<c.length;i++)
            {
                char arr[]=new char[s.length()];
                for(int j=0;j<c.length;j++)
                {
                  arr[(j-1+c.length)%c.length]=c[j];
                }
                String st=new String(arr);
                c=arr;
                if(res.compareTo(st)>0)
                {
                    res=st;
                }
            }
            return res;

        }
    }
}
