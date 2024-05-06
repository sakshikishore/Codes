class Solution {
    public boolean isValid(String word) {
        HashSet<Character> hset=new HashSet<Character>();
        hset.add('a');
        hset.add('e');
        hset.add('i');
        hset.add('o');
        hset.add('u');
        hset.add('A');
        hset.add('E');
        hset.add('I');
        hset.add('O');
        hset.add('U');
        if(word.length()<3)
        {
            return false;
        }
        int v=0,c=0,d=0;
        for(int i=0;i<word.length();i++)
        {
            if(hset.contains(word.charAt(i)))
            {
               
                v++;
                if(word.charAt(i)>='a' && word.charAt(i)<='z')
                {
                    d++;
                }
                else
                {
                    d++;
                }

            }
            else if(word.charAt(i)>='a' && word.charAt(i)<='z')
            {
                d++;
                c++;
            }
             else if(word.charAt(i)>='A' && word.charAt(i)<='Z')
            {
                c++;
                d++;
            }
            else if(word.charAt(i)>='0' && word.charAt(i)<='9')
            {
                d++;
            }
            else
            {
                return false;
            }
        }

        if(v>0 && c>0 && d>0)
        {
            return true;
        }

        return false;
    }
}
