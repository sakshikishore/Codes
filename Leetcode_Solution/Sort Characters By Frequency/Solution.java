class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(!h.containsKey(c))
            {
                count++;
                h.put(c,1);
            }
            else
            {
                h.put(c,h.get(c)+1);
            }
        }
        char ch[]=new char[count];
        int arr[]=new int[count];
        int l=0;
        for(Map.Entry<Character,Integer> m:h.entrySet())
        {
            arr[l]=m.getValue();
            ch[l]=m.getKey();
            l++;
        }
        
        for(int i=0;i<count;i++)
        {
            for(int j=i+1;j<count;j++)
            {
                if(arr[i]<arr[j])
                {
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    
                    char t=ch[i];
                    ch[i]=ch[j];
                    ch[j]=t;
                }
            }
        }
        String result="";
        for(int i=0;i<count;i++)
        {
            for(int j=0;j<arr[i];j++)
            {
                result=result+Character.toString(ch[i]);
            }
        }
        
        return result;
        
    }
}
