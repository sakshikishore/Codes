class Solution {
    public String entityParser(String text) {
        String str[]=text.split("&");
        String res="";
        int count=0;
        for(int i=text.length()-1;i>=0;i--)
        {
            if(text.charAt(i)=='&')
            {
                count++;
            }
            else
            {
                break;
            }
        }
        if(str.length>0)
        {
          res=str[0];
          for(int i=1;i<str.length;i++)
          {
              if(str[i].length()>0)
              {
              if(str[i].contains(";"))
              {
                  String p[]=str[i].split(";");
                  if(p.length>0)
                  {
                  String t="";
                  for(int j=1;j<p.length;j++)
                  {
                      if(j==p.length-1)
                      {
                          t=t+p[j];
                      }
                      else
                      {
                       t=t+p[j]+";";
                      }
                  }
                  if(p.length>1 && str[i].charAt(str[i].length()-1)==';')
                  {
                      t=t+";";
                  }
                  if(p[0].equals("quot"))
                  {
                      p[0]="\"";
                       res=res+p[0]+t;
                  }
                  else if(p[0].equals("apos"))
                  {
                      p[0]="'";
                      res=res+p[0]+t;
                  }
                  else if(p[0].equals("amp"))
                  {
                      p[0]="&";
                       res=res+p[0]+t;
                  }
                  else if(p[0].equals("gt"))
                  {
                      p[0]=">";
                      res=res+p[0]+t;
                  }
                  else if(p[0].equals("lt"))
                  {
                      p[0]="<";
                       res=res+p[0]+t;
                  }
                  else if(p[0].equals("frasl"))
                  {
                      p[0]="/";
                      res=res+p[0]+t;
                  }
                  else
                  {
                     res+="&"+str[i];
                  }
                  }
                  else
                  {
                      res+="&;";
                  }
              }
              else
              {
                  res+="&"+str[i];
              }
              }
              else
              {
                  res+="&";
              }
          }
        }
        else   
        {
            res=text;
        }
        if(str.length!=0)
        {
            for(int i=0;i<count;i++)
            {
                res+="&";
            }
        }
        return res;
    }
}
