class Solution {
    public String maxValue(String n, int x) {
        String str="";
        int count=0;
        if(n.contains("-"))
        {
            for(int i=1;i<n.length();i++)
            {
                if(Integer.parseInt(n.substring(i,i+1))>x)
                {
                    str=n.substring(0,i)+Integer.toString(x)+n.substring(i);
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                str=n+Integer.toString(x);
            }
        }
        else
        {
            for(int i=0;i<n.length();i++)
            {
                if(Integer.parseInt(n.substring(i,i+1))<x)
                {
                    str=n.substring(0,i)+Integer.toString(x)+n.substring(i);
                    count++;
                    break;
                }
            }
             if(count==0)
            {
                str=n+Integer.toString(x);
            }
        }
        
        return str;
    }
}
