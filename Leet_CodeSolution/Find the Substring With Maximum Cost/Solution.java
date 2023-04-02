class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int max=0;
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        for(int i=0;i<vals.length;i++)
        {
            h.put(chars.charAt(i),vals[i]);
        }
        for(int i=1;i<=26;i++)
        {
            char ch=(char)(97+i-1);
            if(!h.containsKey(ch))
            {
                h.put(ch,i);
            }
        }
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            ans+=h.get(s.charAt(i));
            if(ans>max)
            {
                max=ans;
            }
            if(ans<0)
            {
                ans=0;
            }
        }
        
        return max;
    }
}
