class Solution {
    public int minAddToMakeValid(String S) {
    int c=0;
    int count=0;
    for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
            {
               c++;
            }
            else
            {
               c--;
               if(c==-1)
               {
                    c=0;
                    count++;
               }
            }
        }
    if(c>0)
        {
            count=count+c;
        }
    
    return count;
    
        
    }
}
