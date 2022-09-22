class Solution {
    String res="";
    int count=0;
    public void permutation(String str, String result, int k)
    {
        if(str.length()==0)
        {
            count++;
            if(count==k)
            {
                res=result;
                return;
            }
        }
        else
        {
            for(int i=0;i<str.length();i++)
            {
                if(count==k)
                {
                    break;
                }
                char c=str.charAt(i);
                String p=str.substring(0,i)+str.substring(i+1);
                permutation(p,result+c,k);
            }
        }
    }
    public String getPermutation(int n, int k) {
      
        String str="";
        for(int i=1;i<=n;i++)
        {
            str=str+Integer.toString(i);
        }
        permutation(str,"",k);
        return res;
    }
}
