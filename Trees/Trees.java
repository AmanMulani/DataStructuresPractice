 class TreeDataStucture {

    public int size;
    public Node<E> root;

    public TreeDataStucture() {
        this.size = 0;
        this.root = null;
    }


    class Node<E> {
        E data;
        Node<E> right, left;

        public Node(E obj) {
            this.data = E.obj;
            this.right = this.left = null;
        }
    }


    public void add(E obj) {
        if(this.root == null) {
            root = new Node<E>(obj);
            return;
        }
        add(E obj, this.root);
        this.size++;
    }


    private void add(E obj, Node<E> node) {

        if(((Comparable<E>)obj).compareTo(node.data) > 0) {
            if(node.right == null) {
                node.right = new Node<E>(obj);
                return;
            }
            return add(obj, node.right);
        }

        if(node.left == null) {
            node.left = new Node<E>(obj);
            return;
        }

        return add(obj, node.left);

    }


    public void contains(E obj) {
        if(this.root == null) {
            System.out.println("Tree Empty");
            return;
        }

        boolean res = contains(obj, this.root);
        if(res) {
            System.out.println("Value Exists");
        } else {
            System.out.println("Value Does Not Exists");
        }
    }

    private boolean contains(E obj, Node<E> node) {

        if(node == null) {
            return false;
        }

        if(((Comparable<E>)obj).compareTo(node.data) == 0) {
            return true;
        } 

        if(((Comparable<E>)obj).compareTo(node.data) > 0) {
            return contains(obj, node.right);
        }

        return contains(obj, node.left);
    }


    private Node<E> findNode(E obj, Node<E> node) {
        if(node == null) {
            return null;
        }

        if(((Comparable<E>)obj).compareTo(node.data) == 0) {
            return node;
        } 

        if(((Comparable<E>)obj).compareTo(node.data) > 0) {
            return contains(obj, node.right);
        }

        return contains(obj, node.left);
    }


    public void remove(E obj) {
        if(obj == null) {
            System.out.println("Invalid Value");
            return;
        }

        if(contains(obj)) {
            Node<E> reqNode = findNode(obj, this.root);

        }

        System.out.println("This value does not exist in the tree");
    }
    

    private E remove(Node<E> node) {

        Node<E> parentNode;

        Node<E> tempNode = this.root;

        if()

        if(node.left == null && node.right == null) {
            
        }  
    }


    private Node<E> findInorderPredecessor(Node<E> node) {

    } 


    private Node<E> leftMostNode(Node<E> node) {
        if(node.left == null) {
            return node;
        }

        return leftMostNode(node.left);
    }


    private Node<E> rightMostNode(Node<E> node) {
        if(node.right == null) {
            return node;
        }
        return rightMostNode(node.right);
    }



}


public 
