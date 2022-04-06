class Solution {
    public int convertTime(String current, String correct) {
    int carry=0;
    int result=0;
    int a=Integer.parseInt(current.substring(0,1));
    int b=Integer.parseInt(current.substring(1,2));
    int c=Integer.parseInt(current.substring(3,4));
    int d=Integer.parseInt(current.substring(4));
        
    int m=Integer.parseInt(correct.substring(0,1));
    int n=Integer.parseInt(correct.substring(1,2));
    int o=Integer.parseInt(correct.substring(3,4));
    int p=Integer.parseInt(correct.substring(4));
    
    int l=a*10+b;
    int r=c*10+d;
        
    int s=m*10+n;
    int t=o*10+p;
    int x=0,y=0;
    if(t==r)
    {
        y=0;
    }
    else if(t>r)
    {
        y=t-r;
    }
    else
    {
        y=t+60-r;
        carry=1;
    }
        if(carry==1)
        {
            s=s-1;
            x=s-l;
        }
        else
        {
            x=s-l;
        }
    result=result+x;
    if(y>=15)
    {
        result+=y/15;
        y=y%15;
    }
    if(y>=5)
    {
        result+=y/5;
        y=y%5;
    }
    if(y>=1)
    {
        result+=y;
    }
        
        return result;
}
}
