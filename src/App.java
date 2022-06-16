import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class App {
    
    
    public static void main(String[] args) throws Exception 
    {
        String input = "BFFB";

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
        Hashtable<Character, String> bitCodesInEachChar = huffmanTree.getBitCodesInEachChar();

        for(int i = 0; i < input.length(); i++)
        {
            bitCodes += bitCodesInEachChar.get(input.charAt(i));
        }


        System.out.println(bitCodes);
        System.out.println("Compressed Bits: " + bitCodes.length() + " bits");

        String decodedData = huffmanTree.decodeData(huffmanTree.getRoot(), bitCodes);
        System.out.println("Decoded Data: " + decodedData);
    }
}
