public class ListNode
{
    public int val;
    public ListNode next;
    public ListNode(int data, ListNode next)
    {
        val=data;
        next=next;
    }
}
class FrontMiddleBackQueue {
 ListNode root;
    public FrontMiddleBackQueue() {
        root=null;
    }
    
    public void pushFront(int val) {
        if(root==null)
        {
            root=new ListNode(val,null);
        }
        else
        {
            ListNode p=new ListNode(val,null);
            p.next=root;
            root=p;
        }
        
    }
    
    public void pushMiddle(int val) {
        if(root!=null)
        {
        int len=0;
        ListNode ptr=root;
        while(ptr!=null)
        {
    
            ptr=ptr.next;
           
            len++;
        }
        ListNode p=new ListNode(val,null);
        int r=len/2;
            if(r!=0)
            {
        ListNode q=root;
        int i=1;
        while(i<r)
        {
            q=q.next;
            i++;
        }
        p.next=q.next;
        q.next=p;
        }
            else
            {
                p.next=root;
                root=p;
            }
        }
        else
        {
            root=new ListNode(val,null);
        }
        
    }
    
    public void pushBack(int val) {
        if(root!=null)
        {
        ListNode ptr=root;
        ListNode p=new ListNode(val,null);
        while(ptr.next!=null)
        {
            ptr=ptr.next;
        }
        ptr.next=p;
        }
        else
        {
            root=new ListNode(val,null);
        }
        
    }
    
    public int popFront() {
        int result=-1;
        if(root!=null)
        {
            result=root.val;
            root=root.next;
        }
        return result;
        
    }
    
    public int popMiddle() {
        int result=-1;
        if(root!=null)
        {
            int len=0;
            ListNode ptr=root;
            System.out.println();
            while(ptr!=null)
            {
                ptr=ptr.next;
                len++;
            }
            int r=len/2;
            if(r!=0)
            {
            ListNode j=root;
            ListNode q=j;
            if(len%2!=0)
            {
            int i=0;
            while(i<r)
            {
                j=q;
                q=q.next;
                i++;
            }
            result=q.val;
            j.next=q.next;
            q.next=null;
            }
            else
            {
                if(r==1)
                {
                    result=root.val;
                    root=root.next;
                    
                }
                else
                {
                    int i=1;
                    while(i<r)
                    {
                        j=q;
                        q=q.next;
                        i++;
                    }
                    j.next=q.next;
                    result=q.val;
                    q.next=null;
                }
            }
            }
            else
            {
                result=root.val;
                root=root.next;
                
            }
        }
        return result;
    }
    
    public int popBack() {
       
        int result=-1;
        if(root!=null)
        {
            ListNode ptr=root;
            ListNode q=null;
            while(ptr.next!=null)
            {
                q=ptr;
                ptr=ptr.next;
            }
            result=ptr.val;
            if(q!=null)
            {
                q.next=null;
            }
            else
            {
                root=null;
            }
        }
        
        return result;
        
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
