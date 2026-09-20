public class Node {
    int x, y;

    public Node(int i, int j) {
        x = i;
        y = j;
    }
}

class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        ArrayList<Node> l = new ArrayList<Node>();
        long count=0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0) {
                l.add(new Node(intervals[i][0], intervals[i][1]));
            } else {
                int low = 0, high = l.size() - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (l.get(mid).x > intervals[i][0]) {
                        high = mid - 1;
                    } else if (l.get(mid).x < intervals[i][0]) {
                        low = mid + 1;
                    } else {
                        if (l.get(mid).y > intervals[i][1]) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                }
                l.add(low, new Node(intervals[i][0], intervals[i][1]));
            }
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(l.get(0).y);
        for(int i=1;i<l.size();i++)
        {
            int low=0,high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>=l.get(i).x)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            if(low<list.size())
            {
                count+=list.size()-low;
            }
            low=0;
            high=list.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(list.get(mid)>l.get(i).y)
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            list.add(low,l.get(i).y);
            
        }
        

        return count;
    }
}
