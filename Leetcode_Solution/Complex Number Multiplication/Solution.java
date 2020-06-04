class Solution {
    public String complexNumberMultiply(String a, String b) {

        
        String c[]=a.split("\\+");
        String d[]=b.split("\\+");
        int sum=0;
        int isum=0;
        sum=sum+Integer.parseInt(c[0])*Integer.parseInt(d[0]);
        sum=sum+(Integer.parseInt(c[1].substring(0,c[1].length()-1))*Integer.parseInt(d[1].substring(0,d[1].length()-1)))*-1;

        isum=(Integer.parseInt(c[0])*Integer.parseInt(d[1].substring(0,d[1].length()-1)))+
            (Integer.parseInt(c[1].substring(0,c[1].length()-1))*Integer.parseInt(d[0]));
        
        return Integer.toString(sum)+"+"+Integer.toString(isum)+"i";
        

    }
}
