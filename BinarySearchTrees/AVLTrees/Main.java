public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<Integer>();

        avl.add(3);
        avl.add(8);
        avl.add(38);
        avl.add(18);
        avl.add(73);
        avl.add(9);
        avl.add(2);
        avl.add(11);

        avl.printInOrder(avl.root);

    }
}