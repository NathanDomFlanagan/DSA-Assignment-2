/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memoapp;

import java.util.Date;

/**
 *
 * @author xhu
 */
public class Memo
{
    
    protected Date date;
    protected String title;
    protected String message;
    

    public Memo(Date date, String title, String message) 
    {
        this.date = date;
        this.title = title;
        this.message = message;
    }

    public Date getDate() 
    {
        return date;
    }

    public String getTitle() 
    {
        return title;
    }

    public String getMessage() 
    {
        return message;
    }

    public String toString()
    {
        return date.toString() + "\n" + title + "\n" + message;
    }
}
