/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][]=new int[m][n];
        int x=0,y=0;
        int count=0;
        ListNode ptr=head;
        if(m%2==0)
        {
           x=m/2;
        }
        else
        {
            x=(m/2)+1;
        }
        for(int i=0;i<x;i++)
        {
            int flag=0;
            if(i!=x-1)
            {
                for(int j=i;j<n-i;j++)
                {
                    if(ptr!=null)
                    {
                        arr[i][j]=ptr.val;
                        ptr=ptr.next;
                        count++;
                    }
                    else
                    {
                        arr[i][j]=-1;
                        count++;
                    }
                }
                       if(count==m*n)
                        {
                            break;
                        }
                for(int j=i+1;j<m-i-1;j++)
                {
                    if(ptr!=null)
                    {
                        arr[j][n-i-1]=ptr.val;
                        count++;
                        ptr=ptr.next;
                    }
                    else
                    {
                        arr[j][n-i-1]=-1;
                        count++;
                    }
                }
                if(count==m*n)
                        {
                            break;
                        }
                for(int j=n-i-1;j>=i;j--)
                {
                    if(ptr!=null)
                    {
                        arr[m-i-1][j]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                       arr[m-i-1][j]=-1;
                    }
                        count++;
                }
                if(count==m*n)
                        {
                            break;
                        }
                for(int j=m-i-2;j>i;j--)
                {
                    if(ptr!=null)
                    {
                        arr[j][i]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                       arr[j][i]=-1;
                    }
                    count++;
                }
            if(count==m*n)
                        {
                            break;
                        }
            }
            else if(m%2==0)
            {
                for(int j=i;j<n-i;j++)
                {
                    if(ptr!=null)
                    {
                        arr[i][j]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                        arr[i][j]=-1;
                    }
                    count++;
                }
                if(count==m*n)
                        {
                            break;
                        }
                for(int j=i+1;j<m-i-1;j++)
                {
                    if(ptr!=null)
                    {
                        arr[j][n-i-1]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                        arr[j][n-i-1]=-1;
                    }
                    count++;
                }
                if(count==m*n)
                        {
                            break;
                        }
                for(int j=n-i-1;j>=i;j--)
                {
                    if(ptr!=null)
                    {
                        arr[m-i-1][j]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                       arr[m-i-1][j]=-1;
                    }
                    count++;
                }
                if(count==m*n)
                        {
                            break;
                        }
                for(int j=m-i-2;j>i;j--)
                {
                    if(ptr!=null)
                    {
                        arr[j][i]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                       arr[j][i]=-1;
                    }
                    count++;
                }
            }
            else
            {
                if(count==m*n)
                        {
                            flag=1;
                            break;
                        }
                for(int j=i;j<n-i;j++)
                {
                    if(ptr!=null)
                    {
                        arr[i][j]=ptr.val;
                        ptr=ptr.next;
                    }
                    else
                    {
                        arr[i][j]=-1;
                    }
                    count++;
                }
            }
            
                        if(count==m*n)
                        {
                            break;
                        }
            
        }
        
        return arr;
    }
}
