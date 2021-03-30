class Solution {
    public List<Integer> partitionLabels(String S) {
        int i=0;
        int lastIndex=-1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        int start=0;
        while(i<S.length())
        {  
            if(lastIndex<i && lastIndex!=-1)
            {
                l.add(lastIndex-start+1);
                start=lastIndex+1;
            }
           int p=S.lastIndexOf(S.charAt(i));
                   
                if(lastIndex<p)
                {
                    lastIndex=p;
                }
            
            i++;
        }
            l.add(lastIndex-start+1);
        return l;
        
    }
}
