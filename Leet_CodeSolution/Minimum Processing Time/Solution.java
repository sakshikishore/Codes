class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        Collections.sort(processorTime);
        ArrayList<Integer> l=new ArrayList<Integer>();
        int sum=0,j=0;
        for(int i=processorTime.size()-1;i>=0;i--)
        {
             int max=0;
             for(int k=j;k<j+4;k++)
             {
                 max=Math.max(max,processorTime.get(i)+tasks.get(k));
             }
             l.add(max);
             j=j+4;
        }

        Collections.sort(l);


        return l.get(l.size()-1);
    }
}
