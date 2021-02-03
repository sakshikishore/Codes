class Solution {
    public int minOperations(String[] logs) {
        int position=0;
        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].charAt(0)=='.' && logs[i].charAt(1)=='.')
            {
                if(position>0)
                {
                    position--;
                }
            }
            else if(logs[i].charAt(0)!='.')
            {
                position++;
            }
            
        }
        
        return position;
        
    }
}
