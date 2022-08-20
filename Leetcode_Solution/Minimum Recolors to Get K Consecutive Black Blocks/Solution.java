class Solution {
    public int minimumRecolors(String blocks, int k) {
        int min=k+1;
        int ch[]=new int[2]; // 0 for black and 1 for white
        int flag=0;
        for(int i=0;i<blocks.length();i++)
        {
            if(i<k)
            {
                if(blocks.charAt(i)=='B')
                {
                    ch[0]++;
                }
                else
                {
                    ch[1]++;
                }
            }
            else
            {
               if(ch[1]<min)
               {
                   min=ch[1];
                   if(min==0)
                   {
                       flag=1;
                       break;
                   }
               }
               if(blocks.charAt(i-k)=='B')
               {
                   ch[0]--;
               }
               else
               {
                   ch[1]--;
               }
                if(blocks.charAt(i)=='B')
                {
                    ch[0]++;
                }
                else
                {
                    ch[1]++;
                }
                
            }
        }
        
        if(flag==0)
        {
            if(min>ch[1])
            {
                min=ch[1];
            }
        }
        
        return min;
    }
}
