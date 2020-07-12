class Solution {
    public List<String> printVertically(String s) {
        String p[]=s.trim().split("[ ]+");
        ArrayList<String> l=new ArrayList<String>();
        int max=p[0].length();
        for(int i=1;i<p.length;i++)
        {
            if(p[i].length()>max)
            {
                max=p[i].length();
            }
        }
        
        for(int i=0;i<max;i++)
        {
            String str="";
            int count=0;
            for(int j=0;j<p.length;j++)
            {
                if(p[j].length()>i)
                {
                    count=j;
                    str=str+p[j].substring(i,i+1);
                }
                else
                {
                    str=str+" ";
                }
            }
           
            l.add(str.substring(0,count+1));
        }
        
       
        return l;
        
    }
}
