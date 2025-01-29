public class Node
{
    String str1,str2;
    Boolean dot1=false,dot2=false;
    public Node(String s1, String s2, Boolean d1, Boolean d2)
    {
        str1=s1;
        str2=s2;
        dot1=d1;
        dot2=d2;
    }
}
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        s=s.substring(1,s.length()-1);
        String str[]=s.split("");
        List<List<Node>> list=new ArrayList();
        ArrayList<Node> al=new ArrayList<Node>();
        al.add(new Node(str[0],"",false,false));
        list.add(al);
        for(int i=1;i<str.length;i++)
        {
            al=new ArrayList<Node>();
            String st=str[i];
           for(int j=i-1;j>=0;j--)
           {
             List<Node> l=list.get(j);
              for(int p=0;p<l.size();p++)
              {
                Node node=l.get(p);
                if(node.str2.length()==0)
                {
                    if(node.dot1)
                    {
                        if(st.length()==1)
                        {
                         al.add(new Node(node.str1,st,true,false));
                        }
                        else if(st.charAt(0)!='0')
                        {
                            al.add(new Node(node.str1,st,true,false));
                        }
                    }
                    else
                    {
                        if(st.length()==1)
                        {
                         al.add(new Node(node.str1,st,false,false));
                        }
                        else if(st.charAt(0)!='0')
                        {
                            al.add(new Node(node.str1,st,false,false));
                        }
                        if(Integer.parseInt(st)!=0 && st.charAt(st.length()-1)!='0')
                        {
                           al.add(new Node(node.str1+"."+st,"",true,false)); 
                        } 
                    }
                }
                else
                {
                    if(!node.dot2)
                    {
                        if(Integer.parseInt(st)!=0 && st.charAt(st.length()-1)!='0')
                        {
                        al.add(new Node(node.str1,node.str2+"."+st,true,true));
                        }
                    }
                }
               
              }
             st=str[j]+st;
           }
           if(st.charAt(0)!='0')
           {
             al.add(new Node(st,"",false,false));
           }
           list.add(al);
        }
        List<Node> alist=list.get(list.size()-1);
        ArrayList<String> result=new ArrayList<String>();
      for(int i=0;i<alist.size();i++)
      {
        Node node=alist.get(i);
        if(node.str2.length()>0)
        {
          result.add("("+node.str1+", "+node.str2+")");
        }
      }
      

      return result;
    }
}
