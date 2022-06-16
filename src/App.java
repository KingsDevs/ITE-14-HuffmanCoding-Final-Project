import java.util.ArrayList;
import java.util.PriorityQueue;

public class App {
    
    
    public static void main(String[] args) throws Exception 
    {
        String input = "BFGFABACACBCBC";

        System.out.println("Original Bit Size: " + input.length() * 8 + " bits");

        ArrayList<Node> nodeList = Node.getCharFreqInString(input);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new NodeComparator());

        for (int i = 0; i < nodeList.size(); i++) 
        {
            Node currentNode = nodeList.get(i);
            System.out.println(currentNode.getData() + " => " + currentNode.getFreq());
            priorityQueue.add(nodeList.get(i));
        }
        
        HuffmanTree huffmanTree = HuffmanTree.getHuffmanTree(priorityQueue);
        
        String bitCodes = "";
        huffmanTree.printCode(huffmanTree.getRoot(), "");


        System.out.println(bitCodes);
    }
}
