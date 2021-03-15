class Solution {
    public String intToRoman(int num) {
        String p=Integer.toString(num);
        String str[]=new String[p.length()];
        String result="";
        int t=0;
        for(int i=p.length()-1;i>=0;i--)
        {
            str[i]="";
            if(t==0)
            {
                if(p.charAt(i)=='9')
                {
                    str[i]="IX";
                }
                else if(p.charAt(i)=='4')
                {
                    str[i]="IV";
                }
                else if(p.charAt(i)<'4')
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    for(int j=0;j<l;j++)
                    {
                        str[i]=str[i]+"I";
                    }
                }
                else
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    str[i]="V";
                    for(int j=0;j<l-5;j++)
                    {
                        str[i]=str[i]+"I";
                    }
                }
             }
            
             else if(t==1)
             {
                
                if(p.charAt(i)=='9')
                {
                    str[i]="XC";
                }
                else if(p.charAt(i)=='4')
                {
                    str[i]="XL";
                }
                else if(p.charAt(i)<'4')
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    for(int j=0;j<l;j++)
                    {
                        str[i]=str[i]+"X";
                    }
                }
                else
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    str[i]="L";
                    for(int j=0;j<l-5;j++)
                    {
                        str[i]=str[i]+"X";
                    }
                }
                
            }
            
            else if(t==2)
            {
                if(p.charAt(i)=='9')
                {
                    str[i]="CM";
                }
                else if(p.charAt(i)=='4')
                {
                    str[i]="CD";
                }
                else if(p.charAt(i)<'4')
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    for(int j=0;j<l;j++)
                    {
                        str[i]=str[i]+"C";
                    }
                }
                else
                {
                    int l= Integer.parseInt(p.substring(i,i+1));
                    str[i]="D";
                    for(int j=0;j<l-5;j++)
                    {
                        str[i]=str[i]+"C";
                    }
                }
            }
            else
            { 
                    int l= Integer.parseInt(p.substring(i,i+1));
                    for(int j=0;j<l;j++)
                    {
                        str[i]=str[i]+"M";
                    }
              
            }
            t++;
        }
        
        for(int i=0;i<str.length;i++)
        {
            System.out.println(str[i]);
            result=result+str[i];
        }
        
        return result;
        
    }
}
