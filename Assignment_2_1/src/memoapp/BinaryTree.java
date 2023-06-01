/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xhu
 */
public class BinaryTree <E, F extends Comparable<F>> {

    private Node<E, F> root;
    private int number_of_nodes;
    private Node<E, F>[] nodeList;

    private ArrayList<Node<E, F>> allNodes = new ArrayList<Node<E, F>>();
    
    public BinaryTree(Node<E, F> node)
    {
        this.root = node;
        this.number_of_nodes = 1;
        this.nodeList = null;
    }
    
    public BinaryTree(E element, F key)
    {
        Node<E, F> newNode = new Node<>(element, key);
        this.root = newNode;
        this.number_of_nodes = 1;
        this.nodeList = null;
    }

    public int getNumberOfNodes()
    {
        return number_of_nodes;
    }
    
    public BinaryTree()
    {
        this.root = null;
        this.number_of_nodes = 0;
        this.nodeList = null;
    }
    
    public void addElement(E element, F key)
    {
        Node<E, F> newNode = new Node<>(element, key);

        // Adds a new node to the binary tree 
        if(this.root == null) {
             // If the root is null, the new node becomes the root
            root = newNode;
        } else {
            addNode(root, newNode);
        }
        
        number_of_nodes++;
        // TEST just a placeholder to see all nodes that have been added
        //allNodes.add(newNode);
    }

    public ArrayList<Node<E,F>> getAllNodes() {
        return this.allNodes;
    }
    
    private void addNode(Node<E, F> currentNode, Node<E, F> targetNode)
    {
        int comparisonResult = targetNode.compareTo(currentNode);

        if(comparisonResult < 0) {
            // If the new node's key is less than the root's key,
            // recursively add the node to the left subtree
            if(currentNode.left == null) {
                currentNode.left = targetNode;
            } else {
                addNode(currentNode.left, targetNode);
            }
        } else {
            if(currentNode.right == null) { 
                currentNode.right = targetNode;
            } else {
                addNode(currentNode.right, targetNode);
            }
        }
        
        /* 
        if (this.root == null) 
        {
            this.root = node;
        } else {
            int comparisonResult = node.compareTo(root);
            if (comparisonResult < 0) 
            {
                // If the new node's key is less than the root's key,
                // recursively add the node to the left subtree
                if (root.left == null) 
                {
                    node.left = node;
                } else {
                    addNode(node.left, node);
                }
            } else if (comparisonResult > 0) 
            {
                // If the new node's key is greater than the root's key,
                // recursively add the node to the right subtree
                if (node.right == null) 
                {
                    node.right = node;
                } else 
                {
                    addNode(node.right, node);
                }
            }
        }
        */
    }
    
    public void traversal(Node<E, F> root)
    {
        // Performs an in-order traversal of the binary tree
        if (root != null) 
        {
            // If the root is not null, perform the traversal

            // Traverse the left subtree
            traversal(root.left);

            // Process the current node (root) then print the element
            System.out.println(root.element);

            // Traverse the right subtree   
            traversal(root.right);
        }
    }
    
    //!: This could cause problems
    @SuppressWarnings("unchecked")
    public Node<E, F>[] toSortedList()
    {       
        // right now this is returning in Descending order
        Node<E,F>[] nodes = new Node[this.number_of_nodes];
        int[] index = {0};
        toSortedList(root, nodes, index);
        return nodes;
    }
    
    private void toSortedList(Node<E, F> currentNode, Node<E, F>[] nodes, int[] index)
    {
        if (currentNode != null) 
        {
            toSortedList(currentNode.left, nodes, index);
            nodes[index[0]++] = currentNode;
            toSortedList(currentNode.right, nodes, index);
        }
    }
    
    public E searchElement(F key)
    {
        Node<E, F> targetNode = new Node<>(null, key);
        Node<E, F> resultNode = searchNode(root, targetNode);
        if (resultNode != null) 
        {
            return resultNode.element;
        }
        return null;
    }
       
    public Node<E, F> searchNode(Node<E, F> currentNode, Node<E, F> targetNode)
    {
        // Searches for a node with the specified key in the binary tree

        if (currentNode == null || targetNode == null) 
        {
            // If the root or node is null, the search is unsuccessful
            return null;
        }
        int comparisonResult = targetNode.compareTo(currentNode);
        if (comparisonResult == 0) 
        {
            // If the keys match, the node is found and returned
            return currentNode;
        } else if (comparisonResult < 0) 
        {
            // If the new node's key is less than the root's key,
            // recursively search in the left subtree
            return searchNode(currentNode.left, targetNode);
        } else 
        {
            // If the new node's key is greater than the root's key,
            // recursively search in the right subtree
            return searchNode(currentNode.right, targetNode);
        }
    }
    
    public void reverseOrder()
    {
        reverseOrder(root);
    }
    
    private void reverseOrder(Node<E, F> currentNode)
    {
        // Performs a reverse-order traversal of the binary tree

        if (currentNode != null) 
        {
            // If the root is not null, perform the traversal

            // swap the left and the right subtrees of each node
            Node<E,F> tempNode = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = tempNode;

            // Traverse the right subtree
            reverseOrder(currentNode.right);

            // Process the current node (root) then print the element
            System.out.println(currentNode.element);

            // Traverse the left subtree
            reverseOrder(currentNode.left);
        }
    }
}
