class Solution {
    public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> h=new HashMap<String,Integer>();
        int count=0;
    for(int i=0;i<words.length;i++)
    {
        if(!h.containsKey(words[i]))
        {
            h.put(words[i],1);
            count++;
        }
        else
        {
            h.put(words[i],h.get(words[i])+1);
        }
    }
        
        int arr[]=new int[count];
        String str[]=new String[count];
        int l=0;
        for(Map.Entry<String,Integer> m:h.entrySet())
        {
            arr[l]=m.getValue();
            str[l]=m.getKey();
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
                    
                    String t=str[i];
                    str[i]=str[j];
                    str[j]=t;
                }
               else if(arr[i]==arr[j])
                {
                    if(str[i].compareTo(str[j])>0)
                    {
                         String t=str[i];
                         str[i]=str[j];
                         str[j]=t;
                    }
                }
            }
        }
        ArrayList<String> result=new ArrayList<String>();
        for(int i=0;i<k;i++)
        {
            result.add(str[i]);
        }
        
        return result;
        
    }
}
