class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int result=0;
        String s[]=arriveAlice.split("-");
        int alice_start_day=Integer.parseInt(s[1]);
        int alice_start_month=Integer.parseInt(s[0]);
        s=leaveAlice.split("-");
        int alice_end_day=Integer.parseInt(s[1]);
        int alice_end_month=Integer.parseInt(s[0]);
        int day[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        HashSet<String> h=new HashSet<String>();
        for(int i=alice_start_month;i<alice_end_month;i++)
        {
            if(i==alice_start_month)
            {
                for(int j=alice_start_day;j<=day[i-1];j++)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    h.add(str);
                }
            }
            else
            {
                for(int j=1;j<=day[i-1];j++)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    h.add(str);
                }
            }
        }
        if(alice_start_month==alice_end_month)
        {
            for(int i=alice_start_day;i<=alice_end_day;i++)
            {
                String str=Integer.toString(alice_start_month)+" "+Integer.toString(i);
                h.add(str);
            }
        }
        else
        {
            for(int j=1;j<=alice_end_day;j++)
            {
                String str=Integer.toString(alice_end_month)+" "+Integer.toString(j);
                h.add(str);
            }
        }
        s=arriveBob.split("-");
        int bob_start_day=Integer.parseInt(s[1]);
        int bob_start_month=Integer.parseInt(s[0]);
        
        s=leaveBob.split("-");
        int bob_end_day=Integer.parseInt(s[1]);
        int bob_end_month=Integer.parseInt(s[0]);
        for(int i=bob_start_month;i<bob_end_month;i++)
        {
            if(i==bob_start_month)
            {
                for(int j=bob_start_day;j<=day[i-1];j++)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                    if(h.contains(str))
                    {
                        result++;
                    }
                }
            }
            else
            {
                for(int j=1;j<=day[i-1];j++)
                {
                    String str=Integer.toString(i)+" "+Integer.toString(j);
                     if(h.contains(str))
                    {
                        result++;
                    }
                }
            }
        }
        
        if(bob_start_month==bob_end_month)
        {
            for(int i=bob_start_day;i<=bob_end_day;i++)
            {
                    String str=Integer.toString(bob_start_month)+" "+Integer.toString(i);
                    if(h.contains(str))
                    {
                        result++;
                    }
            }
        }
        else
        {
            for(int j=1;j<=bob_end_day;j++)
            {
                String str=Integer.toString(bob_end_month)+" "+Integer.toString(j);
                if(h.contains(str))
                    {
                        result++;
                    }
            }
        }
        return result;
        
        
    }
}
