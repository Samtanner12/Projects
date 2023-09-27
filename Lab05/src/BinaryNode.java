public class BinaryNode <K extends Comparable<?super K>> {

    public BinaryNode<K> right;
    public BinaryNode<K> left;
    private K key;                // key-only, no value


    private int size;          // the size (number of nodes)
    // of the subtree rooted at this node

    public BinaryNode(K k) {
        key = k;
        left = right = null;
        size = 1;
    }

    public void setLeft(BinaryNode<K> node) {
        left = node;
    }

    public void setRight(BinaryNode<K> node) {
        right = node;
    }

    public boolean isLeaf() {
        if (left == null && right == null)
            return true;
        else
            return false;
    }

    public BinaryNode<K> getLeft() {
        return left;
    }

    public BinaryNode<K> getRight() {
        return right;
    }

    public K getKey() {
        return key;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int newsize) {
        size = newsize;
    }

}