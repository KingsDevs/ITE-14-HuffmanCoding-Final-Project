import java.util.ArrayList;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;


public class App 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input text to compress: ");
        String input = scanner.nextLine();
        scanner.close();

        System.out.println("Original Bit Size: " + input.length() * 8 + " bits");

        ArrayList<Node> nodeList = Node.getCharFreqInString(input);
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(new NodeComparator());

        int totalFreq = 0;
        for (int i = 0; i < nodeList.size(); i++) 
        {
            Node currentNode = nodeList.get(i);
            priorityQueue.add(currentNode);
            totalFreq += currentNode.getFreq();
        }
        
        HuffmanTree huffmanTree = HuffmanTree.getHuffmanTree(priorityQueue);
        
        String bitCodes = "";
        Hashtable<Character, String> bitCodesInEachChar = huffmanTree.getBitCodesInEachChar();

        for(int i = 0; i < input.length(); i++)
        {
            bitCodes += bitCodesInEachChar.get(input.charAt(i));
        }

        System.out.println("Character\tFrequency\tBit Code");
        for (int i = 0; i < nodeList.size(); i++) 
        {
            Node currentNode = nodeList.get(i);
            System.out.println(currentNode.getData() + "\t\t" + currentNode.getFreq() + "\t\t" + bitCodesInEachChar.get(currentNode.getData()));
        }

        System.out.println("Compressed Bit Size: " + (bitCodes.length() + (nodeList.size() * 8) + totalFreq) + " bits");

        System.out.println("Compressed Bits: " + bitCodes);

        System.out.println("Decoding...");
        String decodedData = huffmanTree.decodeData(huffmanTree.getRoot(), bitCodes);
        
        System.out.println("Decoded Data: " + decodedData);
    }
}
