class Solution {
    public boolean rotateString(String A, String B) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        boolean result=false;
        if(A.length()==B.length())
        {
            for(int i=0;i<B.length();i++)
            {
                if(B.charAt(i)==A.charAt(0))
                {
                    l.add(i);
                }
            }
            
            for(int i=0;i<l.size();i++)
            {
                int t=0,count=0;
                for(int j=l.get(i);j<l.get(i)+B.length();j++)
                {
                    if(A.charAt(t)!=B.charAt(j%B.length()))
                    {
                        count++;
                        break;
                    }
                    t++;
                }
                if(count==0)
                {
                    result=true;
                    break;
                }
            }
        }
        if(A.length()==0 && B.length()==0)
        {
            result=true;
        }
        
        return result;
        
        
    }
}
