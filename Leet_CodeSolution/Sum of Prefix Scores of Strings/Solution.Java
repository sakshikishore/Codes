public class TreeNode
{
    TreeNode children[];
    int count=0;
    public TreeNode()
    {
       children=new TreeNode[26];
       for(int i=0;i<26;i++)
       {
        children[i]=null;
       } 
       count=0;
    }
    public TreeNode(TreeNode ch[], int cnt)
    {
        children=ch;
        count=cnt;
    }
}
class Solution {
    public void insert(String word, TreeNode root,int i)
    {
        if(i==word.length())
        {
            return;
        }
        int index=word.charAt(i)-'a';
        if(root.children[index]==null)
        {
            TreeNode ch[]=new TreeNode[26];
            for(int j=0;j<26;j++)
            {
                ch[j]=null;
            } 
           
            root.children[index]=new TreeNode(ch,1);
        }
        else
        {
             
          root.children[index].count+=1;
             
        }
         insert(word,root.children[index],i+1);
    }
    public int search(String word, TreeNode root,int i)
    {
        if(i==word.length())
        {
            return 0;
        }
         int index=word.charAt(i)-'a';
         return root.children[index].count+search(word,root.children[index],i+1);
    }
    public int[] sumPrefixScores(String[] words) {
        int result[]=new int[words.length];
        TreeNode root=new TreeNode();
        for(int i=0;i<words.length;i++)
        {
            insert(words[i],root,0);
        }
       for(int i=0;i<words.length;i++)
       {
          result[i]= search(words[i],root,0);
       }
        return result;
    }
}
