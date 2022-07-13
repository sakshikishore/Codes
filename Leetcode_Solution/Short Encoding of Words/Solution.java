class Solution {
    public int minimumLengthEncoding(String[] words) {
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
            }
        }
        
        int count=words[0].length()+1;
        for(int i=1;i<words.length;i++)
        {
            int flag=0;
            for(int j=0;j<i;j++)
            {
                if(words[i].equals(words[j].substring(words[j].length()-words[i].length())))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                count+=words[i].length()+1;
            }
        }
        
        return count;
        
    }
}
