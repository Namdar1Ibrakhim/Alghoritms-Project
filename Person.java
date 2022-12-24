package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private String Name;
    private String Surname;
    private String BDate;
    private String login;
    private String parol;
    private int age;
    private String mail;
    private String pol;
    private String tel;
    private List<Posts> postsList = new ArrayList<>();
    public List<String> friends = new ArrayList<>();
    // get() time complexity O(1)
    // add() O(1)

    int countLike = 0;
    String likeStr = "";

    Set<String> chs = new HashSet<>();
    //Set remove() time complexity O(1)
    //add() O(1)

    public Set<String> getChs() {
        return chs;
    }

    public void addChs(String ch) {
        chs.add(ch);
    }
    public void removeChs(String ch){
        chs.remove(ch);
    }


    public void setFriends(String login){
        friends.add(login);
    }
    public void deleteFriends(String login){
        friends.remove(login);
    }

    public void setPostsList(Posts posts){
        postsList.add(posts);
    }

    public List<Posts> getPostsList(){
        return postsList;
    }

    public void setName(String name){
        this.Name = name;
    }
    public void setSurname(String surname){
        this.Surname = surname;
    }
    public String getSurname(){
        return Surname;
    }

    public void setBDate(String bDate){
        this.BDate =bDate;
    }
    public String getBDate(){
        return BDate;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return Name;
    }
    public void setLogin(String login){
        this.login = login;

    }
    public String getLogin(){
        return login;
    }
    public void setParol(String parol){
        this.parol=parol;

    }
    public String getParol(){
        return parol;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setCount(){
        countLike++;
    }
    public void setLikeStr(String nam){
        likeStr+=nam+", ";
    }
    public int getCountLike(){
        return countLike;
    }
    public String getLikeStr(){
        return likeStr;
    }

}
