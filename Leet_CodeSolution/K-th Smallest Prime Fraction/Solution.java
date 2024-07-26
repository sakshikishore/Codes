public class Node
{
    int x,y;
    public Node(int i,int j)
    {
        x=i;
        y=j;
    }
}
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        HashMap<Double,Node> h=new HashMap<Double,Node>();
        PriorityQueue<Double> pq=new PriorityQueue<Double>(Collections.reverseOrder());
        for(int i=0;i<arr.length;i++)
        {
            for(int j=arr.length-1;j>i;j--)
            {
               double x=(arr[i]*1.0)/arr[j];
               if(pq.size()<k)
               {
                  pq.add(x);
                  Node node=new Node(i,j);
                  h.put(x,node);
               }
               else if(x>pq.peek())
               {
                  break;
               }
               else
               {
                  h.remove(pq.poll());
                  pq.add(x);
                  Node node=new Node(i,j);
                  h.put(x,node);
               }
            }
        }

        Node node=h.get(pq.peek());
        int result[]=new int[2];
        result[0]=arr[node.x];
        result[1]=arr[node.y];

        return result;
    }
}
