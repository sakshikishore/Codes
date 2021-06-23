class Solution {
    public String numberToWords(int num) {
        String result="";
        if(num==0)
        {
            result="Zero";
        }
        else
        {
        HashMap<Integer,String> h=new HashMap<Integer,String>();
        h.put(1,"One");
        h.put(2,"Two");
        h.put(3,"Three");
        h.put(4,"Four");
        h.put(5,"Five");
        h.put(6,"Six");
        h.put(7,"Seven");
        h.put(8,"Eight");
        h.put(9,"Nine");
        h.put(10,"Ten");
        h.put(11,"Eleven");
        h.put(12,"Twelve");
        h.put(13,"Thirteen");
        h.put(14,"Fourteen");
        h.put(15,"Fifteen");
        h.put(16,"Sixteen");
        h.put(17,"Seventeen");
        h.put(18,"Eighteen");
        h.put(19,"Nineteen");
        h.put(20,"Twenty");
        h.put(30,"Thirty");
        h.put(40,"Forty");
        h.put(50,"Fifty");
        h.put(60,"Sixty");
        h.put(70,"Seventy");
        h.put(80,"Eighty");
        h.put(90,"Ninety");
        h.put(100,"Hundred");
        h.put(1000,"Thousand");
        int n=num;
        int i=1;
        int p=0,q=0;
        int a=-1,b=-1,c=-1,d=-1;
        while(n>0)
        {
            int r=n%10;
            if(r!=0)
            {
                if(i==1)
                {
                    if(n<10)
                    {
                    result=h.get(r)+result;
                    }
                    else
                    {
                        p=r;
                    }
                }
               else if(i==10)
                {
                   if(r==1)
                   {
                        result=h.get(10+p)+" "+result;
                   }
                   else
                   {
                       if(p!=0)
                       {
                        result=h.get(p)+result;
                        result=h.get(r*i)+" "+result;
                       }
                       else
                       {
                           result=h.get(r*i)+result;
                       }
                   }
                    p=0;
                }
                else if(i==100)
                {
                    result=h.get(r)+" Hundred "+result;
                }
                else if(i==1000)
                {
                    if(n<10)
                    {
                        result=h.get(r)+" Thousand "+result;
                    }
                    else
                    {
                    p=r;
                    }
                }
                else if(i==10000)
                {
                    if(r==1)
                    {
                        q=1*10+p;
                        result=h.get(q)+" Thousand "+result;
                    }
                    else
                    {
                        if(p!=0)
                        {
                        result=h.get(p)+" Thousand "+result;
                        result=h.get(r*10)+" "+result;
                        }
                        else
                        {
                             result=h.get(r*10)+" Thousand "+result;
                        }
                        
                    }
                    p=0;
                }
                else if(i==100000)
                {
                   if(a==0 && b==0)
                   {
                       result=h.get(r)+" Hundred Thousand "+result;
                   }
                  else
                  {
                     result=h.get(r)+" Hundred "+result;
                  }
                }
                else if(i==1000000)
                {
                   if(n<10)
                    {
                        result=h.get(r)+" Million "+result;
                    }
                    else
                    {
                    p=r;
                    }
                }
                 else if(i==10000000)
                {
                   if(r==1)
                   {
                       result=h.get(1*10+p)+" Million "+result;
                   }
                   else
                   {
                       if(p!=0)
                       {
                       result=h.get(p)+" Million "+result;
                       result=h.get(r*10)+" "+result;
                       }
                       else
                       {
                            result=h.get(r*10)+" Million "+result;
                       }
                       
                   }
                     p=0;
                }
                else if(i==100000000)
                {
                    if(c==0 && d==0)
                    {
                         result=h.get(r)+" Hundred Million "+result;
                    }
                    else
                    {
                    result=h.get(r)+" Hundred "+result;
                    }
                   
                }
                else if(i==1000000000)
                {
                    result=h.get(r)+" Billion "+result;
                }
            }
            else
            {
                if(i==10)
                {
                    if(p!=0)
                    {
                        result=h.get(p)+result;
                        p=0;
                    }
                }
                else if(i==10000)
                {
                    b=0;  
                    if(p!=0)
                    {
                        result=h.get(p)+" Thousand "+result;
                        p=0;
                    }
                }
                else if(i==10000000)
                {
                    d=0;
                     if(p!=0)
                    {
                        result=h.get(p)+" Million "+result;
                        p=0;
                    }
                }
                else if(i==1000000)
                {
                    c=0;
                }
                else if(i==1000)
                {
                    a=0;
                }
            }
            n=n/10;
            i=i*10;
        }
    }
        if(result.substring(result.length()-1).equals(" "))
        {
            result=result.substring(0, result.length()-1);
        }
        
        return result;
        
    }
}
