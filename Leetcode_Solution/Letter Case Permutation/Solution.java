class Solution {
    ArrayList<String> l=new ArrayList<String>();
    public void Permute(String str,String s)
    {
        for(int i=0;i<(1<<str.length());i++)
        {
            char ch[]=str.toCharArray();
            for(int j=0;j<str.length();j++)
            {
                if(((i>>j) & 1)==1)
                {
                    ch[j]=(char)(ch[j]-32);
                }
            }
            
            int r=0;
            String y=new String(ch);
            String ptr="";
            for(int x=0;x<s.length();x++)
            {
                if(s.charAt(x)>='a' && s.charAt(x)<='z')
                {
                    ptr+=y.substring(r,r+1);
                    r++;
                }
                else
                {
                    ptr=ptr+s.substring(x,x+1);
                }
            }
            l.add(ptr);
        }
    }
    public List<String> letterCasePermutation(String s) {
        String str="";
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
                str=str+s.substring(i,i+1);
            }
        }
        
        Permute(str,s);
        
        return l;
        
    }
}
