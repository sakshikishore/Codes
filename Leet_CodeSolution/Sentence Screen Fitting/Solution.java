class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
      int len=0;
      int r=0;
      int index=0,res=0;
      while(r<rows)
      {
        if(len+sentence[index].length()<=cols)
        {
            len=len+sentence[index].length()+1;
            index++;
            if(index==sentence.length)
            {
                index=0;
                res++;
            }
            
        }
        else
        {
            len=0;
            r++;
        }
      }

      return res;
    }
}
