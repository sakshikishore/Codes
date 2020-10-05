class Solution {
    public int bitwiseComplement(int N) {
        String p=Integer.toBinaryString(N);
        p=p.replace('1','a');
        p=p.replace('0','1');
        p=p.replace('a','0');
        return Integer.parseInt(p,2);
        
    }
}
