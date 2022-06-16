import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class HuffmanTree 
{
    private Node root;
    private Hashtable<Character, String> bitCodeInEachChar = null;

    public HuffmanTree(Node root)
    {
        this.root = root;
    }

    public Node getRoot()
    {
        return root;
    }
    
    public static HuffmanTree getHuffmanTree(PriorityQueue<Node> priorityQueue)
    {
        Node root = null;
        while(!priorityQueue.isEmpty())
        {
            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();

            Node combinedNode = new Node(node1, node2);

            if(!priorityQueue.isEmpty())
                priorityQueue.add(combinedNode);
            else
                root = combinedNode;
        }

        return new HuffmanTree(root);
    }

    private void storeBitCodeInHash(Node root, String bitCode) 
    {
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getData())) {
    
          System.out.println(root.getData() + "   |  " + bitCode);
          bitCodeInEachChar.put(root.getData(), bitCode);
    
          return;
        }
        storeBitCodeInHash(root.getLeft(),  bitCode+ "0");
        storeBitCodeInHash(root.getRight(), bitCode + "1");
    }

    public Hashtable<Character, String> getBitCodesInEachChar()
    {
        if(bitCodeInEachChar == null)
        {
            bitCodeInEachChar = new Hashtable<Character, String>();
            storeBitCodeInHash(root, "");
        }

        return bitCodeInEachChar;
    }

    
}
