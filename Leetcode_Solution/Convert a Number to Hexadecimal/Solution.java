class Solution {
    public String toHex(int num) {
    HashMap<String,String> h=new HashMap<String,String>();
        String result="";
        h.put("0000","0");
        h.put("0001","1");
        h.put("0010","2");
        h.put("0011","3");
        h.put("0100","4");
        h.put("0101","5");
        h.put("0110","6");
        h.put("0111","7");
        h.put("1000","8");
        h.put("1001","9");
        h.put("1010","a");
        h.put("1011","b");
        h.put("1100","c");
        h.put("1101","d");
        h.put("1110","e");
        h.put("1111","f");
        if(num==0)
        {
            result="0";
        }
        else if(num==Integer.MIN_VALUE)
        {
            result="80000000";
        }
       else if(num>0)
        {
            String str="";
            while(num!=0)
            {
                int r=num%2;
                str=Integer.toString(r)+str;
                num=num/2;
            }
            if(str.length()%4!=0)
            {
                while(str.length()%4!=0)
                {
                    str="0"+str;
                }
            }
            for(int i=0;i<str.length();i=i+4)
            {
                result=result+h.get(str.substring(i,i+4));
            }
        }
        else
        { 
             num=num*-1;
            String str="";
            while(num!=0)
            {
                int r=num%2;
                str=Long.toString(r)+str;
                num=num/2;
            }
            while(str.length()<32)
            {
                str="0"+str;
            }
            // 1's complement
            str=str.replaceAll("0","p");
            str= str.replaceAll("1","0");
            str= str.replaceAll("p","1");
            System.out.println(str);
            StringBuffer sb=new StringBuffer(str);
            for(int i=31;i>=0;i--)
            {
                if(sb.charAt(i)=='0')
                {
                    sb.setCharAt(i,'1');
                    break;
                }
                else
                {
                    sb.setCharAt(i,'0');
                }
            }
            
            System.out.println(sb);
            
             for(int i=0;i<32;i=i+4)
            {
                result=result+h.get(sb.substring(i,i+4));
            }
            
        }
        
        return result;
       
    }
}
