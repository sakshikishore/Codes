import java.math.BigInteger;
class Solution {
    public boolean splitString(String s) {
        boolean result=false;
        List<List<String>> list=new ArrayList();

        for(int i=0;i<s.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        
        for(int i=0;i<s.length();i++)
        {
            String str=s.substring(0,i+1);
            if(i==0)
            {
                list.get(i).add(str);
            }
            else
            {
                list.get(i).add(str);
                for(int j=i;j>=1;j--)
                {
                     String p=s.substring(j,str.length());
                     BigInteger x=new BigInteger(p);
                    for(int k=0;k<list.get(j-1).size();k++)
                    {
                        String a=list.get(j-1).get(k);
                        String z[]=a.split(" ");
                        BigInteger y=new BigInteger(z[z.length-1]);
                        BigInteger sub=y.subtract(x);
                        if(sub.equals(BigInteger.valueOf(1)))
                        {
                             a=a+" "+p;
                              list.get(i).add(a);
                        }
                    }
                }
            }
        }
        int n=s.length()-1;
        for(int x=0;x<list.get(n).size();x++)
        {
            String str[]=list.get(n).get(x).split(" ");
            if(str.length>1)
            {
                result=true;
                break;
            }
        }
        
        return result;
    }
}
