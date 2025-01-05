class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length()==0)
        {
            return "";
        }
       int n=encodedText.length()/rows;
       char arr[][]=new char[rows][n];
       int t=0;
       for(int i=0;i<arr.length;i++)
       {
        for(int j=0;j<arr[0].length;j++)
        {
            arr[i][j]=encodedText.charAt(t);
            t++;
        }
       }

       StringBuffer sb=new StringBuffer("");
       int flag=0;
       for(int i=0;i<arr[0].length;i++)
       {
          int a=i,b=0;
          while(b<arr.length && a<arr[0].length)
          {
            sb.append(arr[b][a]);
            a++;
            b++;
          }
       }
       String res=sb.toString();
       int x=res.length()-1;
       while(res.charAt(x)>'z' || res.charAt(x)<'a')
       {
          x--;
       }
       return res.substring(0,x+1); 
    }
}
