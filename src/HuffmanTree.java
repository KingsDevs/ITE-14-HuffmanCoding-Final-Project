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
}
