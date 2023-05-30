/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author xhu
 */
public class MemoManager<E>  {
    
    private BinaryTree<Memo, Date> bTreeDate;
    private BinaryTree<Memo, String> bTreeTitle;
    

    public MemoManager() {
        bTreeDate = new BinaryTree<Memo, Date>();
        bTreeTitle = new BinaryTree<Memo, String>();
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
            bTreeDate.addElement(memo, memo.getDate());
            // TODO uncomment
            //}else {

            //bTreeTitle.addElement(memo, memo.getTitle());
        }
    }
    
    public Memo findMemo(E key)
    {
        if(key instanceof String) {
            return bTreeTitle.searchElement((String) key);
        } else {
            return bTreeDate.searchElement((Date) key);
        }
    }
    
    public Memo[] getSortedMemoList(E key)
    {
        ArrayList<Memo> list = new ArrayList<Memo>();

        if (key instanceof String) {
             Node<Memo, String>[] nodes = bTreeTitle.toSortedList();

             for (Node<Memo,String> node : nodes) {
                list.add(node.element);
             }
        } else {
            Node<Memo, Date>[] nodes = bTreeDate.toSortedList();

            for (Node<Memo,Date> node : nodes) {
               list.add(node.element);
            }
        }

        return list.toArray(new Memo[list.size()]);
    }
    
    public void reverseOrder()
    {
        
    }
    
}
