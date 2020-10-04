/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int result=0;
        int L=1,R=n;       
        while(R>=L)
        {

             int mid=L+((R-L)/2);
             int ans=guess(mid);
             if(ans==-1)
             {

                 R=mid-1;
             }
             else if(ans==1)
             {
                 L=mid+1;

             }
            else
            {
                result=mid;
                break;
            }
                     
            
        }
        
        return result;
        
    }
}
