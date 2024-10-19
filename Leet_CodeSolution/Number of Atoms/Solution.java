class Node
{
    String str;
    int freq;
    public Node(String s, int f)
    {
        str=s;
        freq=f;
    }
}
class Solution {
    public String countOfAtoms(String formula) {
        TreeMap<String,Integer> map=new TreeMap<String,Integer>();
        Stack<Node> stck=new Stack<Node>();
       int i=0;
       while(i<formula.length())
       {
          if(formula.charAt(i)>='A' && formula.charAt(i)<='Z')
          {
            String p="";
            p=p+formula.charAt(i);
            i++;
            while(i<formula.length() && formula.charAt(i)>='a' && formula.charAt(i)<='z')
            {
                p=p+formula.charAt(i);
                i++;
            }
            int c=0;
             while(i<formula.length() && formula.charAt(i)>='0' && formula.charAt(i)<='9')
            {
                c=c*10+formula.charAt(i)-'0';
                i++;
            }
            if(c==0)
            {
                c=1;
            }
            stck.push(new Node(p,c));

          }
          else if(formula.charAt(i)=='(')
          {
            stck.push(new Node("-1",-1));
            i++;
          }
          else
          {
            i++;
             int c=0;
             Stack<Node> stck2=new Stack<Node>();
             while(i<formula.length() && formula.charAt(i)>='0' && formula.charAt(i)<='9')
            {
                c=c*10+formula.charAt(i)-'0';
                i++;
            }
            if(c==0)
            {
                c=1;
            }
            while(stck.size()>0)
            {
                Node p=stck.pop();
                if(p.str.equals("-1"))
                {
                   break;
                }
                else
                {
                    p.freq=p.freq*c;
                    stck2.push(p);
                }
            }

            while(stck2.size()>0)
            {
                stck.push(stck2.pop());
            }
          }
       }

       while(stck.size()>0)
       {
         Node node=stck.pop();
         if(!map.containsKey(node.str))
         {
            map.put(node.str,node.freq);
         }
         else
         {
            map.put(node.str,map.get(node.str)+node.freq);
         }
       }
       StringBuilder result=new StringBuilder("");
       for(Map.Entry<String,Integer> entry:map.entrySet())
       {
          result.append(entry.getKey());
          if(entry.getValue()!=1)
          {
            result.append(Integer.toString(entry.getValue()));
          }

       }
       return result.toString();
    }
}
