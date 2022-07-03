class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> h=new HashMap<Character,Character>();
        int j=0;
        for(int i=0;i<key.length();i++)
        {
            if(key.charAt(i)>='a' && key.charAt(i)<='z')
            {
                if(!h.containsKey(key.charAt(i)))
                {
                    h.put(key.charAt(i),(char)(97+j));
                    j++;
                    if(j==26)
                    {
                        break;
                    }
                }
            }
        }
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<message.length();i++)
        {
           if(message.charAt(i)>='a' && message.charAt(i)<='z')
           {
               sb.append(Character.toString(h.get(message.charAt(i))));
           }
           else
           {
              sb.append(message.substring(i,i+1));
           }
        }
        
        return sb.toString();
        
    }
}
