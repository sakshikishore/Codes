class Solution {
    public int possibleStringCount(String word) {
        int count=0;
        int c=0;
       for(int i=1;i<word.length();i++)
       {
         if(word.charAt(i)==word.charAt(i-1))
         {
           c++;
         }
         else
         {
            count+=c;
            c=0;
         }
       }
        count+=c;

      return count+1; 
    }
}
