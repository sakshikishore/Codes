class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        HashSet<String> hset=new HashSet<String>();
        for(int i=0;i<bannedWords.length;i++)
        {
            hset.add(bannedWords[i]);
        }
        int count=0;
        for(int i=0;i<message.length;i++)
        {
            if(hset.contains(message[i]))
            {
                count++;
                if(count==2)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
