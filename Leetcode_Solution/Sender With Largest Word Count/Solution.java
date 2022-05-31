class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int max=0;
        String result="";
        HashMap<String,Integer> h=new HashMap<String,Integer>();
        for(int i=0;i<messages.length;i++)
        {
            String words[]=messages[i].split(" ");
            if(!h.containsKey(senders[i]))
            {
                h.put(senders[i],words.length);
                if(words.length>max)
                {
                    max=words.length;
                    result=senders[i];
                }
                else if(words.length==max)
                {
                    if(senders[i].compareTo(result)>0)
                    {
                        result=senders[i];
                    }
                }
            }
            else
            {
                h.put(senders[i],h.get(senders[i])+words.length);
                if(h.get(senders[i])>max)
                {
                    max=h.get(senders[i]);
                    result=senders[i];
                }
                else if(h.get(senders[i])==max)
                {
                    if(senders[i].compareTo(result)>0)
                    {
                        result=senders[i];
                    }
                }
            }
        }
        
        return result;
        
    }
}
