class Solution {
    public List<String> removeSubfolders(String[] folder) {
        ArrayList<String> l=new ArrayList<String>();
        Arrays.sort(folder);
        for(int i=0;i<folder.length;i++)
        {
            String p[]=folder[i].trim().split("/");
            String str="";
            int count=0;
            for(int j=0;j<p.length;j++)
            {
                str=str+p[j];
                if(!l.contains(str))
                {
                    count++;
                }
                else
                {
                    break;
                }
                str=str+"/";
            }
            if(count==p.length)
            {
                l.add(folder[i]);
            }
            
        }
        
        return l;
    }
}
