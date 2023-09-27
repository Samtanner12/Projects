public class SimpleBinaryNode <E extends Comparable<?super E>> {
    private E value;                     // value-only, no key
    private SimpleBinaryNode<E> left;    // left child
    private SimpleBinaryNode<E> right;
    SimpleBinaryNode<E> root;
    SimpleBinaryNode<E> current;// right child
    SimpleBinaryNode<E> key;
    public SimpleBinaryNode(E e) {

        value = e;
        left = right = null;
    }

    public void setLeft(SimpleBinaryNode<E> node) {
        left = node;
    }

    public void setRight(SimpleBinaryNode<E> node) {
        right = node;
    }

    public boolean find(E q) {
        if(this.value.equals(q)) return true;
        if (left != null) {
            if(left.find(q)){
                return true;
            }

        }
        if (right != null) {
            if(right.find(q)){
                return true;
            }

        }

        return false;



    }

    public static void main(String[] argv) {

        // TODO for C343/Fall 2021 - Lab Task 05 Task A
        // see instructions

        SimpleBinaryNode<Integer> root = new SimpleBinaryNode<Integer>(7);
        SimpleBinaryNode<Integer> node1 = new SimpleBinaryNode<Integer>(29);
        SimpleBinaryNode<Integer> node2 = new SimpleBinaryNode<Integer>(36);
        SimpleBinaryNode<Integer> node3 = new SimpleBinaryNode<Integer>(12);
        SimpleBinaryNode<Integer> node4 = new SimpleBinaryNode<Integer>(306);
        SimpleBinaryNode<Integer> node5 = new SimpleBinaryNode<Integer>(435);
        SimpleBinaryNode<Integer> node6 = new SimpleBinaryNode<Integer>(34);
        SimpleBinaryNode<Integer> node7 = new SimpleBinaryNode<Integer>(76);
        SimpleBinaryNode<Integer> node8 = new SimpleBinaryNode<Integer>(35);
        SimpleBinaryNode<Integer> node9 = new SimpleBinaryNode<Integer>(39);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);
        node2.setLeft(node6);
        node3.setLeft(node7);
        node3.setRight(node8);
        node4.setRight(node9);

        // find() needs to be implemented
        System.out.println("is 36 found in the tree: " + root.find(36));
        // find(36) should return true
        System.out.println("is 103 found in the tree: " + root.find( 103));
        System.out.println("is 35 found in the tree: " + root.find( 35));
        System.out.println("is 12 found in the tree: " + root.find( 12));
        System.out.println("is 16 found in the tree: " + root.find( 16));
        // find(103) should return false

        // TODO for C343/Fall 2021 - Lab Task 05 Task A
        // see instructions

    } // end of main()

} // end of SimpleBinaryNode class