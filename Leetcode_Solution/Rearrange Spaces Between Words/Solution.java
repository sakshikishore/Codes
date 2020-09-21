import java.util.regex.*;
class Solution {
    public String reorderSpaces(String text) {
        int count=0;
        Pattern k=Pattern.compile(" ");
        Matcher m=k.matcher(text);
        String output="";
        while(m.find())
        {
            count++;
        }
        
        String str[]=text.trim().split("[ ]+");
        if(count==0)
        {
            output=text;
        }
        else
        {
            if(str.length>1)
            {
                int p=count/(str.length-1);
                output=output+str[0];
                for(int j=0;j<p;j++)
                {
                    output=output+" ";
                }
                for(int i=1;i<str.length-1;i++)
                {
                    output=output+str[i];
                    for(int j=0;j<p;j++)
                    {
                        output=output+" ";
                    }
                }
                output=output+str[str.length-1];
                int l=p*(str.length-1);
                int r=count-l;
                 for(int j=0;j<r;j++)
                    {
                        output=output+" ";
                    }
                
            }
            else
            {
               if(str.length==1)
               {
                   output=output+str[0];
                   for(int j=0;j<count;j++)
                   {
                       output=output+" ";
                   }
               }
            }
            
        }
        return output;
        
    }
}
