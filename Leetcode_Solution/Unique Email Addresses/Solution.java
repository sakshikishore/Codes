class Solution {
    public int numUniqueEmails(String[] emails) {
        ArrayList<String> l=new ArrayList<String>();
        for(int i=0;i<emails.length;i++)
        {
          int p=emails[i].indexOf('@');
          String str=emails[i].substring(0,p);
          if(str.contains("+"))
          {
              int q=str.indexOf('+');
              String s=str.substring(0,q);
              s=s.replaceAll("\\.","");
              s=s+emails[i].substring(p);
              if(!l.contains(s))
              {
                  l.add(s);
              }
          }
          else
          {
              
              str=str.replaceAll("\\.","");
              str=str+emails[i].substring(p);
              if(!l.contains(str))
              {
                  l.add(str);
              }
          }
        
        }
        
        return l.size();
        
    }
}
