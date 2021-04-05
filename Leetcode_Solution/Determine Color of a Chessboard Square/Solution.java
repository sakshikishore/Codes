class Solution {
    public boolean squareIsWhite(String coordinates) {
        boolean result=true;
        int p=coordinates.charAt(0)-'a';
        p=p+Integer.parseInt(coordinates.substring(1));
        if(p%2!=0)
        {
            result=false;
        }
        
        return result;
        
    }
}
