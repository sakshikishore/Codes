import java.util.regex.*;
class Solution {
    public int countValidWords(String sentence) {
        sentence=sentence.trim();
        String arr[]=sentence.split("\\s+");
        int result=0;
        for(int i=0;i<arr.length;i++)
        {
            int count=0;
            int hyphencount=0;
         for(int j=0;j<arr[i].length();j++)
         {
             if(arr[i].charAt(j)>='0' && arr[i].charAt(j)<='9')
             {
                 count++;
                 break;
             }
             if(arr[i].charAt(j)=='-')
             {
                 if(hyphencount==0 && j>0 && arr[i].charAt(j-1)>='a' && arr[i].charAt(j-1)<='z' && j<arr[i].length()-1 && arr[i].charAt(j+1)>='a' && arr[i].charAt(j+1)<='z')
                 {
                     hyphencount=1;
                 }
                 else
                 {
                     count++;
                     break;
                 }
             }
             if((arr[i].charAt(j)=='!' || arr[i].charAt(j)=='.' || arr[i].charAt(j)==',') && j!=arr[i].length()-1)
             {
                count++;
                 break;
             }
         }
            if(count==0)
            {
                result++;
            }
        }
        
        return result;
        
    }
}
