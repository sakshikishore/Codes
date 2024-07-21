class Solution {
    public String losingPlayer(int x, int y) {
        int flag=0;
        while(x>0 && y>=4)
        {
             x--;
             y=y-4;
             flag=flag^1;
        }
        if(flag==1)
        {
            return "Alice";
        }

        return "Bob";
    }
}
