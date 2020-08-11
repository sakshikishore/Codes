class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result=numBottles;
        while(numBottles>=numExchange)
        {
            int r=numBottles%numExchange;
            numBottles=numBottles/numExchange;
            result=result+numBottles;
            numBottles=numBottles+r;
        }
        
        return result;
    }
}
