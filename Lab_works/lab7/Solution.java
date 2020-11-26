import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;  

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  
        private int size;
                
        public Node(Key key, Value val,int size) {
            this.key = key;
            this.val = val;
            this.size = size;
            
        }
    }
    public Solution() {
       
    }
    public boolean isEmpty(){
        return size() == 0;
    }
     // return size of tree (linear time operation)
    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right);
    }

    public boolean contains(Key key) {
        if(key==null) throw new IllegalArgumentException("argument to contain is empty");
        return get(key) != null;
    }
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null)  return null;

        while(x!= null){
            int cmp = key.compareTo(x.key);

            if (cmp < 0) 
                return get(x.left, key);

            else if (cmp > 0) 
                return get(x.right, key);

            else              
                return x.val;
        }
        return null;
        
    }
   
   public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        //assert check();
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) 
            return new Node(key, val, 1);

        int cmp = key.compareTo(x.key);

        if      (cmp < 0) 
            x.left  = put(x.left,  key, val);

        else if (cmp > 0) 
            x.right = put(x.right, key, val);

        else             
            x.val   = val;

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
        //assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        //assert check();
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) 
            return x; 
        else               
            return min(x.left); 
    } 

    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);

        if (x == null) throw new NoSuchElementException("argument to floor() is too small");
        else 
            return x.key;
    } 

    private Node floor(Node x, Key key) {
        if (x == null) 
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp == 0) 
            return x;

        if (cmp <  0) 
            return floor(x.left, key);

        Node t = floor(x.right, key); 
        if (t != null) 
            return t;

        else 
            return x; 
    } 
    public Key select(int rank) {
        if (rank < 0 || rank >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + rank);
        }
        return select(root, rank);
    }
    private Key select(Node x, int rank) {
        if (x == null) return null;
        int leftSize = size(x.left);
        if (leftSize > rank) 
            return select(x.left,  rank);

        else if (leftSize < rank) 
            return select(x.right, rank - leftSize - 1); 

        else                      
            return x.key;
    }
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        ArrayList<Key> arr = new ArrayList<Key>();
        keys(root, arr, lo, hi);
        return arr;
    } 

    private void keys(Node x, ArrayList<Key> arr, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) 
            keys(x.left, arr, lo, hi);

        if (cmplo <= 0 && cmphi >= 0) 
            arr.add(x.key);

        if (cmphi > 0) 
            keys(x.right, arr, lo, hi); 
    } 

}   

