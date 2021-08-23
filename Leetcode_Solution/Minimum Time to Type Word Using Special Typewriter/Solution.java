class Solution {
    public int minTimeToType(String word) {
        int p=0;
        int score=0;
        for(int i=0;i<word.length();i++)
        {
            if(p==(word.charAt(i)-'a'))
            {
                score++;
            }
            else
            {
               
              int wordPosition=word.charAt(i)-'a';
              if(wordPosition>p)
              {
              int a=Math.abs(wordPosition-p);
              int b=(26+p)-wordPosition;
                  System.out.println(a+" "+b);
              score=score+1+Math.min(a,b);
              p=wordPosition;
              }
                else
                {
                     int a=Math.abs(wordPosition-p);
                     int b=(26-p)+wordPosition;
                     score=score+1+Math.min(a,b);
                     System.out.println(a+" "+b);
                     p=wordPosition;
                }
            }
        }
        
        return score;
    }
}
