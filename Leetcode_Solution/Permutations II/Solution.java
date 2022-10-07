class Solution {
    List<List<Integer>> result=new ArrayList();
    HashSet<String> h=new HashSet<String>();
    public void Permutation(int arr[],int index)
    {
        if(index==arr.length)
        {
            String str="";
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int i=0;i<arr.length;i++)
            {
                str=str+" "+Integer.toString(arr[i]);
                l.add(arr[i]);
            }
            if(!h.contains(str))
            {
                result.add(l);
                h.add(str);
            }
        }
        for(int i=index;i<arr.length;i++)
        {
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
            Permutation(arr,index+1);
            temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Permutation(nums,0);
        
        return result;
    }
}
