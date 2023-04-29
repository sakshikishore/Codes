class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())
        {
            return "0";
        }
       Deque<Character> dq=new LinkedList<Character>();
       int i=1;
        dq.add(num.charAt(0));
        int j=0;
        while(i<num.length() && j<k) 
        {
            if(dq.size()>0)
            {
                if(dq.getLast()>num.charAt(i))
                {
                    
                    dq.removeLast();
                    j++;
                }
                else
                {
                    dq.add(num.charAt(i));
                    i++;
                }
            }
            else
            {
                dq.add(num.charAt(i));
                i++;
            }
        }
        while(i<num.length())
        {
            dq.add(num.charAt(i));
            i++;
        }
        if(k!=j)
        {
            while(k!=j)
            {
               dq.removeLast();
               j++;
            }
        }
       String result="";
        int flag=0;
        StringBuffer sb=new StringBuffer("");
        while(dq.size()>0)
        {
           char c=dq.poll();
           if(flag==0)
           {
               if(c!='0')
               {
                   sb.append(c);
                   flag=1;
               }
           }
           else
           {
               sb.append(c);
           }
        }
        result=new String(sb);
        if(result.length()==0)
        {
            return "0";
        }
        return result;

    }
}
