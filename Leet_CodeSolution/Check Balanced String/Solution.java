class Solution {
    public boolean isBalanced(String num) {
     int evenSum=0,oddSum=0;
        for(int i=0;i<num.length();i=i+2)
        {
           evenSum+=num.charAt(i)-'0';
           if(i+1<num.length())
           {
            oddSum+=num.charAt(i+1)-'0';
           }
        }

        return evenSum==oddSum?true:false;
    }
}
