class Solution {
    public String predictPartyVictory(String senate) {
        int ch[]=new int[2];
        Deque<Character> dq=new LinkedList<Character>();
        for(int i=0;i<senate.length();i++)
        {
            dq.add(senate.charAt(i));
            if(senate.charAt(i)=='R')
            {
                ch[0]++;
            }
            else
            {
                ch[1]++;
            }
        }
        if(ch[0]==0)
        {
            return "Dire";
        }
        else if(ch[1]==0)
        {
            return "Radiant";
        }

        int d=0,r=0;

        while(dq.size()>0)
        {
            char c=dq.poll();
            if(c=='R')
            {
               if(r==0)
               {
                    d--;
                    ch[1]--;
                    if(ch[1]==0)
                    {
                        return "Radiant";
                    }
                   dq.addLast('R');
               }
               else
               {
                   r++;
               }
            }
            else
            {
                if(d==0)
               {
                   r--;
                   ch[0]--;
                    if(ch[0]==0)
                    {
                        return "Dire";
                    }
                    dq.addLast('D');
               }
               else
               {
                   d++;
               }
            }
           

        }
        return "Radiant";
    }
}
