class Solution {
    public String[] findWords(String[] words) {
        String str[][]=new String[3][2];
        str[0][0]="QWERTYUIOP";
        str[0][1]="qwertyuiop";
        str[1][0]="ASDFGHJKL";
        str[1][1]="asdfghjkl";
        str[2][0]="ZXCVBNM";
        str[2][1]="zxcvbnm";
        ArrayList<String> l=new ArrayList<String>();
        int p=0,q=0;
        
        for(int i=0;i<words.length;i++)
        {
            int count=0;
             if(str[0][0].contains(words[i].substring(0,1)))
             {
                 p=0;
                 q=0;
             }
            else if(str[0][1].contains(words[i].substring(0,1)))
            {
                p=0;
                q=1;
            }
             else if(str[1][0].contains(words[i].substring(0,1)))
            {
                p=1;
                q=0;
            }
             else if(str[1][1].contains(words[i].substring(0,1)))
            {
                p=1;
                q=1;
            }
             else if(str[2][0].contains(words[i].substring(0,1)))
            {
                p=2;
                q=0;
            }
            else
            {
                p=2;
                q=2;
            }
            for(int j=1;j<words[i].length();j++)
            {
               if(!str[p][0].contains(words[i].substring(j,j+1)))
               {
                  if(!str[p][1].contains(words[i].substring(j,j+1)))
                  {
                   count++;
                   break;
                  }
               }
            }
            if(count==0)
            {
                l.add(words[i]);
            }
        }
        
        String s[]=new String[l.size()];
        for(int i=0;i<l.size();i++)
        {
            s[i]=l.get(i);
        }
        
        return s;
    }
}
