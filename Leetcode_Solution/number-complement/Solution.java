class Solution {
    public int findComplement(int num) {
        
        String str=Integer.toBinaryString(num);
        long p=(long)Math.pow(2,str.length());
        p=p-1;
        
        return (int)p^num;
        
    }
}
