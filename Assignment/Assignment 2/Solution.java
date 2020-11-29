
 import java.util.*;

public class Solution<Key extends Comparable<Key>, Value>  {
    private Node root;
    int size = 0;            

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
     
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
      return size;
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        Node curNode = root;
       if(key == null){
            throw new IllegalArgumentException("There is not key conatin in the root");
       }
       else{
            while(curNode.key != key){
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){
                    curNode = curNode.left;
                }
                else{
                    curNode = curNode.right;
                }
            }
            return true;
       }
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if(key == null){
            throw new IllegalArgumentException("argument to get value() is null");
        }
        Node curNode = root;
        while(curNode.key != key){
            int cmp = key.compareTo(curNode.key);
            if(cmp < 0){
                curNode = curNode.left;
            }
            else if(cmp > 0){
                curNode = curNode.right;
            }
        }
        if(curNode.key == key){
            System.out.println(curNode.val);
        }
        return curNode.val;
    }

    
    public void put(Key key, Value val) {
        // created a new Node;
        Node newNode = new Node(key,val);
        //if root is nll, newnode is created in  the root,
        if(root == null){   
            root = newNode;
        }
        else{
            Node curNode = root;
            Node parent;
            // if root is not null 
            while(curNode!=null){
                parent = curNode;
                //  compare with key that we want to insert  and the root key
                int cmp = key.compareTo(curNode.key);
                // if it less than the root key
                // moves to left sub trees.
                if(cmp < 0)
                    {
                    curNode = curNode.left;
                    if(curNode == null){
                        parent.left = newNode;
                        size++;
                        return;
                    }
                    else if(curNode.key == key)
                    {
                        curNode.val = val;
                        return;
                    }
                }
                // if key is greter the the root 
                // it moves to right subtrees.
                else if(cmp > 0)
                   {
                    curNode = curNode.right;
                    // if right sub treee is empty
                    // a new node is inserted
                    if(curNode == null)
                    {
                        parent.right = newNode;
                        size++;
                        return;
                    }
                    else if(curNode.key == key)
                    {
                        curNode.val = val;
                        return;
                    }
                }
            }
        }
        size++;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       if(isEmpty()){
        throw new NoSuchElementException("There is no element in the tree");
       }
       else{
            Node curNode = root;
            while(curNode.left != null)
            {
                curNode = curNode.left;
            }
            return curNode.key;
       }
    } 

    public Key max() 
    { 
        if(isEmpty())
        {
            throw new NoSuchElementException("There is no element in the tree");
       }
       else
       {
            Node curNode = root;
            while(curNode.right != null){
                curNode = curNode.right;
            }
            return curNode.key;
       }
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
   public Key floor(Key key)
   {
        if(isEmpty())
        {
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node curNode = root;
        Node parent = null;
        while(curNode != null){
            parent = curNode;
            int cmp = key.compareTo(parent.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(cmp == 0){
                return parent.key;
            }
            if(cmp < 0){
                curNode = parent.left;
            }
            
            else if(cmp > 0){
                curNode = parent.right;
                
                int cm = key.compareTo(curNode.key);
                if(cm < 0 ){
                    return parent.key;
                }
                
                else{
                    curNode = parent.right;
                } 
            }
        }
        return parent.key;
    }

   
    public Key select(Key key){
        if(isEmpty()){
            throw new NoSuchElementException("calls floor() with empty symbol table");
        }
        Node curNode = root;
        Node parent = null;
        while(curNode != null){
            parent = curNode;
            int cmp = key.compareTo(parent.key);
            if(key == null){
                throw new IllegalArgumentException("calls floor() with a null key");
            }
            if(cmp > 0){
                curNode = parent.right;
            }
        
            else if(cmp < 0){
                curNode = parent.left;
                
                int cm = key.compareTo(parent.key);
                if(cm > 0 ){
                    return curNode.key;
                }
        
                else{
                    curNode = parent.left;
                } 
            }
        }
        return parent.key;
    }
  
    public void keys(Key low, Key hi){
        Node curNode = root;
        Node parent;
        while(curNode != null) {
            parent = curNode;
            if (parent == null) { 
                return; 
            } 
            int x = low.compareTo(parent.key);
            int y= hi.compareTo(parent.key); 
            if (x< 0) { 
                curNode = parent.left;
            }
            if (x <= 0 && y >= 0) { 
                System.out.print(parent.key + " "); 
            } 
            if (y> 0) { 
                curNode = parent.right;
            }
        }
       
  
        /* if root's data lies in range, then prints root's data */
      
    }
    public void inOrderTraverseTree(Node node) {

        if (node!= null) {


            inOrderTraverseTree(node.left);

            System.out.println(node);

            inOrderTraverseTree(node.right);

        }

    }

   
 
  
    public static void main(String[] args) 
    { 
        Solution <String, Integer> obj = new Solution <String, Integer>();
        obj.put("ABDUL",1);
        obj.get("ABDUL");
        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        obj.get("SAI");
        obj.put("TASHI",4);
        obj.keys("ABDUL","TASHI");
        System.out.println();
        System.out.println("Size : " + obj.size());
        System.out.println("Min key : " + obj.min());
        System.out.println("Floor  : " + obj.floor("HRITHIK"));
        System.out.println("Floor  : " + obj.floor("HAHA"));
        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        obj.get("SAMAL");
        obj.put("NIMA",7);
        System.out.println("Size : " + obj.size());
        obj.put("SONAM",8);
        obj.keys("ABDUL","TASHI");
    

    }
}