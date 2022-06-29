class Solution {
    public int numRabbits(int[] answers) {
       HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int result=0;
        for(int i=0;i<answers.length;i++)
        {
            if(answers[i]==0)
            {
                result++;
            }
            else
            {
              if(!h.containsKey(answers[i]))
              {
                  h.put(answers[i],1);
              }
              else
              {
                  h.put(answers[i],h.get(answers[i])+1);
              }
            }
        }
        
       for(Map.Entry<Integer,Integer> entry:h.entrySet())
       {
           int key=entry.getKey();
           int value=entry.getValue();
           int x=(value)/(key+1);
           if(x==0)
           {
               result+=key+1;
           }
           else
           {
               if(x*(key+1)==value)
               {
                   result+=(key+1)*x;
               }
               else
               {
                   result+=(key+1)*(x+1);
               }
           }
       }
        return result;
    }
}
