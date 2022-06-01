class Solution {
    public long countVowels(String word) {
       long arr[]=new long[word.length()];
        long count=0;
        long sum=0;
       for(int i=word.length()-1;i>=0;i--)
       {
           if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u')
           {
               if(count==0)
               {
                   count=word.length()-i;
                   arr[i]=count;
               }
               else
               {
                   count+=word.length()-i;
                   arr[i]=count;
               }
               
           }
           else
           {
               arr[i]=count;
           }
           
           sum+=arr[i];
       }
        return sum;
    }
}
