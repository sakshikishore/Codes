class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int i=1;
        boolean flag=true;
        int result[]=new int[3];
        while(flag)
        {
            if(memory1>=i || memory2>=i)
            {
               if(memory1>=memory2)
               {
                   memory1=memory1-i;
               }
               else
               {
                  memory2=memory2-i; 
               }
                i++;
            }
            else
            {
                flag=false;
            }
        }
        
        result[0]=i;
        result[1]=memory1;
        result[2]=memory2;
        
        return result;
    }
}
