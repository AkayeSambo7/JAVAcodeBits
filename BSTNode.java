public class BSTNode {
    int key;
    BSTNode left, right;
    
    //constructor
    BSTNode(int key){
        this.key = key;
    }
    
    static class BST {
        BSTNode root;
        
        // insert method (key to insert)
        public void insert(int key) {
            root = insertRec(root, key); //sets the result of calling the recursive helper method to the root
        }
        
        //insertRec method (current node, key to insert)
        private BSTNode insertRec(BSTNode n, int k){
            if (n == null){ //if current node null,
                return new BSTNode(k); //return a new node with the key to insert.
            }
            if (k < n.key){ //if key to insert < current node's,
                n.left = insertRec(n.left, k); //insert to left subtree.
            } else if (k > n.key){ //if key to insert > current node's,
                n.right = insertRec(n.right, k); //insert to right subtree.
            }
                
            return n; //returns current node    
        }

        //search method (current node, key to search)
        public boolean search(BSTNode n, int k){
            if (n == null){ //if current node null,
                return false;
            }
            if (n.key == k){ //if current node's key == key to find,
                return true;
            }
            if (k < n.key){ //if key to find < current node's,
                return search(n.left, k); //return result of finding left child of current node,
            }else{
                return search(n.right, k); //otherwise, vice versa.
            }
        }

        //delete method (key to delete)
        public void deleteKey(int key){
            root = deleteRec(root, key); //sets the result of calling the recursive helper method to the root
        }
        
        //deleteRec method (current node, key to delete)
        private BSTNode deleteRec(BSTNode n, int k){
            if (n == null){ //if current node null,
                return null;
            }
            if (k < n.key){ //if key to delete < current node's,
                n.left = deleteRec(n.left, k); //recurse to left of subtree by updating left child of current node,
            }else if (k > n.key){
                n.right = deleteRec(n.right, k); //or recurse to right of subtree by updating right child of current node,
            }else{
                if (n.left == null){ //otherwise, if current node has no left child,
                    return n.right; 
                }else if (n.right == null){ //or vice versa,
                    return n.left;
                }else{
                    n.key = minValue(n.right); //replace smallest value key from right subtree,
                    n.right = deleteRec(n.right, n.key); //then delete vthat value from right subtree.
                }
            }
                    
            return n;
        }
        
        //find minimum value method (current node)
        private int minValue(BSTNode n){
            while (n.left != null){ //while current node left child has value,
                n = n.left; //move current node to left child.
            }

            return n.key;
        }
        
        //inorder traversal
        private void inorderPrint(){
            inorder(root); //helper method
            System.out.println(); //moves to next line 
        }
        
        private void inorder(BSTNode n){
            if (n != null){ //if current node has value,
                inorder(n.left); //call inorder on current node left child,
                System.out.print(n.key + " "); //then print current node's key,
                inorder(n.right); //then call inorder on current node right child.
            }
        }
    }
    
    //main method
    public static void main(String [] args){
        //object(s)
        BST t = new BST();

        //variables
        int[] vals = {50, 30, 70, 20, 40, 60, 80};

        //insert each element of vals into BST (using enhanced for-loop)
        for (int v : vals) {
            t.insert(v);
        }

        t.inorderPrint();

        //check if key 40 exist in BST using search method
        if (t.search(t.root, 40)){
            System.out.println("Search 40: Found");
        }else{
            System.out.println("Search 40: Not found");
        }

        //check if key 100 exist in BST using search method
        if (t.search(t.root, 100)){
            System.out.println("Search 100: Found");
        }else{
            System.out.println("Search 100: Not found");
        }

        //delete keys
        t.deleteKey(20);
        System.out.print("After deleting 20: ");
        t.inorderPrint();
        t.deleteKey(30);
        System.out.print("After deleting 30: ");
        t.inorderPrint();
        t.deleteKey(50);
        System.out.print("After deleting 50: ");
        t.inorderPrint();
    }  
}
