class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result="";
        int min=Integer.MAX_VALUE;
        licensePlate=licensePlate.toLowerCase();
        ArrayList<Character> l=new ArrayList<Character>();
        for(int i=0;i<licensePlate.length();i++)
        {
            if(licensePlate.charAt(i)>='a' && licensePlate.charAt(i)<='z')
            {
                l.add(licensePlate.charAt(i));
            }
        }
       for(int i=0;i<words.length;i++)
       {
          ArrayList<Character> p=new ArrayList<Character>();
           for(int k=0;k<l.size();k++)
           {
               p.add(l.get(k));
           }
           for(int j=0;j<words[i].length();j++)
           {
               if(p.contains(words[i].charAt(j)))
               {
                 int r=  p.indexOf(words[i].charAt(j));
                   p.remove(r);
               }
                   
               if(p.size()==0)
               {
                   if(words[i].length()<min)
                   {
                       min=words[i].length();
                       result=words[i];
                   }
                   break;
               }
           }
       }
        
        return result;
    }
}
