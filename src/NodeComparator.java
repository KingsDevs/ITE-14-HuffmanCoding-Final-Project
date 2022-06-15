import java.util.Comparator;

public class NodeComparator implements Comparator<Node>
{

    @Override
    public int compare(Node node1, Node node2) 
    {
        int result = 0;
        if(node1.getFreq() > node2.getFreq())
            result = 1;

        return result;
    }

    
}
