class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<students.length;i++)
        {
            q.add(students[i]);
        }
        int r=0,count=0,j=0;
        while(j<sandwiches.length)
        {
            if(sandwiches[j]==q.peek())
            {
                count=0;
                r=0;
                q.poll();
                j++;
            }
            else
            {
                if(r==0)
                {
                    r=q.size();
                }
                int p=q.peek();
                q.poll();
                q.add(p);
                count++;
                if(count==r)
                {
                    break;
                }
            }
        }
        
        return count;
        
        
    }
}
