class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        HashMap<String,String> h=new HashMap<String,String>();
        String res="";
        for(int i=0;i<indices.length;i++)
        {
            if(sources[i].equals(s.substring(indices[i],indices[i]+sources[i].length())))
            {
               h.put(Integer.toString(indices[i])+" "+Integer.toString(indices[i]+sources[i].length()),targets[i]);
            }
        }
        int i=0;
       while(i<s.length())
        {
            int count=0;
            for(int j=i+1;j<=s.length();j++)
            {
                if(h.containsKey(Integer.toString(i)+" "+Integer.toString(j)))
                {
                    res=res+h.get(Integer.toString(i)+" "+Integer.toString(j));
                    i=j-1;
                    count++;
                break;
                }
            }
            if(count==0)
            {
                res=res+s.substring(i,i+1);
            }
           i++;
        }
        
        return res;
        
    }
}
