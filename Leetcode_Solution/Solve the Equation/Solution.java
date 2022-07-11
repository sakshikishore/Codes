class Solution {
    public String solveEquation(String equation) {
        String st[]=equation.split("=");
        Stack<String> stck=new Stack<String>();
            String str="";
        String s=st[0];
            for(int i=0;i<st[0].length();i++)
            {
                if(s.charAt(i)=='+')
                {
                    if(str.length()>0)
                    {
                     stck.push(str);
                    }
                    stck.push("+");
                    str="";
                }
                else if(s.charAt(i)=='-')
                {
                    if(str.length()>0)
                    {
                     stck.push(str);
                    }
                    stck.push("-");
                    str="";
                }
                else
                {
                    str=str+s.substring(i,i+1);
                }
            }
      if(str.length()>0)
      {
          stck.push(str);
      }
        int x=0;
        int a=0;
        while(!stck.empty())
        {
            String s1=stck.pop();
            if(s1.contains("x"))
            {
                if(!stck.empty())
                {
                    String s2=stck.pop();
                    if(s2.equals("+"))
                    {
                        if(s1.length()>1)
                        {
                        x=x+Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x=x+1;
                        }
                    }
                    else
                    {
                        if(s1.length()>1)
                        {
                        x=x-Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x=x-1;
                        }
                    }
                }
                else
                {
                    if(s1.length()>1)
                        {
                        x=x+Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x=x+1;
                        }
                }
            }
            else
            {
                if(!stck.empty())
                {
                    String s2=stck.pop();
                    if(s2.equals("+"))
                    {
                       
                        a=a+Integer.parseInt(s1);
                     
                        
                    }
                    else
                    {
                      
                        a=a-Integer.parseInt(s1);
                      
                        
                    }
                }
                else
                {
                    a=a+Integer.parseInt(s1);
                }
            }
        }
//********************************
    str="";
    s=st[1];
    stck=new Stack<String>();
    for(int i=0;i<st[1].length();i++)
            {
                if(s.charAt(i)=='+')
                {
                     if(str.length()>0)
                    {
                     stck.push(str);
                    }
                    stck.push("+");
                    str="";
                }
                else if(s.charAt(i)=='-')
                {
                     if(str.length()>0)
                    {
                     stck.push(str);
                    }
                    stck.push("-");
                    str="";
                }
                else
                {
                    str=str+s.substring(i,i+1);
                }
            }
      if(str.length()>0)
      {
          stck.push(str);
      }
        int x1=0;
        int b=0;
        while(!stck.empty())
        {
            String s1=stck.pop();
            if(s1.contains("x"))
            {
                if(!stck.empty())
                {
                    String s2=stck.pop();
                    if(s2.equals("+"))
                    {
                        if(s1.length()>1)
                        {
                        x1=x1+Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x1=x1+1;
                        }
                    }
                    else
                    {
                        if(s1.length()>1)
                        {
                        x1=x1-Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x1=x1-1;
                        }
                    }
                }
                else
                {
                    if(s1.length()>1)
                        {
                        x1=x1+Integer.parseInt(s1.substring(0,s1.length()-1));
                        }
                        else
                        {
                            x1=x1+1;
                        }
                }
            }
            else
            {
                if(!stck.empty())
                {
                    String s2=stck.pop();
                    if(s2.equals("+"))
                    {
                       
                        b=b+Integer.parseInt(s1);
                      
                        
                    }
                    else
                    {
                      
                        b=b-Integer.parseInt(s1);

                        
                    }
                }
                else
                 {
                    b=b+Integer.parseInt(s1);
                }
            }
        }
            String result="x=";
        if(x==x1 && b-a==0)
        {
            result="Infinite solutions";
        }
        else if(x==x1 && b-a!=0)
        {
            result="No solution";
        }
        else
        {
            int p=x-x1;
            int q=b-a;
            p=q/p;
            result=result+Integer.toString(p);
        }
            return result;
        
    }
}
