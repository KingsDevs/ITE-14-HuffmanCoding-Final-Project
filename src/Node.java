import java.util.ArrayList;

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

    public Character getData()
    {
        return data;
    }

    public void increment_freq()
    {
        freq++;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }

    public static ArrayList<Node> getCharFreqInString(String str)
    {
        char c;
        if(Character.isWhitespace(str.charAt(0)))
            c = ' ';
        else
            c = str.charAt(0);
        
        ArrayList<Node> nodelist = new ArrayList<Node>();
        nodelist.add(new Node(c));

        for(int i = 1; i < str.length(); i++)
        {
            if(Character.isWhitespace(str.charAt(0)))
                c = ' ';
            else
                c = str.charAt(i);

            Boolean newCharacter = true;
            for(int j = 0; j < nodelist.size(); j++)
            {
                Node currentNode = nodelist.get(j);
                if(currentNode.getData() == c)
                {
                    newCharacter = false;
                    currentNode.increment_freq();
                }
            }

            if(newCharacter)
                nodelist.add(new Node(c));
        }

        return nodelist;
    }

}
