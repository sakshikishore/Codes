public class Node {
    Node ch[];

    public Node() {
        ch = new Node[26];
        for (int i = 0; i < 26; i++) {
            ch[i] = null;
        }
    }

    public Node(Node arr[]) {
        ch = arr;
    }

}

class Solution {
    public void createTree(String word, int i, Node root) {
        if (i == word.length()) {
            return;
        }
        int x = word.charAt(i) - 'a';
        if (root.ch[x] == null) {
            Node arr[] = new Node[26];
            Arrays.fill(arr, null);
            root.ch[x] = new Node(arr);
        }

        createTree(word, i + 1, root.ch[x]);

    }

    public int search(String target, int index, Node root) {
        if (index == target.length()) {
            return index;
        }
        int x = target.charAt(index) - 'a';
        if (root.ch[x] != null) {
            return search(target, index + 1, root.ch[x]);
        } else {
            return index;
        }
    }

    public int minValidStrings(String[] words, String target) {
        Node root = new Node();
        for (int i = 0; i < words.length; i++) {
            createTree(words[i], 0, root);
        }
        int dp[] = new int[target.length()];
        int start=0;
        for (int i = 0; i < dp.length; i++) {
            int j = search(target, i, root);
            if (j == i) {
                if (dp[j] == 0) {
                    return -1;
                }
            } else {
                for (int p = start; p < j; p++) {
                      if(i==0)
                      {
                        dp[p]=1;
                      }
                      else
                      {
                        dp[p]=dp[i-1]+1;
                      }
                    }
                    if(start<j)
                    {
                       start=j;
                    }
                }
            }

        return dp[dp.length - 1];
    }
}
