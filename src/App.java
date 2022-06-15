import java.util.ArrayList;
import java.util.PriorityQueue;

public class App {
    
    
    public static void main(String[] args) throws Exception 
    {
        String input = "BFGFFABACACBC";

        ArrayList<Node> nodeList = Node.getCharFreqInString(input);

        for (int i = 0; i < nodeList.size(); i++) 
        {
            Node currentNode = nodeList.get(i);
            System.out.println(currentNode.getData() + " => " + currentNode.getFreq());
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>();
        priorityQueue.add(nodeList.get(0));

        System.out.println(priorityQueue);
    }
}
