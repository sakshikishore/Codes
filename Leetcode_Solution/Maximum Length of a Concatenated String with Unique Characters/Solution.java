class Solution {
    public int getSolution(List<String> arr,int index,int ch[])
    {
        if(index==arr.size())
        {
            return 0;
        }
        int a=getSolution(arr,index+1,ch);
        int b=0;
        String s=arr.get(index);
        int score=0,flag=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
            if(ch[s.charAt(i)-'a']>1)
            {
                flag=1;
            }
            score+=1;
        }
        if(flag==0)
        {
            b=score+getSolution(arr,index+1,ch);
        }
        
            for(int i=0;i<s.length();i++)
            {
                ch[s.charAt(i)-'a']--;
            }
        
        
        return Math.max(a,b);
    
        
    }
    public int maxLength(List<String> arr) {
        int ch[]=new int[26];
       return getSolution(arr,0,ch);
    }
}
