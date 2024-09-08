class Solution {
    public String convertDateToBinary(String date) {
        String str[]=date.split("-");
        String res="";
        for(int i=0;i<str.length-1;i++)
        {
            int x=Integer.parseInt(str[i]);
            res+=Integer.toBinaryString(x)+"-";
        }
        res=res+Integer.toBinaryString(Integer.parseInt(str[2]));

        return res;
    }
}
