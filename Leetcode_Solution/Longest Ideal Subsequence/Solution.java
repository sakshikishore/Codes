class Solution {
    public int longestIdealString(String s, int k) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int max=1;
        int arr[]=new int[s.length()];
        arr[0]=1;
        h.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++)
        {
            int a=s.charAt(i)-'a';
            arr[i]=1;
            for(int j=a;j<=a+k && j<26;j++)
            {
                char c=(char)(97+j);
                if(h.containsKey(c))
                {
                    int index=h.get(c);
                    if(arr[index]+1>arr[i])
                    {
                        arr[i]=arr[index]+1;
                    }
                }
            }
            int x=a-k;
            for(int j=a-1;j>=x && j>=0;j--)
            {
                char c=(char)(97+j);
                if(h.containsKey(c))
                {
                    int index=h.get(c);
                    if(arr[index]+1>arr[i])
                    {
                        arr[i]=arr[index]+1;
                    }
                }
            }
            
            h.put(s.charAt(i),i);
            
            if(arr[i]>max)
            {
                max=arr[i];
            }
        }
        
        
        return max;
    }
}
