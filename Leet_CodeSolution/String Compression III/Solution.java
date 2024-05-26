class Solution {
    public String compressedString(String word) {
        int count=1;
        String comp="";
        String str[]={"1","2","3","4","5","6","7","8"};
        for(int i=1;i<word.length();i++)
        {
            if(word.charAt(i)==word.charAt(i-1))
            {
                count++;
                if(count==9)
                {
                    comp+="9"+word.charAt(i);
                    if(i==word.length()-1)
                    {
                        count=0;
                        break;
                    }
                    i++;
                    count=1;
                }
            }
            else
            { 
                comp+=str[count-1]+word.charAt(i-1);
               count=1;
            }
        }
        if(count!=0)
        {            
        comp+=str[count-1]+word.charAt(word.length()-1);
        }
        
        return comp;
    }
}
