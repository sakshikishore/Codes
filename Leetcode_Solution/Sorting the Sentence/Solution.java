class Solution {
    public String sortSentence(String s) {
        String str[]=s.split(" ");
        String result="";
        for(int i=0;i<str.length;i++)
        {
            for(int j=i+1;j<str.length;j++)
            {
                if(str[i].charAt(str[i].length()-1)>str[j].charAt(str[j].length()-1))
                {
                    String temp=str[i];
                    str[i]=str[j];
                    str[j]=temp;
                }
                
            }
            
        }
        for(int i=0;i<str.length;i++)
        {
            if(i==str.length-1)
            {
                result=result+str[i].substring(0,str[i].length()-1);
            }
            else
            {
              result=result+str[i].substring(0,str[i].length()-1)+" ";
            }
            
        }
        
        return result;
        
    }
}
