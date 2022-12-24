package com.company;

import java.util.ArrayList;
import java.util.List;

public class Posts extends Person{
    private String datePublication;
    private String post;
    String comm= "";


    public void addPost(String post){
        this.post = post;
    }
    public String getPost(){
        return post;
    }
    public void setDatePublication(String datePublication){
        this.datePublication=datePublication;
    }
    public String getDatePublication(){
        return datePublication;
    }

    public void napcomment(String c){
        comm+=c + "\n";
    }
    public String comenty(){
        return comm;
    }

}
