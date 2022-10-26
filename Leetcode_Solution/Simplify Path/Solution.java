class Solution {
    public String simplifyPath(String path) {
        String str[]=path.split("/");
        Deque<String> q=new LinkedList<String>();
        for(int i=1;i<str.length;i++)
        {
            if(str[i].length()>0 && !str[i].equals(".") && !str[i].equals(".."))
            {
                q.add(str[i]);
            }
            else if(str[i].length()==0 || str[i].equals("."))
            {
                continue;
            }
            else
            {
                if(q.size()>0)
                {
                   q.removeLast();
                }
            }
        }
        
        String res="/";
        while(q.size()>0)
        {
            String s=q.poll();
            if(q.size()==0)
            {
                res=res+s;
            }
            else
            {
                res=res+s+"/";
            }
        }
        return res;
    }
}
