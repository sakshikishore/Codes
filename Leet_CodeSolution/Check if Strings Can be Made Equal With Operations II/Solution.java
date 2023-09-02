class Solution {
    public boolean checkStrings(String s1, String s2) {
        char c1[]=new char[s1.length()/2];
        char c2[]=new char[s2.length()/2];
        int j=0;
        for(int i=1;i<s1.length();i=i+2)
        {
            c1[j]=s1.charAt(i);
            c2[j]=s2.charAt(i);
            j++;
        }
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(Arrays.equals(c1,c2))
        {
            int n=s1.length()/2;
           if(s1.length()%2!=0)
           {
               n=n+1;
           }
               j=0;
               c1=new char[n];
               c2=new char[n];
                for(int i=0;i<s1.length();i=i+2)
                {
                    c1[j]=s1.charAt(i);
                    c2[j]=s2.charAt(i);
                    j++;
                }
                Arrays.sort(c1);
                Arrays.sort(c2);
                if(Arrays.equals(c1,c2))
                {
                    return true;
                }
           }
        
        return false;
        
    }
}
