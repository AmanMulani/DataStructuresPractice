import java.io.*;

public class BSTMain {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearchTree bst = new BinarySearchTree();

        int ch;
        do{
            System.out.println("1. Insert Element to the tree");
            System.out.println("2. Pre-order Traversal");
            System.out.println("3. In-order Traversal");
            System.out.println("4. Post-order Traversal");
            System.out.println("5. Find Element");
            System.out.println("6. Delete Element");
            System.out.println("7. Tree Minimum Element");
            System.out.println("8. Tree Maximum Element");
            System.out.println("9. Successor Element");
            System.out.println("10. Predecessor Element");
            System.out.println("11. Quit");
            ch = Integer.parseInt(br.readLine());
            System.out.println("You have selected: " + ch);
            selectedChoice(ch, bst);
        }while(ch != 7);
        
    }

    public static void selectedChoice(int ch, BinarySearchTree bst) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        switch(ch) {
            case 1: {
                System.out.println("Please enter the number to be inserted");
                int elem = Integer.parseInt(br.readLine());
                bst.insertNode(elem);
                break;
            }
            case 2: {
                bst.preOrderTraversal(bst.root);
                break;
            }
            case 3: {
                bst.inOrderTraversal(bst.root);
                break;
            }
            case 4: {
                bst.postOrderTraversal(bst.root);
                break;
            }
            case 5: {
                System.out.println("Please enter the number to be searched");
                int elem = Integer.parseInt(br.readLine());
                bst.checkIfNodeExists(elem, bst.root);
                break;
            }
            case 6: {
                System.out.println("Please enter the number to be deleted");
                int elem = Integer.parseInt(br.readLine());
                bst.deleteNodeWithVal(elem);
                break;
            }
            case 7: {
                bst.treeMinValue(bst.root);
                
                break;
            }
            case 8: {
                bst.treeMaxValue(bst.root);
                break;
            }
            case 9: {
                bst.successorVal(bst.root);
                break;
            }
            case 10: {
                bst.predecessorVal(bst.root);
                break;
            }
            case 11: {
                System.out.println("Goodbye!!");
                break;
            }
            default: {
                System.out.println("Incorrect choice!");
                break;
            }
        }
    }

}