class Solution {
    public boolean isPalindrome(ListNode head) {
        boolean result=true;
       ListNode ptr=head;
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(ptr!=null)
        {
            l.add(ptr.val);
            ptr=ptr.next;
        }
        int n=l.size()-1;
        for(int i=0;i<l.size()/2;i++)
        {
            if(l.get(i)!=l.get(n-i))
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
