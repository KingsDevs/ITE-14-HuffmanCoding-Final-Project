
public class Node 
{
    private Character data;
    private int freq;

    private Node left;
    private Node right;

    public Node(Character data)
    {
        this.data = data;
        freq = 1;

        left = null;
        right = null;
    }

    public Node(Node left, Node right)
    {
        this.left = left;
        this.right = right;

        freq = left.getFreq() + right.getFreq();
        data = null;
    }


    public Integer getFreq()
    {
        return freq;
    }

}
