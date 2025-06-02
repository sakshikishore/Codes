class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
       if(numerator%denominator==0)
       {
         long d=denominator*1l;
         long nume=numerator*1l;
         return Long.toString(nume/d);
       }
        StringBuffer sb=new StringBuffer("");
        if((numerator<0 && denominator>=0) || (numerator>=0 && denominator<0))
        {
            sb.append("-");
        }
        long d=denominator*1l;
        long nume=numerator*1l;
        d=Math.abs(d);
        nume=Math.abs(nume);
        sb.append(Long.toString(nume/d));
        sb.append(".");
        long n=nume%d;
        HashMap<Long,Integer> h=new HashMap<Long,Integer>();
        int index=sb.length();
        while(n!=0)
        {
           if(h.containsKey(n))
           {
                 int i=h.get(n);
                 sb.insert(i,"(");
                 sb.append(")");
                 return new String(sb);
           }
           h.put(n,index);
           index++;
           n=n*10;
           long p=n/d;
           sb.append(Long.toString(p));
           n=n%d;
        }

        return new String(sb);

    }
}
