class Solution {
    public int addMinimum(String word) {
        int result=0;
        Queue<Character> q=new LinkedList<Character>();
        for(int i=0;i<word.length();i++)
        {
            q.add(word.charAt(i));
        }
        int a=1,b=0,c=0;
        while(q.size()>0)
        {
            char ch=q.peek();
            if(a==1)
            {
                if(ch!='a')
                {
                    result++;
                }
                else
                {
                    q.poll();
                }
                a=0;
                b=1;
                c=0;
            }
            else if(b==1)
            {
                if(ch!='b')
                {
                    result++;
                }
                else
                {
                    q.poll();
                }
                a=0;
                b=0;
                c=1;
            }
            else
            {
                if(ch!='c')
                {
                    result++;
                }
                else
                {
                    q.poll();
                }
                a=1;
                b=0;
                c=0;
            }
        }
        if(b==1)
        {
            result+=2;
        }
        else if(c==1)
        {
            result+=1;
        }
        
        return result;
    }
}
