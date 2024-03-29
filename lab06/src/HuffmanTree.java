// C343 / Fall 2021
//
// HuffmanTree - a class to implement Huffman's Algorithm

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class HuffmanTree<Key, E> {
    private MinHeap<Integer, String> heap;        // heap for building the tree
    private BinaryNodeKV<Integer, String> root;   // root node for traversal
    private Dictionary<String, String> codeTable; // huffman letter<->code table
    private Dictionary<String, Integer> codeFreq; // huffman letter<->frequency table

    public HuffmanTree(String letters, int[] weights) {
        init(letters, weights);
        buildTree();
        codeTable = new Hashtable<String, String>();

        //////////////////////////////////////buildCodeTable();
        summary();
    }

    private void init(String letters, int[] weights) {
        codeFreq = new Hashtable<String, Integer>();
        for (int i = 0; i < letters.length(); i ++)
            codeFreq.put(letters.substring(i, i + 1), weights[i]);
        int maxNum = letters.length();
        // BinaryNodeKV<Integer, String>[] nodes = (BinaryNodeKV<Integer, String>[]) new Object[maxNum];
        @SuppressWarnings("unchecked")
        BinaryNodeKV<Integer, String>[] nodes = new BinaryNodeKV[maxNum];
        for (int i = 0; i < maxNum; i ++) {
            nodes[i] = new BinaryNodeKV<Integer, String>(weights[i], letters.substring(i, i + 1));
        }
        heap = new MinHeap<Integer, String>(maxNum, maxNum, nodes);
        heap.display();
    }

    private void buildTree() {
        while (heap.length() > 1) {
            BinaryNodeKV<Integer, String> node1 = heap.removeMin();
            BinaryNodeKV<Integer, String> node2 = heap.removeMin();
            buildCodeTable(node1,node2);
            BinaryNodeKV<Integer, String> newnode = new BinaryNodeKV<Integer, String>(node1.getKey() + node2.getKey(), " ");
            newnode.setLeft(node1);
            newnode.setRight(node2);
            heap.insert(newnode);
            heap.display();
        }
        root = heap.removeMin();
        System.out.println("Huffman tree built. Root weight = " + root.getKey());
    }

    public void summary() {
        if (codeTable.isEmpty()) {
            System.out.println("Summary can't be provided. The Huffman Code Table is empty!");
            return;
        }
        // display the code & compute the sum of weighted path lengths
        Enumeration<String> keys = codeFreq.keys();
        int sumOfWeightedPath = 0;
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Letter: " + key + " " + codeTable.get(key));
            sumOfWeightedPath += codeTable.get(key).length() * codeFreq.get(key);
        }
        System.out.println("Total letters: " + root.getKey());
        System.out.println("Sum of weighted path lengths: " + sumOfWeightedPath);
        System.out.println("Average code length: " + sumOfWeightedPath * 1.0 / root.getKey());
    }

    // Functionality 1: get the Huffman code by traversing the tree.
    //
    // Each leaf node is a letter, and the corresponding path is the code.
    // For simplicity, represent Huffman codes by using strings of "0" and "1", not bits.
    private void buildCodeTable(BinaryNodeKV<Integer, String>node1, BinaryNodeKV<Integer, String> node2) {
        System.out.println("my code table will nto accept any key value pairs for some reason I am supposed to "+
                "use the put fucntion taking two strings btu it wont accept it, i am pringting key value pairs just fine");
        if( node2.getKey()!= null && node2.getValue()!= null){
            System.out.println("node 2 get key" +node2.getKey().toString()+" "+ node2.getValue().toString());
            //codeTable.put(node2.getValue(),node2.getKey().toString());
            //codeTable.put("K","7");
            //but this is not working it throws a null error

        }
        if(node1.getValue().toString()!= " "){
            System.out.println("node 1 get key" +node1.getKey().toString()+" "+ node1.getValue().toString());
            //codeTable.put(node1.getValue(),node1.getKey().toString());
        }
        //codeTable.put();


        // hint: if you need to use recursion, it will be easier to:
        //
        //       first, write a separate (recursive) private helper method,
        //          which can call itself because recursive.
        // 
        //       then, invoke that recursive method from here.
    }

    // Functionality 2: encode a message
    //
    public String encode(String inStr) {
        if (codeTable.isEmpty()) { System.out.println("Encoding not possible. Huffman Code Table empty!"); return ""; }
        String outCode = "";

        for (int i = 0; i < inStr.length(); i ++) {
            String letter = inStr.substring(i, i+1);
            // here we use the codeTable built by buildCodeTable()
            outCode += codeTable.get(letter);
        }
        return outCode;
    }

    // Functionality 3: decode a message
    //
    public String decode(String inCode) {
        String outStr = "";
        BinaryNodeKV<Integer, String> currentNode = root;

        if (currentNode.isLeaf()) { System.out.println("Decoding not possible. Huffman Tree empty!"); return ""; }
        // System.out.println("about to decode the Huffman code: " + inCode);
        // System.out.println("using the tree: " + root.inorder());

        // Lab 06 TODO: implement this method!
        //
        // hint: you'll need to use the Huffman tree
        //       stored in the currentNode local variable

        return outStr;
    }

    public static void main(String[] argv) {
        int[] weights = {2, 7, 24, 32, 37, 42, 42, 120};
        String letters = "ZKMCDLUE";
        HuffmanTree<Integer, String> tree = new HuffmanTree<Integer, String>(letters, weights);
        System.out.println("DEED" + " encoded as " + tree.encode("DEED"));
        System.out.println("0110111111011001110111101" + " decodes into " + tree.decode("0110111111011001110111101"));
    }

} // public class HuffmanTree