import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class HuffmanTree 
{
    private Node root;

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

    public void printCode(Node root, String bitCode) 
    {
        if (root.getLeft() == null && root.getRight() == null && Character.isLetter(root.getData())) {
    
          System.out.println(root.getData() + "   |  " + bitCode);
          root.setBitCode(bitCode);
    
          return;
        }
        printCode(root.getLeft(),  bitCode+ "0");
        printCode(root.getRight(), bitCode + "1");
    }
}
