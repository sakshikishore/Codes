import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        boolean result=false;
        List<List<String>> list=new ArrayList();
        for(int i=0;i<num.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        for(int i=0;i<num.length();i++)
        {
            String str=num.substring(0,i+1);
            if(i==0)
            {
              list.get(i).add(str);
            }
            else
            {
                if(str.charAt(0)!='0')
                {
                     list.get(i).add(str);
                }
            }
            for(int j=i-1;j>=0;j--)
            {
                String s=str.substring(j+1);
                BigInteger c=new BigInteger(s);
                  if((s.charAt(0)=='0' && !c.equals(BigInteger.valueOf(0)))|| (c.equals(BigInteger.valueOf(0)) && s.length()>1))
                   {
                       continue;
                   }
                else
                {
                    for(int k=0;k<list.get(j).size();k++)
                    {
                        String p=list.get(j).get(k);
                        String st[]=p.split(" ");
                        if(st.length<2)
                        {
                            list.get(i).add(p+" "+s);
                        }
                        else
                        {
                            BigInteger a=new BigInteger(st[st.length-1]);
                            BigInteger b=new BigInteger(st[st.length-2]);
                            BigInteger sum=a.add(b);
                            if(sum.equals(c))
                            {
                                if(i==num.length()-1)
                                {
                                    result=true;
                                    break;
                                }
                                list.get(i).add(p+" "+s);
                            }
                        }
                    }
                    if(result)
                    {
                        break;
                    }
                }
            }
            if(result)
            {
                break;
            }
        }
        
        return result;
    }
}
