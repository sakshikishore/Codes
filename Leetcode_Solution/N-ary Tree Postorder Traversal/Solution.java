class Solution {
    ArrayList<Integer> l=new ArrayList<Integer>(); 
    public List<Integer> postorder(Node root) {
        if(root!=null)
        {
           for(int i=0;i<root.children.size();i++)
           {
               postorder(root.children.get(i));
           }
            l.add(root.val);
        }
        
        return l;
    }
}
