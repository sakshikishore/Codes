class Solution {
    public boolean checkIfExist(int[] arr) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        boolean result=false;
        Arrays.sort(arr);
        
        for(int i=arr.length-1;i>=0;i--)
        {
            int p=arr[i]/2;
            int q=p*2;
            int flag=0;
            if(arr[i]==q)
            {
                flag=1;
            }
            if(l.contains(2*arr[i])|| (flag==1 && l.contains(p)))
                {
                    result=true;
                    break;
                }
                else
                {
                l.add(arr[i]);
                }
            
        }
        
        return result;
    }
}
