class Solution {
    public List<Integer> circularPermutation(int n, int start) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        int arr[]=new int[(int)Math.pow(2,n)];
        int index=0;
        for(int i=0;i<(int)Math.pow(2,n);i++)
        {
             String str=Integer.toBinaryString(i);
             while(str.length()!=n)
             {
                 str="0"+str;
             } 
             String p=str.substring(0,1);
             for(int j=1;j<str.length();j++)
             {
                 if((str.charAt(j)=='1' && str.charAt(j-1)=='1') ||(str.charAt(j)=='0' && str.charAt(j-1)=='0'))
                 {
                     p=p+"0";
                 }
                 else
                 {
                     p=p+"1";
                 }
             }
             arr[i]=Integer.parseInt(p,2);
             if(arr[i]==start)
             {
                 index=i;
             }
        }
        for(int i=index;i<arr.length;i++)
        {
            list.add(arr[i]);
        }
        for(int i=0;i<index;i++)
        {
            list.add(arr[i]);
        }

        return list;
    }
}
