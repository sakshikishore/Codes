class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double result=0.0;
        int amount=0,i=0;
        while(i<brackets.length && amount<income)
        {
            if(brackets[i][0]<=income)
            {
                double x=brackets[i][0]-amount;
                result+=x*((brackets[i][1])/100.0);
                amount=brackets[i][0];
                i++;
                
            }
            else
            {
                double x=income-amount;
                result+=x*((brackets[i][1])/100.0);
                amount=income;
                i++;
            }
        }
        
        return result;
    }
}
