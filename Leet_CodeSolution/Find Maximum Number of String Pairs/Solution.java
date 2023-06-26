class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> h=new HashSet<String>();
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            String p=words[i].charAt(1)+""+words[i].charAt(0);
            if(h.contains(p))
            {
                count++;
            }
            h.add(words[i]);
        }
        
        return count;
    }
}
