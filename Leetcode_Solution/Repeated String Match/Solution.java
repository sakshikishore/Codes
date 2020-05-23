class Solution {
    public int repeatedStringMatch(String A, String B) {
        int count=0;
        String s="abcdefghijklmnopqrstuvwxyz";
        for(int i=0;i<26;i++)
        {
            if(B.contains(s.substring(i,i+1)) && !A.contains(s.substring(i,i+1)))
            {
                count=-1;
                break;
            }
        }
        if(count!=-1)
        {
        int flag=0;
        String str="";
        while(flag!=1)
        {
            count++;
            str=str+A;
            if(str.contains(B))
            {
                flag=1;
            }
            else
            {
                if(str.length()>4*A.length() && str.length()>4*B.length())
                {
                    count=-1;
                    break;
                }
            }
        }    
        }
        return count;
    }
}
