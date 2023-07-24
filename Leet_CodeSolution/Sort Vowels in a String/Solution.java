class Solution {
    public String sortVowels(String s) {
        char c[]=s.toCharArray();
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='a' || c[i]=='e' || c[i]=='i' || c[i]=='o' || c[i]=='u')
            {
                int p=97+ (c[i]-'a');
                l.add(p);
            }
            else if(c[i]=='A' || c[i]=='E' || c[i]=='I' || c[i]=='O' || c[i]=='U')
            {
                int p=65+(c[i]-'A');
                l.add(p);
            }
        }
        Collections.sort(l);
        int j=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='a' || c[i]=='e' || c[i]=='i' || c[i]=='o' || c[i]=='u')
            {
                int x=l.get(j);
               c[i]=(char)(x);
                j++;
                
            }
            else if(c[i]=='A' || c[i]=='E' || c[i]=='I' || c[i]=='O' || c[i]=='U')
            {
                 int x=l.get(j);
                c[i]=(char)(x);
                j++;
            }
        }
        
        return new String(c);
        
        
    }
}
