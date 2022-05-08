class Solution {
    public String largestGoodInteger(String num) {
        String result="";
        int max=-1;
        for(int i=1;i<num.length()-1;i++)
        {
            if((num.charAt(i-1)== num.charAt(i)) && (num.charAt(i)==num.charAt(i+1)))
            {
                if(Integer.parseInt(num.substring(i,i+1))>max)
                {
                    max=Integer.parseInt(num.substring(i,i+1));
                    result=num.substring(i-1,i+2);
                }
            }
        }
        
        return result;
        
    }
}
