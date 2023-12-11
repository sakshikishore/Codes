import java.math.BigInteger;
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<variables.length;i++)
        {
            BigInteger a=BigInteger.valueOf(variables[i][0]);
            BigInteger b1=a.modPow(BigInteger.valueOf(variables[i][1]),BigInteger.valueOf(10));
            BigInteger value=b1.modPow(BigInteger.valueOf(variables[i][2]),BigInteger.valueOf(variables[i][3]));
            int val=value.intValue();
            if(val==target)
            {
                list.add(i);
            }
        }
        
        return list;
    }
}
