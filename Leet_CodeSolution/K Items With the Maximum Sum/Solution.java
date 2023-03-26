class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes>=k)
        {
            return (int)Math.min(numOnes,k);
        }
        k=k-numOnes;
        if(numZeros>=k)
        {
            return numOnes;
        }
          k=k-numZeros;
         int x=(int)Math.min(k,numNegOnes);
         return numOnes-x;
    }
}
