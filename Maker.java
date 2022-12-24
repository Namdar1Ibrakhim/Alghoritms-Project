package com.company;

public class Maker {
    public static void main(String[] args) {
        Information information = new Information();
        try {
            information.glavMenu();
        }catch (Exception e){
            information.glavMenu();
        }
    }
}
