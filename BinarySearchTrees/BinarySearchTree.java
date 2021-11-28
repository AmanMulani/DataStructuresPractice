// package BinarySearchTree;
// import BinarySearchTree.Node;

public class BinarySearchTree {
    Node root = null;
    
    public void insertNode(int data) {
        //Creating a new node first
        Node newNode = new Node();
        newNode.data = data;
        if(root == null) {
            root = newNode;
            return;
        }
        Node currNode = root;
        Node tempStoreNode = null;
        while(currNode != null) {
            tempStoreNode = currNode;
            if(data > currNode.data) {
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        
        
        if(tempStoreNode.data > data) {
            tempStoreNode.left = newNode;
        } else {
            tempStoreNode.right = newNode;
        }
        newNode.parent = tempStoreNode;
        newNode.left = null;
        newNode.right = null;
    }

    public void preOrderTraversal(Node n) {
        if(n != null) {
            System.out.println(n.data);
            preOrderTraversal(n.left);
            preOrderTraversal(n.right);
            
        }
    }    

    public void postOrderTraversal(Node n) {
        if(n!=null) {
            postOrderTraversal(n.left);
            postOrderTraversal(n.right);
            System.out.println(n.data);
        }
    }

    public void inOrderTraversal(Node n) {
        if(n!=null) {
            inOrderTraversal(n.left);
            System.out.println(n.data);
            inOrderTraversal(n.right);
        }
    }


    public Node treeMinimum(Node n) {
        if(n.left == null) {
            return n;
        }
        return treeMinimum(n.left);
    }

    public void treeMinValue(Node n) {
        System.out.println("The minimum value is: " + treeMinimum(n).data);
    }

    public Node treeMaximum(Node n) {
        if(n.right == null) {
            return n;
        }
        return treeMaximum(n.right);
    }

    public void treeMaxValue(Node n) {
        System.out.println("The maximum value is: " + treeMaximum(n).data);
    }


    public Node successor(Node n) {
        if(n.right != null) {
            return treeMinimum(n);
        }

        Node y = n.parent;
        while(y.parent != null && y.left == n) {
            n = y;
            y = y.parent;
        }
        return y;
    }

    public void successorVal(Node n) {
        Node successor = successor(n);
        if(successor == null) {
            System.out.println("No successor!");
        } else {
            System.out.println("The successor is: " + successor.data);
        }
    }


    public Node predecessor(Node n) {
        if(n.left != null) {
            return treeMaximum(n);
        }

        Node y = n.parent;
        while(y.parent != null && y.right == n) {
            n = y;
            y = y.parent;
        }
        return y;
    }

    public void predecessorVal(Node n) {
        Node predecessor = predecessor(n);
        if(predecessor == null) {
            System.out.println("No predecessor!");
        } else {
            System.out.println("The predecessor is: " + predecessor.data);
        }
    }

    public Node searchElem(int data, Node node) {
        if(node == null) {
            return null;
        }
        if(data == node.data) {
            return node;
        } else if(node.data > data) {
            return searchElem(data, node.left);
        } else {
            return searchElem(data, node.right);
        }
    }

    public void checkIfNodeExists(int data, Node node) {
        Node n = searchElem(data, node);
        if(n == null) {
            System.out.println("Node does not exist.");
        } else {
            System.out.println("Node exists.");
        }
    }


    public void treeTransplant(Node u, Node v) {

        if(u.parent == null) {
            this.root = v;
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


    public void deleteNodeWithVal(int val) {
        Node node = searchElem(val, this.root);
        if(node == null) {
            System.out.println("Node with the given value does not exist");
            return;
        }

        /*
        Cases in deletion of a node:
        1. It has a left sub-tree and no sub-right tree
        2. It has a right sub-tree and no left-sub tree
        3. The tree has both right and left sub-trees
        */

        if(node.left == null) {
            //Case 1: When there is no left sub-tree, we directly replace the current node with the right tree.
            treeTransplant(node, node.right);
        } else if(node.right == null) {
            //Case 2: When there is no right sub-tree, we directly replace the current node with the left tree.
            treeTransplant(node, node.left);
        } else {
            //Case 3: When the node has both left and right sub-trees, then, 
            //we can only replace the current node with the node that is least greater than the current element.
            //The node which is least greater than the current node will be present in the right sub-tree of the node
            Node tempNode = treeMinimum(node.right);
            if(tempNode.parent != node.parent) {
                /* 
                This scenarios happens when the least greater node is not a direct child of the node to be deleted.
                Since it is not a direct child of the node to be deleted, we need to first replace the current node with it's 
                right sub-tree. Since the treeMinimum returns a node that does not have any left children, therefore, we don't need to worry about transplanting
                the left subtree. Once we have tranplated tempNode with it's right sub-tree,
                then, we make the connections of the tempNode with the right-sub child and the parent of the node to be deleted.
                */
                treeTransplant(tempNode, tempNode.right);
                tempNode.right = node.right;
                tempNode.right.parent = tempNode;
            }
            treeTransplant(node, tempNode);
            tempNode.left = node.left;
            tempNode.left.parent = tempNode;
            System.out.println("The element successfully deleted");
        }
    }


}