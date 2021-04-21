class Solution {
    public String convertToTitle(int columnNumber) {
        String result="";
       String ch[]={"Z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
        
        while(columnNumber>0)
        {
            int r=columnNumber%26;
            result=ch[r]+result;
            columnNumber=columnNumber/26;
            if(r==0)
            {
              columnNumber=columnNumber-1;
                
            }
            
        }
        return result;
    }
}
