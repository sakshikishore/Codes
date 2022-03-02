class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> l=new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int min=arr[1]-arr[0];
        ArrayList<Integer> al=new ArrayList<Integer>();
        al.add(arr[0]);
        al.add(arr[1]);
        l.add(al);
        for(int i=2;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]<min)
            {
                min=arr[i]-arr[i-1];
                l=new ArrayList<List<Integer>>();
                al=new ArrayList<Integer>();
                al.add(arr[i-1]);
                al.add(arr[i]);
                l.add(al);
            }
            else if(arr[i]-arr[i-1]==min)
            {
                al=new ArrayList<Integer>();
                al.add(arr[i-1]);
                al.add(arr[i]);
                l.add(al);
            }
        }

        return l;
    }
}
