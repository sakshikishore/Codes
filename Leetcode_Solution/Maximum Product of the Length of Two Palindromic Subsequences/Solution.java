class Solution {
    public int longestPalindromeSubsequence(String s)
    {
        int arr[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<s.length()-i;j++)
            {
                if(i==0)
                {
                    arr[j][j]=1;
                }
                else
                {
                    String str=s.substring(j,j+i+1);
                    if(str.charAt(0)==str.charAt(str.length()-1))
                    {
                        arr[j][j+i]=2+arr[j+1][j+i-1];
                    }
                    else
                    {
                        arr[j][j+i]=Math.max(arr[j][j+i-1],arr[j+1][j+i]);
                    }
                }
            }
        }
        
        return arr[0][s.length()-1];
    }
    public int maxProduct(String s) {
        int max=0;
        List<HashSet<Integer>> list=new ArrayList();
        int n=s.length();
        for(int i=0;i<(1<<n);i++)
        {
            HashSet<Integer> l=new HashSet<Integer>();
            for(int j=0;j<n;j++)
            {
                if((i & (1<<j))>0)
                {
                    l.add(j);
                }
            }
            if(l.size()>0 && l.size()<s.length())
            {
             list.add(l);
            }
        }
        for(int i=0;i<list.size();i++)
        {
            String s1="";
            String s2="";
            Iterator<Integer> itr=list.get(i).iterator();
            while(itr.hasNext())
            {
                int index=itr.next();
                s1=s1+s.charAt(index);
            }
            HashSet<Integer> h=list.get(i);
            for(int j=0;j<s.length();j++)
            {
                if(!h.contains(j))
                {
                    s2=s2+s.charAt(j);
                }
            }
           int x=longestPalindromeSubsequence(s1);
           int y=longestPalindromeSubsequence(s2);
            if(x*y>max)
            {
                max=x*y;
            }
        }
        
        return max;
    }
}
