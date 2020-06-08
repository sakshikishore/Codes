class Solution {
    public String arrangeWords(String text) {
        
        String str[]=text.split(" ");
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<str.length;i++)
        {
            if(!l.contains(str[i].length()))
            {
                l.add(str[i].length());
            }
        }

        Collections.sort(l);
        String s="";
        for(int i=0;i<l.size();i++)
        {
            for(int j=0;j<str.length;j++)
            {
                if(str[j].length()==l.get(i))
                {
                    s=s+str[j]+" ";
                }
            }
        }
        s=s.substring(0,1).toUpperCase()+s.substring(1,s.length()-1).toLowerCase();
        
        return s;
    }
}
