class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
       HashSet<Integer> hset=new HashSet<Integer>();
       int ch[]=new int[26];
       for(int i=0;i<word.length();i++)
       {
          if(word.charAt(i)>='a' && word.charAt(i)<='z')
          {
            ch[word.charAt(i)-'a']++;
            hset.add(word.charAt(i)-'a');
          }
       }
       int c1[]=new int[26];
       for(int i=0;i<word.length();i++)
       {
          if(word.charAt(i)>='a' && word.charAt(i)<='z')
          {
            ch[word.charAt(i)-'a']--;
          }
          else
          {
            if(ch[word.charAt(i)-'A']==0 && hset.contains(word.charAt(i)-'A') && c1[word.charAt(i)-'A']==0 )
            {
                count++;
                c1[word.charAt(i)-'A']=1;
            }
            else if(ch[word.charAt(i)-'A']!=0)
            {
                c1[word.charAt(i)-'A']=-1;
            }
          }
       }

       return count;
        
    }
}
