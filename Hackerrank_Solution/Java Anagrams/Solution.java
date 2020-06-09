

    static boolean isAnagram(String A, String B) {
        // Complete the function
        boolean result=false;
        if(A.length()==B.length())
        {   
            A=A.toLowerCase();
            B=B.toLowerCase();
            int flag=1;    
            int ch[]=new int[26];
            for(int i=0;i<A.length();i++)
            {
                ch[A.charAt(i)-'a']++;
                ch[B.charAt(i)-'a']--;
            }
            for(int i=0;i<26;i++)
            {
                if(ch[i]!=0)
                {
                    flag=0;
                    break;
                }
            }
            if(flag==1)
            {
                result=true;
            }
        }

        return result;
    }
