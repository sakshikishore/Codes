class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        
        HashSet<String> positivefeedback=new HashSet<String>();
        for(int i=0;i<positive_feedback.length;i++)
        {
            positivefeedback.add(positive_feedback[i]);
        }
        
        HashSet<String> negativefeedback=new HashSet<String>();
        for(int i=0;i<negative_feedback.length;i++)
        {
            negativefeedback.add(negative_feedback[i]);
        }
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<report.length;i++)
        {
            String str[]=report[i].split(" ");
            int score=0;
            for(int j=0;j<str.length;j++)
            {
                if(positivefeedback.contains(str[j]))
                {
                    score+=3;
                }
                else if(negativefeedback.contains(str[j]))
                {
                    score-=1;
                }
            }
            
            if(!h.containsKey(score))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(student_id[i]);
                h.put(score,l);
                pq.add(score);
            }
            else
            {
                ArrayList<Integer> l=h.get(score);
                l.add(student_id[i]);
                h.put(score,l);
            }
            
        }
        ArrayList<Integer> result=new ArrayList<Integer> ();
        int i=0;
        while(pq.size()>0 && i<k)
        {
            int score=pq.poll();
            ArrayList<Integer> l=h.get(score);
            Collections.sort(l);
            for(int j=0;j<l.size();j++)
            {
                result.add(l.get(j));
                i++;
                if(i==k)
                {
                    break;
                }
            }
        }
        
        return result;
        
    }
}
