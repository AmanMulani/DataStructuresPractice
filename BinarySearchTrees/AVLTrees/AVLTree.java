public class AVLTree<E> {
    
    class Node<E> {
        E data;
        Node<E> parent, left, right;

        public Node(E data) {
            this.data = data;
            parent = left = right = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    Node<E> root;
    int currentSize;

    public AVLTree() {
        this.root = null;
        currentSize = 0;
    }

    private Node<E> rightRotate(Node<E> node) {
        Node<E> temp = node.left;
        node.left = temp.right;
        if(node.left != null) {
            node.left.parent = node;
        }
        temp.right = node;
        temp.parent = node.parent;
        node.parent = temp;
        return temp;
    }

    private Node<E> leftRotate(Node<E> node) {
        Node<E> temp = node.right;
        node.right = temp.left;
        if(node.right != null) {
            node.right.parent = node;
        }
        temp.left = node;
        temp.parent = node.parent;
        node.parent = temp;
        return temp;
    }


    private Node<E> rightLeftRotate(Node<E> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }


    private Node<E> leftRightRotate(Node<E> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }


    public void add(E obj) {
        Node<E> node = new Node<E>(obj);
        if(this.root == null) {
            this.root = node;
            currentSize++;
            return;
        }
        add(this.root, node);
    }


    public int height(Node<E> node) {
        
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }


    private void add(Node<E> parent, Node<E> newNode) {
        if(((Comparable<E>)parent.data).compareTo(newNode.data) > 0) {
            if(parent.left == null) {
                parent.left = newNode;
                newNode.parent = parent;
                this.currentSize++;
            } else {
                add(parent.left, newNode);
            }
        } else {
            if(parent.right == null) {
                parent.right = newNode;
                newNode.parent = parent;
                this.currentSize++;
            } else {
                add(parent.right, newNode);
            }
        }
        checkBalance(newNode);
    }


    private void checkBalance(Node<E> node) {

        if((height(node.left)-height(node.right) > 1) || (height(node.right)-height(node.left) > 1)) {
            rebalance(node);
        }
        if(node.parent == null) {
            return;
        }
        checkBalance(node.parent);
    }


    private void rebalance(Node<E> node) {
        if(height(node.left)-height(node.right) > 1) {
            if(height(node.left.left) > height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node = leftRightRotate(node);
            }
        } else {
            if(height(node.right.right) > height(node.right.left)) {
                node = leftRotate(node);
            } else {
                node = rightLeftRotate(node);
            }
        }

        if(node.parent == null) {
            root = node;
        }
    }


    public void delete(E obj) {
        Node<E> requiredNode = contains(this.root, obj);
        if(requiredNode == null) {
            System.out.println("The required node does not exist");
            return;
        }

        if(currentSize == 1) {
            this.root = null;
            currentSize--;
            return;
        }
        delete(requiredNode);
        // printInOrder(this.root);
    }


    private void delete(Node<E> node) {
        if(node.left == null && node.right == null) {
            replaceNode(node, null);
        } else if(node.left == null) {
            replaceNode(node, node.right);
        } else if(node.right == null) {
            replaceNode(node, node.left);
        } else {
            System.out.println("I am here");
            Node<E> inorderPredecessor = inOrderPredecessor(node);
            if(inorderPredecessor.parent.right == inorderPredecessor) {
                inorderPredecessor.parent.right = null;
            } else {
                inorderPredecessor.parent.left = null;
            }
            replaceNode(node, inorderPredecessor);
        }

        currentSize--;

    }


    private void replaceNode(Node<E> u, Node<E> v) {
        if(u.parent == null) {
            this.root = v;
            return;
        }

        if(u.parent.left == u) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }

        if(v!=null) {
            v.parent = u.parent;
        }

    }


    private Node<E> inOrderPredecessor(Node<E> node) {
        if(node == null) {
            return null;
        }
        Node<E> tempNode = node;
        tempNode = node.left;
        while(tempNode!=null && tempNode.right != null) {
            tempNode = tempNode.right;
        }

        return tempNode;
    }


    public Node<E> contains(Node node, E obj) {

        if(node == null) {
            return null;
        }
        if(((Comparable<E>)node.data).compareTo(obj) == 0) {
            return node;
        } else if(((Comparable<E>)node.data).compareTo(obj) > 0) {
            return contains(node.left, obj);
        } else {
            return contains(node.right, obj);
        }
    }


    public void printInOrder(Node node) {
        if(node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.data + " ");
        printInOrder(node.right);
    }
}
