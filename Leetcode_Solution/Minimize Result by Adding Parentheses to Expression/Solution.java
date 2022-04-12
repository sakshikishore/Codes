import java.util.regex.*;
class Solution {
    public String minimizeResult(String expression) {
        String str[]=expression.split("\\+");
        String result="("+expression+")";
        int min= 0;
        min=Integer.parseInt(str[0])+Integer.parseInt(str[1]);
        int p=0,l=min;
        for(int i=0;i<str[0].length();i++)
        {
            int x=0;
            int r=0;
            if(i-1>=0)
            {
                p=p*10+Integer.parseInt(str[0].substring(i-1,i));
            }
            for(int j=str[1].length()-1;j>=0;j--)
            {
                if(j!=str[1].length()-1)
                {
                   
                 r=Integer.parseInt(str[1].substring(j+1,j+2))*(int)Math.pow(10,x)+r;
                 x++;
                    
                }
                
                if(i!=0)
                {
                    if(j==str[1].length()-1)
                    {

                      l=((Integer.parseInt(str[0].substring(i)))+Integer.parseInt(str[1]));
                      l=l*p;
                      if(l<min)
                      {
                         min =l;
                         result= str[0].substring(0,i)+"("+str[0].substring(i)+"+"+str[1]+")";
                      }
                    }
                    else
                    {
                     l=((Integer.parseInt(str[0].substring(i)))+(Integer.parseInt(str[1].substring(0,j+1))));
                     l=l*p*r;
                      if(l<min)
                      {
                         min =l;
                         result=str[0].substring(0,i)+"("+str[0].substring(i)+"+"+str[1].substring(0,j+1)+")"+str[1].substring(j+1);
                      }
                    }
                }
                else
                {
                    if(j!=str[1].length()-1)
                    {
                        l=(Integer.parseInt(str[0])+(Integer.parseInt(str[1].substring(0,j+1))));
                        l=l*r;
                         if(l<min)
                          {
                             min=l;
                             result="("+str[0]+"+"+str[1].substring(0,j+1)+")"+str[1].substring(j+1);
                          }
                    }                     
                }
            }
        }
        
        return result;
        
    }
                                        
}
