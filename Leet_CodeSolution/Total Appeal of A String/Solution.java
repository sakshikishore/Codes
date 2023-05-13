class Solution {
    public long appealSum(String s) {
        long result=1;
        int ans[]=new int[s.length()];
        ans[0]=1;
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        h.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),i);
                ans[i]=ans[i-1]+(i+1);
            }
            else
            {
                int index=h.get(s.charAt(i));
                ans[i]=ans[i-1]+(i-index);
                h.put(s.charAt(i),i);
            }
            result+=ans[i];
        }

        return result;
    }
}
