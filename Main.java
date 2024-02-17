import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Blockchain blockchain = new Blockchain();
        Boolean run = true;
        int hash = 0;
        while(run){
            int choice = 0;
            System.out.println("What do you want to do?");
            System.out.println(" 1. chain count");
            System.out.println(" 2. add new block");
            System.out.print(" 3. view block\n =>");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("\nTotal number of chains in the block chain : " + blockchain.size());

                    break;
                case 2:
                    String data;
                    System.out.println("\nEnter your data : ");
                    data = sc.nextLine();

                    Block block = new Block(hash, data);

                    System.out.print("\nwhat kind of grants do you want to assign? (111 for read write and read-write respectively)\n => ");
                    String grants = sc.nextLine();
                    if(grants.charAt(0) == '1') block.updateGrants("read", true);
                    if(grants.charAt(1) == '1') block.updateGrants("write", true);
                    if(grants.charAt(2) == '1') block.updateGrants("read-write", true);
                    blockchain.addBlock(block);
                    hash += 1;

                    break;
                case 3:
                    Block temp = blockchain.peek();
                    temp.displayBlock();

                    break;
                default:
                    System.out.println("\n [Error] : Invalid option.");
            }



        }
    }
    
}
