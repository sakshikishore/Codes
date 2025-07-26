/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        NestedInteger result = new NestedInteger();
        int i = 0;
        Stack<NestedInteger> stck = new Stack<NestedInteger>();
        while (i < s.length()) {
            if (s.charAt(i) == '[') {
                stck.push(new NestedInteger(10000001));
                i++;
            } else if (s.charAt(i) == ',') {
                i++;
                int neg = 0;
                if (s.charAt(i) == '[') {
                    stck.push(new NestedInteger(10000001));
                    i++;
                }
                if (s.charAt(i) == '-') {
                    neg = 1;
                }
                int val = 0;
                int flag = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    int t = s.charAt(i) - '0';
                    flag = 1;
                    val = val * 10 + t;
                    i++;
                }
                if (neg == 1) {
                    val = val * -1;
                }
                if (flag == 1) {
                    stck.push(new NestedInteger(val));
                } 
            } else if (s.charAt(i) == '-') {
                i++;
                int val = 0;
                int flag=0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    int t = s.charAt(i) - '0';
                    val = val * 10 + t;
                    i++;
                    flag=1;
                }
                val = val * -1;
                if(flag==1)
                {
                stck.push(new NestedInteger(val));
                }
               
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int val = 0;
                int flag=0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    int t = s.charAt(i) - '0';
                    val = val * 10 + t;
                    i++;
                    flag=1;
                }
               if(flag==1)
                {
                stck.push(new NestedInteger(val));
                }
            } else {
                Stack<NestedInteger> st = new Stack<NestedInteger>();
                NestedInteger p = new NestedInteger();
                i++;
                while (true) {
                    if (stck.peek().isInteger()) {
                        if (stck.peek().getInteger() == 10000001) {
                            break;
                        }
                    }
                    NestedInteger ni = stck.pop();
                    st.add(ni);
                }

                stck.pop();
                while (st.size() > 0) {
                    p.add(st.pop());
                }
                stck.push(p);
            }
        }
        return stck.peek();
    }
}
