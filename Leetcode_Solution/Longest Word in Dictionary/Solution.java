class Solution {
    public String longestWord(String[] words) {
        HashSet<String> h=new HashSet<String>();
        for(int i=0;i<words.length;i++)
        {
            h.add(words[i]);
        }
        for(int i=0;i<words.length;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(words[i].length()<words[j].length())
                {
                    String temp=words[i];
                    words[i]=words[j];
                    words[j]=temp;
                }
                else if(words[i].length()==words[j].length())
                {
                    if(words[i].compareTo(words[j])>0)
                    {
                            String temp=words[i];
                            words[i]=words[j];
                            words[j]=temp;
                    }
                }
            }
        }
        String result="";
        for(int i=0;i<words.length;i++)
        {
            String str="";
            int flag=1;
            for(int j=0;j<words[i].length()-1;j++)
            {
                str=words[i].substring(0,j+1);
                if(!h.contains(str))
                {
                   flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                result=words[i];
                break;
            }
        }
        
        return result;
    }
    
}
