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
    
    public BinaryTree()
    {
        this.root = null;
        this.number_of_nodes = 0;
        this.nodeList = null;
    }
    
    public void addElement(E element, F key)
    {
        Node<E, F> newNode = new Node<>(element, key);

        addNode(root, newNode);

        // TEST just a placeholder to see all nodes that have been added
        allNodes.add(newNode);
    }

    public ArrayList<Node<E,F>> getAllNodes() {
        return this.allNodes;
    }
    
    private void addNode(Node<E, F> root, Node<E, F> node)
    {       
        // Adds a new node to the binary tree 
        if (this.root == null) 
        {
            // If the root is null, the new node becomes the root
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
        number_of_nodes++;
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
        nodeList = new Node[number_of_nodes];
        toSortedList(root);
        return nodeList;
    }
    
    private void toSortedList(Node<E, F> root)
    {
        if (root != null) 
        {
            toSortedList(root.left);
            nodeList[--number_of_nodes] = root;
            toSortedList(root.right);
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
       
    public Node<E, F> searchNode(Node<E, F> root, Node<E, F> node)
    {
        // Searches for a node with the specified key in the binary tree

        if (root == null || node == null) 
        {
            // If the root or node is null, the search is unsuccessful
            return null;
        }
        int comparisonResult = node.compareTo(root);
        if (comparisonResult == 0) 
        {
            // If the keys match, the node is found and returned
            return root;
        } else if (comparisonResult < 0) 
        {
            // If the new node's key is less than the root's key,
            // recursively search in the left subtree
            return searchNode(root.left, node);
        } else 
        {
            // If the new node's key is greater than the root's key,
            // recursively search in the right subtree
            return searchNode(root.right, node);
        }
    }
    
    public void reverseOrder()
    {
        reverseOrder(root);
    }
    
    private void reverseOrder(Node<E, F> root)
    {
        // Performs a reverse-order traversal of the binary tree

        if (root != null) 
        {
            // If the root is not null, perform the traversal

            // Traverse the right subtree
            reverseOrder(root.right);

            // Process the current node (root) then print the element
            System.out.println(root.element);

            // Traverse the left subtree
            reverseOrder(root.left);
        }
    }
}
