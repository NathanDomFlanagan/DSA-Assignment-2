/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoapp;

/**
 *
 * @author xhu
 */
public class Node <E, F extends Comparable<F>> implements Comparable <Node<E, F>>{
    
    public E element;
    public F key;
    public Node<E, F> left;
    public Node<E, F> right;

    public Node()
    {
        
    }

    public Node(E element) 
    {
        this.element = element;
    }

    public Node(E element, F key) 
    {
        this.element = element;
        this.key = key;
    }

    @Override
    public int compareTo(Node<E, F> node) 
    {
        return this.key.compareTo(node.key);
    }
}
