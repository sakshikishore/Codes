class Solution {
    int  max=-1;
    String result="";
    public void Permutation(String str, String res)
    {
       if(str.length()==0)
       {
           int a=Integer.parseInt(res.substring(0,2));
           int b=Integer.parseInt(res.substring(2));
           if(a<24 && b<60)
           {
            int p=a*60+b;
            if(p>max)
            {
                result=res.substring(0,2)+":"+res.substring(2);
                max=p;
            }
           }
       }
       else
       {
           for(int i=0;i<str.length();i++)
           {
               char c=str.charAt(i);
               String s=str.substring(0,i)+str.substring(i+1);
               Permutation(s,res+c);
           }
       }
    }
    public String largestTimeFromDigits(int[] arr) {
        String str="";
        for(int i=0;i<arr.length;i++)
        {
            str=str+Integer.toString(arr[i]);
        }

        Permutation(str,"");

        return result;
    }
}
