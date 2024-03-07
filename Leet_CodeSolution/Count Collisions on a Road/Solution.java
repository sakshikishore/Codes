class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stck=new Stack<Character>();
        stck.push(directions.charAt(0));
        int count=0;
        for(int i=1;i<directions.length();i++)
        {
            char prev=stck.peek();
            if(directions.charAt(i)=='L' && prev=='R')
            {
                count+=2;
                stck.pop();
                while(!stck.empty() && stck.peek()=='R')
                {
                    count++;
                    stck.pop();
                }
                stck.push('S');
            }
            else if(directions.charAt(i)=='L' && prev=='S')
            {
                count+=1;
            }
            else if(directions.charAt(i)=='S' && prev=='R')
            {
                 while(!stck.empty() && stck.peek()=='R')
                {
                    count++;
                    stck.pop();
                }
                stck.push('S');
            }
            else
            {
                stck.push(directions.charAt(i));
            }
        }

        return count;
    }
}
