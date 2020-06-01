class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> l=new ArrayList<String>();
         ArrayList<String> k = new ArrayList<String>();
        ArrayList<String> m=new ArrayList<String>();       
        for(int i=0;i<logs.length;i++)
        {
            String p[]=logs[i].split(" ");
            if(p[1].charAt(0)>='a' && p[1].charAt(0)<='z')
            {
                l.add(logs[i]);
                k.add(logs[i].substring(p[0].length()));
            }
            else
            {
                m.add(logs[i]);
            }
        }
     
      
        Collections.sort(k);
        Collections.sort(l);
        ArrayList<String> x=new ArrayList<String>();
        int r=0;
        for(int i=0;i<k.size();i++)
        {
             for(int j=0;j<l.size();j++)
             {
                 if(l.get(j).contains(k.get(i)) && !x.contains(l.get(j)))
                 {
                       logs[r]=l.get(j);
                        x.add(l.get(j));
                        r++;
                        break;
                }
            }
        }
                     
        for(int i=0;i<m.size();i++)
        {
            logs[r]=m.get(i);
            r++;
        }
                      
                      
    
        return logs;
    }
}
