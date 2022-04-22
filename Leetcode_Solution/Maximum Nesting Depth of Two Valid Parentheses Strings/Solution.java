class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int arr[]=new int [seq.length()];
        Stack<Character> stck=new Stack<Character>();
        Stack<Integer> index=new Stack<Integer>();
        int count=0;
        for(int i=0;i<seq.length();i++)
        {
           if(seq.charAt(i)=='(')
           {
               stck.push('(');
               count++;
               index.push(i);
           }
           else
           {
               if(stck.size()==1)
               {
                   stck.pop();
                   count=0;
                   arr[index.pop()]=0;
                   arr[i]=0;               
               }
               else
               {
                   if(count%2==0)
                   {
                   stck.pop();
                   arr[index.pop()]=1;
                   arr[i]=1;  
                   count--;
                   }
                   else
                   {
                       stck.pop();
                       count=count-1;;
                       arr[index.pop()]=0;
                       arr[i]=0; 
                   }
               }
           }
        }
        
        return arr;
        
    }
}
