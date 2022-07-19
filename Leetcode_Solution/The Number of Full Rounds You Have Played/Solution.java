class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        String login[]=loginTime.split(":");
        String logout[]=logoutTime.split(":");
        int x=Integer.parseInt(login[0]);
        int y=Integer.parseInt(logout[0]);
        if(y<x)
        {
            y=y+24;
        }
        int a=Integer.parseInt(login[1]);
        int b=Integer.parseInt(logout[1]);
        if(y==x)
        {
            if(a>b)
            {
                y=y+24;
            }
        }
        if(a!=0 && a!=15 && a!=30 && a!=45)
        {
            if(a<15)
            {
                a=15;
            }
            else if(a<30)
            {
                a=30;
            }
            else if(a<45)
            {
                a=45;
            }
            else if(a<60)
            {
                a=0;
                x=x+1;
            }
        }
        if(b!=0 && b!=15 && b!=30 && b!=45)
        {
            if(b<15)
            {
                b=0;
            }
            else if(b<30)
            {
                b=15;
            }
            else if(b<45)
            {
                b=30;
            }
            else if(b<60)
            {
                b=45;
            }
        }
        x=x*60;
        y=y*60;
        x=x+a;
        y=y+b;
        int result=(y-x)/15;
        if(result<0)
        {
            result=0;
        }
        return result;
    }
}
