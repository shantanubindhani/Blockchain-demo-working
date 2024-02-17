import java.util.HashMap;
import java.util.Map;

public class Block{
    private int blockHash;
    private DataType type;
    private String data;
    private Map<String, Boolean> grants;

    // constructors
    Block(int id, String data){
        this.blockHash = id;
        this.data = data;

        // it normalizes the data, by filling filling it with empty spaces till it maximizes the capacity of a Level
        while(this.data.length()%5 !=0) this.data+=" ";
        
        //updates the level type
        updateType();
        
        this.grants = new HashMap<String, Boolean>();
        grants.put("read", false);
        grants.put("write", false);
        grants.put("read-write", false);
    }
    
    Block(int id, String data, Map<String, Boolean> grants){
        this.blockHash = id;
        this.data = data;

        // it normalizes the data, by filling filling it with empty spaces till it maximizes the capacity of a Level
        while(this.data.length()%5 !=0) this.data+=" ";
        
        //updates the level type
        updateType();
        
        this.grants = new HashMap<String, Boolean>();
        this.grants.put("read", grants.get("read"));
        this.grants.put("write", grants.get("write"));
        this.grants.put("read-write", grants.get("read-write"));
    }   

    // modifiers
    private Boolean between(int a, int x, int y){ return (a>= x && a<=y);}
    
    public void updateType(){
        int len = this.data.length();
        if(between(len, 0, 5)) type = DataType.L1;
        else if(between(len, 6, 10)) type = DataType.L2;
        else if(between(len, 11, 15)) type = DataType.L3;
        else if(between(len, 16, 20)) type = DataType.L4;
        else if(between(len, 21, 25)) type = DataType.L5;
    }
    
    public void updateGrants(String grantType, Boolean value){
        switch (grantType) {
            case "read":
            case "write":
            case "read-write":
                this.grants.put(grantType, value);
                break;
            default:
                System.out.println("\n     [Error]   : Invalid Grant type.");
                System.out.println("  Valid grants : { read, write, read-write }");
        }
    }

    // getters
    public String getData() {
        return data;
    }
    public Map<String, Boolean> getGrants() {
        return grants;
    }
    public void displayBlock(){
        System.out.println("\n================================================");
        System.out.println(" Hash : " + this.blockHash);
        System.out.println(" Data : " + this.data);
        System.out.println(" Level type : " + this.type.toString());
        System.out.println(" Grants : ");
        System.out.println("    read : "+ grants.get("read"));
        System.out.println("    write : "+ grants.get("write"));
        System.out.println("    read-write : "+ grants.get("read-write"));
        System.out.println("================================================\n");

    }
}