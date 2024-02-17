
import java.util.Vector;

public class Blockchain{
    private int numberOfBlocks;
    private Vector<Block> chain;

    Blockchain(){
        numberOfBlocks = 0;
        chain = new Vector<Block>();
    }
    public int size(){ return numberOfBlocks;}
    public void addBlock(Block block){
        if(chain.contains(block)){
            System.out.println("\n     [Error]   : The Block already exists!.");
        }
        else {
            chain.add(block);
            ++numberOfBlocks;
        }
    }
    public Block peek(){
        return chain.getLast();
    }
}