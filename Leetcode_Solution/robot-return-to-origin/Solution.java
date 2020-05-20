class Solution {
    public boolean judgeCircle(String moves) {
        boolean result=true;
        int arr[]=new int[2];
        for(int i=0;i<moves.length();i++)
        {
            if(moves.charAt(i)=='L')
            {
                arr[0]--;
            }
           else if(moves.charAt(i)=='R')
            {
                arr[0]++;
            }
           else if(moves.charAt(i)=='U')
            {
                arr[1]++;
            }
            else
            {
                arr[1]--;
            }
        }
        for(int i=0;i<2;i++)
        {
            if(arr[i]!=0)          
            {
                result=false;
                break;
            }
        }
        return result;
    }
}
