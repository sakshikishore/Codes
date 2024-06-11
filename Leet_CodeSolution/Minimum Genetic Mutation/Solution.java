public class Node
{
    String str,s;
    int count;
    public Node(String str,String s, int c)
    {
      this.str=str;
      this.s=s;
      this.count=c;
    }
}
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Node> q=new LinkedList<Node>();
        q.add(new Node(startGene,"",0));
        while(q.size()>0)
        {
            Node node=q.poll();
            String str=node.str;
            if(str.equals(endGene))
            {
                return node.count;
            }
            String s=node.s;
            int arr[]=new int[bank.length];
                String st[]=s.split(" ");
                for(int i=1;i<st.length;i++)
                {
                    int x=Integer.parseInt(st[i]);
                    arr[x]++;
                }


            for(int i=0;i<bank.length;i++)
            {
                int count=0;
                if(arr[i]==0)
                {
                    for(int j=0;j<str.length();j++)
                    {
                        if(str.charAt(j)!=bank[i].charAt(j))
                        {
                          count++;
                          if(count==2)
                          {
                            break;
                          }
                        }
                    }
                    if(count==1)
                    {
                       q.add(new Node(bank[i],s+" "+i,node.count+1));
                    }
                }
            }
            


        }

        return -1;
    }
}
