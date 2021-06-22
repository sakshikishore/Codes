class Solution {
    public String largestOddNumber(String num) {
        String result="";
        int endIndex=-1;
        for(int i=0;i<num.length();i++)
        {
            if(Integer.parseInt(num.substring(i,i+1))%2!=0)
            {
                
                    endIndex=i;
            }
        }
        
        if(endIndex!=-1)
        {
            result= num.substring(0,endIndex+1);
        }
        
        return result;
    }
}
