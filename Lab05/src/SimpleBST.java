// C343 / Fall 2021
//
// a very simple, starting BST class;
// it's so simple, it's named SimpleBST.
import java.lang.Math;
public class SimpleBST <K extends Comparable<?super K>>{
    BinaryNode<K> root;
    BinaryNode<K> current;
    BinaryNode<K> right;


    // TODO for C343/Fall 2021 - Lab 05 Task B
    // "unbalanced" is used for balance checking:
    //    if a node is unbalanced, the tree will be unbalanced
    BinaryNode<K> unbalanced = null;

    public SimpleBST() {
        root = null;
        current = null;
    }
    public void build(K[] keys) {
        for (int i = 0; i < keys.length; i ++)
            insert(keys[i]);
    }
    public void insert(K k) {
        BinaryNode<K> tmpNode = new BinaryNode<K>(k);
        if (root == null) {
            root = current = tmpNode;
        } else {
            current = search(root, k);
            if (k.compareTo(current.getKey()) < 0)
                current.setLeft(tmpNode);
            else
                current.setRight(tmpNode);
        }
    }
    public BinaryNode<K> search(BinaryNode<K> entry, K k) {
        if (entry == null) {
            return null;
        } else {
            // update the size of the subtree by one:
            entry.setSize(entry.getSize() + 1);
            if (entry.isLeaf())
                return entry;
            if (k.compareTo(entry.getKey()) < 0) {
                if (entry.getLeft() != null)
                    return search(entry.getLeft(), k);
                else
                    return entry;
            } else {
                if (entry.getRight() != null)
                    return search(entry.getRight(), k);
                else
                    return entry;
            }
        }
    }
    public void display() {
        if (root == null) {
            return;
        }
        System.out.println("Pre-order enumeration: key(size-of-the-subtree)");
        traversePreOrder(root);
        System.out.println();
    }
    public void traversePreOrder(BinaryNode<K> entry) {
        System.out.print(entry.getKey() + "(" + entry.getSize() + ") ");
        if (entry.getLeft() != null) traversePreOrder(entry.getLeft());
        if (entry.getRight() != null) traversePreOrder(entry.getRight());
    }
    public boolean balanceCheck( BinaryNode<K> node){
        int lh;

        int rh;


        if (node == null)
            return true;


        lh = heightAtNode(node.left);
        rh = heightAtNode(node.right);

        if (Math.abs(lh - rh) <= 1
                && balanceCheck(node.left)
                && balanceCheck(node.right)){
            return true;
        }



        return false;
    }
    int heightAtNode( BinaryNode<K> node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(heightAtNode(node.left), heightAtNode(node.right));
    }
    // TODO for C343/Fall 2021 - Lab 05 Task B
    // implement balanceCheck(),
    //   and you may write heightAtNode(node) as helper function

    // TODO for C343/Fall 2021 - Lab 05 Task C
    // implement traverseInOrder()
    // implement traversePostOrder()


    public static void main(String[] argv) {
        SimpleBST<Integer> tree = new SimpleBST<Integer>();
        Integer[] keys = {2, 4, 6, 8, 10, 3, 5, 7, 9, 11, 12, -10, -20, 100};
        tree.build(keys);

        SimpleBST<Integer> tree2 = new SimpleBST<Integer>();
        Integer[] keys2 = {15,5,30,3,10};
        tree2.build(keys2);
        tree2.display();
        System.out.println(tree.balanceCheck(tree.root));
        System.out.println(tree.balanceCheck(tree2.root));


        // TODO for C343/Fall 2021 - Lab Task 05 Task B and C
        // see instructions

    }
}