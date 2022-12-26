class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int result=-1;
        int n=words.length;
        for(int i=0;i<n;i++)
        {
            if(words[i].equals(target))
            {
                int x=Math.abs(startIndex-i);
                if(result==-1)
                {
                    result=x;
                }
                else if(result>x)
                {
                  result=x;
                }
                if(startIndex<i)
                {
                  x= n-i+startIndex;
                }
                else
                {
                   x= n-startIndex+i;
                }
                if(result>x)
                {
                   result=x;
                }
            }
        }
        
        return result;
    }
}
