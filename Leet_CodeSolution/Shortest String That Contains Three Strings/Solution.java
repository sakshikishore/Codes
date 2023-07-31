class Solution {
    public String minimumString(String a, String b, String c) {
        String result=a;
        if(a.equals(b) && a.equals(c))
         {
             return result;
         }
         if(a.contains(b) && a.contains(c))
         {
             return a;
         }
         if(b.contains(a) && b.contains(c))
         {
             return b;
         }
         else if(c.contains(a) && c.contains(b))
         {
             return c;
         }
        //6 cases
        //1. ABC
        if(!a.contains(b))
        {
        int flag=0;
        if(a.length()<b.length())
        {
            for(int i=0;i<a.length();i++)
            {
                String p=a.substring(i);
                String q=b.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+b.substring(p.length());
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=b;
            }
        }
        else
        {
            for(int i=b.length();i>=0;i--)
            {
                String q=b.substring(0,i);
                String p=a.substring(a.length()-q.length());
                if(p.equals(q))
                {
                    result=result+b.substring(i);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=b;
            }
        }
        }
        if(!result.contains(c))
        {
        int flag=0;
        if(result.length()<c.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=c.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+c.substring(p.length());
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=c;
            }
        }
        else
        {
            for(int i=c.length();i>=0;i--)
            {
                String q=c.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+c.substring(i);
                    flag=1;
                    break;
                }
            }
             if(flag==0)
            {
                result+=c;
            }
            
        }
        }
        String res=result;
        //2   ACB
        int flag=0;
        result=a;
        if(!a.contains(c))
        {
         if(a.length()<c.length())
        {
            for(int i=0;i<a.length();i++)
            {
                String p=a.substring(i);
                String q=c.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+c.substring(p.length());
                    flag=1;
                    break;
                }
            }
             if(flag==0)
             {
                 result+=c;
             }
        }
        else
        {
            for(int i=c.length();i>=0;i--)
            {
                String q=c.substring(0,i);
                String p=a.substring(a.length()-q.length());
                if(p.equals(q))
                {
                    result=result+c.substring(i);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=c;
            }
        }
        }
        if(!result.contains(b))
        {
          flag=0;
        if(result.length()<b.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=b.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+b.substring(p.length());
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=b;
            }
        }
        else
        {
            for(int i=b.length();i>=0;i--)
            {
                String q=b.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+b.substring(i);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=b;
            }
        }
        }
        if(result.length()<res.length())
        {
            res=result;
        }
        else
        {
            if(result.length()==res.length())
            {
                if(res.compareTo(result)>0)
                {
                    res=result;
                }
            }
        }
        
        // BAC
        flag=0;
        result=b;
        if(!b.contains(a))
        {
        if(b.length()<a.length())
        {
            for(int i=0;i<b.length();i++)
            {
                String p=b.substring(i);
                String q=a.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+a.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=a;
            }
        }
        else
        {
            for(int i=a.length();i>=0;i--)
            {
                String q=a.substring(0,i);
                String p=b.substring(b.length()-q.length());
                if(p.equals(q))
                {
                    result=result+a.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=a;
            }
        }
        }
        if(!result.contains(c))
        {
          flag=0;
        if(result.length()<c.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=c.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+c.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=c;
            }
        }
        else
        {
            for(int i=c.length();i>=0;i--)
            {
                String q=c.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+c.substring(i);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=c;
            }
        }
        }
        if(result.length()<res.length())
        {
            res=result;
        }
        else
        {
            if(result.length()==res.length())
            {
                if(res.compareTo(result)>0)
                {
                    res=result;
                }
            }
        }
        
       // **************************************
        
        flag=0;
                //4. BCA
        result=b;
        if(!b.contains(c))
        {
        if(b.length()<c.length())
        {
            for(int i=0;i<b.length();i++)
            {
                String p=b.substring(i);
                String q=c.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+c.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=c;
            }
        }
        else
        {
            for(int i=c.length();i>=0;i--)
            {
                String q=c.substring(0,i);
                String p=b.substring(b.length()-q.length());
                if(p.equals(q))
                {
                    result=result+c.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=c;
            }
        }
        }
        if(!result.contains(a))
        {
        flag=0;
        if(result.length()<a.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=a.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+a.substring(p.length());
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=a;
            }
        }
        else
        {
            for(int i=a.length();i>=0;i--)
            {
                String q=a.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+a.substring(i);
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result+=a;
            }
        }
        }
         if(result.length()<res.length())
        {
            res=result;
        }
        else
        {
            if(result.length()==res.length())
            {
                if(res.compareTo(result)>0)
                {
                    res=result;
                }
            }
        }
        //5   CAB
        flag=0;
        result=c;
        if(!c.contains(a))
        {
         if(c.length()<a.length())
        {
            for(int i=0;i<c.length();i++)
            {
                String p=c.substring(i);
                String q=a.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+a.substring(p.length());
                    flag=1;
                    break;
                }
            }
             if(flag==0)
            {
                result+=a;
            }
        }
        else
        {
            for(int i=a.length();i>=0;i--)
            {
                String q=a.substring(0,i);
                String p=c.substring(c.length()-q.length());
                if(p.equals(q))
                {
                    result=result+a.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=a;
            }
        }
        }
        if(!result.contains(b))
        {
        flag=0;
        if(result.length()<b.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=b.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+b.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=b;
            }
        }
        else
        {
            for(int i=b.length();i>=0;i--)
            {
                String q=b.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+b.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=b;
            }
        }
        }
        if(result.length()<res.length())
        {
            res=result;
        }
        else
        {
            if(result.length()==res.length())
            {
                if(res.compareTo(result)>0)
                {
                    res=result;
                }
            }
        }
        flag=0;
        // CBA
        result=c;
        if(!c.contains(b))
        {
        if(c.length()<b.length())
        {
            for(int i=0;i<c.length();i++)
            {
                String p=c.substring(i);
                String q=b.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+b.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=b;
            }
        }
        else
        {
            for(int i=b.length();i>=0;i--)
            {
                String q=b.substring(0,i);
                String p=c.substring(c.length()-q.length());
                if(p.equals(q))
                {
                    result=result+b.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=b;
            }
        }
        }
        if(!result.contains(a))
        {
        flag=0;
        if(result.length()<a.length())
        {
            for(int i=0;i<result.length();i++)
            {
                String p=result.substring(i);
                String q=a.substring(0,p.length());
                if(p.equals(q))
                {
                    result=result+a.substring(p.length());
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=a;
            }
        }
        else
        {
            for(int i=a.length();i>=0;i--)
            {
                String q=a.substring(0,i);
                String p=result.substring(result.length()-q.length());
                if(p.equals(q))
                {
                    result=result+a.substring(i);
                    flag=1;
                    break;
                }
            }
              if(flag==0)
            {
                result+=a;
            }
        }
        }
        if(result.length()<res.length())
        {
            res=result;
        }
        else
        {
            if(result.length()==res.length())
            {
                if(res.compareTo(result)>0)
                {
                    res=result;
                }
            }
        }
     
        return res;
    }
}
