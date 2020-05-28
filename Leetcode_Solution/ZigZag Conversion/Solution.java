class Solution {
    public String convert(String s, int numRows) {
        String str="";
        if(s.length()<=2 || numRows==1)
        {
            str=s;
        }
        else
        {
        int l=(numRows-2)*2;
        int h=2;
        for(int i=0;i<numRows;i++)
        {
            if(i==0 || i==numRows-1)
            {
            for(int j=i;j<s.length();j=j+(2*numRows-2))
            {
                str=str+s.substring(j,j+1);
            }
            }
            else
            {
                int j=i;
                int count=0;
                while(j<s.length())
                {
                     str=str+s.substring(j,j+1);
                    if(count==0)
                    {
                     j=j+l;
                        count=1;
                    }
                    else
                    {
                        j=j+h;
                        count=0;
                    }
                }
                    
                
               l=l-2;
               h=h+2;
            }
        }
        }
        return str;
    }
}
