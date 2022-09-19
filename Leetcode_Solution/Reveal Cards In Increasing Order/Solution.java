class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int result[]=new int[deck.length];
        Arrays.sort(deck);
        Deque<Integer> dq=new LinkedList<Integer>();
        for(int i=0;i<deck.length;i++)
        {
            dq.add(i);
        }
        int i=0;
        while(dq.size()>0)
        {
            int index=dq.poll();
            result[index]=deck[i];
            i++;
            if(dq.size()>0)
            {
                index=dq.poll();
                dq.addLast(index);
            }
            
        }
        
        return result;
    }
}
