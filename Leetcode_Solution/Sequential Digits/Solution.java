class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int arr[]={12,123,1234,12345,123456,1234567,12345678,123456789,23,234,2345,23456,234567,2345678,23456789,34,345,3456,34567,345678,3456789,45,456,4567,45678,456789,56,567,5678,56789,67,678,6789,78,789,89};
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>=low && arr[i]<=high)
            {
                l.add(arr[i]);
            }
        }
        Collections.sort(l);
        return l;
    }
}
