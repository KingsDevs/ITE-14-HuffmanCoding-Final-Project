import java.util.ArrayList;

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
    }
}
