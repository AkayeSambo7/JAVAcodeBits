import java.util.*;

public class BinaryTreeTraversals {
    //Node class
    static class Node{
        int data;
        Node left;
        Node right;
        
        // constructor
        Node(int data){
            this.data = data;
        }
    }
    
    //BinaryTree class
    static class BinaryTree{
        Node root;
        
        //inorder method
        void inorder(Node n, List<Integer> out){
            if (n == null)
                return;
            inorder(n.left, out); //call on left
            out.add(n.data); //add data to the list
            inorder(n.right, out); //call on right
        }
        
        //preorder method - add data comes first
        void preorder(Node n, List<Integer> out){
            if (n == null)
                return;
            
            out.add(n.data); //add data to the list first
            inorder(n.left, out); //call on left
            inorder(n.right, out); //call on right
        }
        
        //postorder method - add data last
        void postorder(Node n, List<Integer> out){
            if (n == null)
                return;
            
            inorder(n.left, out); //call on left
            inorder(n.right, out); //call on right
            out.add(n.data); //add data to the list last
        }
        
        //levelOrder method - returns List<Integer>
        public List<Integer> levelOrder(Node n){ 
            List<Integer> out = new ArrayList<>(); //emplty list
            if (n == null)
                return out; //return empty list if null
            Queue<Node> q = new ArrayDeque<>(); //queue
            q.add(root); //add root node
            while (!q.isEmpty()) {
                Node cur = q.remove(); //remove a node from queue
                out.add(cur.data); //then add data to list
                if (cur.left != null)
                    q.add(cur.left); //if left, add to queue
                if (cur.right != null)
                    q.add(cur.right); //if right, add to queue
            }
            return out;
        }
    }
    
    public static void main(String[] args) {
        //object(s)
        BinaryTree t = new BinaryTree();
        
        //node tree construction from the root
        t.root = new Node(10); //creates root
        t.root.left = new Node(5); //creates left branch of root
        t.root.right = new Node(5); //creates right branch of root
        
        //subnode tree construction from the branches
        t.root.left.left = new Node(2); //left branch of left branch
        t.root.left.right = new Node(7); //right branch of left branch
        t.root.right.left = new Node(7); //left branch of right branch
        
        //empty lists
        List<Integer> in = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        
        //method calling
        t.inorder(t.root, in);
        t.preorder(t.root, pre);
        t.postorder(t.root, post);
        
        //printing
        System.out.print("Inorder: ");
        System.out.println(in);
        System.out.print("Preorder: ");
        System.out.println(pre);
        System.out.print("Postorder: ");
        System.out.println(post);
        System.out.print("Level order: ");
        System.out.println(t.levelOrder(t.root));
    }
    
}
