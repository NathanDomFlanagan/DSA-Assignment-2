/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author xhu
 */
public class MemoManager<E, F extends Comparable<F>> {
    
    private BinaryTree<Memo, F> bTreeDate;
    private BinaryTree<Memo, F> bTreeTitle;
    

    public MemoManager() {
        bTreeDate = new BinaryTree<Memo, F>();
        bTreeTitle = new BinaryTree<Memo, F>();
    }
    
    public void addMemo(String date, String title, String message)
    {
        Date startDate = ConvertStringToDate(date);

        Memo memo = new Memo(startDate, title, message);

        addToTree(memo, false);

        addToTree(memo, true);

   
    }

    public Date ConvertStringToDate(String stringDate) {

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        Date convertedDate;

        try{

            convertedDate = df.parse(stringDate);

            return convertedDate;

        } catch(Exception e) {
            return null;
        }
    }

    
    public void addToTree(Memo memo, Boolean isKeyDate)
    {
        if(isKeyDate) {
            bTreeDate.addElement(memo, (F) memo.getDate());
        }else {
            bTreeTitle.addElement(memo, (F) memo.getTitle());
        }
    }
    
    public Memo findMemo(E key)
    {
        if(key instanceof String) {
            return bTreeTitle.searchElement((F) key);
        } else {
            return bTreeDate.searchElement((F) key);
        }
    }
    
    public Memo[] getSortedMemoList(F key)
    {
        
        int numberOfNodes = getNumberOfNodes(key);
        Memo[] memoList = new Memo[numberOfNodes];

        Node<Memo, F>[] nodes = getSortedListNodes(key);
        
        for(int i = 0; i < numberOfNodes; i++) {
            memoList[i] = nodes[i].element;
        } 
            
        return memoList;
    }
    
    public void reverseOrder()
    {
        bTreeDate.reverseOrder();
        bTreeTitle.reverseOrder();
    }

    private int getNumberOfNodes(F key) {
        if(key instanceof String) {
            return bTreeTitle.getNumberOfNodes();
        }

        return bTreeDate.getNumberOfNodes();
    }

    private Node<Memo, F>[] getSortedListNodes(F key) {
        // check if key is a Title (string)
        if (key instanceof String) {
            // note toSortedList returns Descending order
            return bTreeTitle.toSortedList();             

        } 
        // otherwise we can assume that it is a Date
        return bTreeDate.toSortedList();                   
    }
    
}
