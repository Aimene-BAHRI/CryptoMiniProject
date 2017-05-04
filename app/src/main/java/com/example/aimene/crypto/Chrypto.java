package com.example.aimene.crypto;

/**
 * Created by zexes-g on 26/04/17.
 */

public class Chrypto {

      /////////////////////
     //----Attribute----//
    /////////////////////
    String name;

    // Constructor
    public Chrypto(String name) {
        this.name = name;
    }

    // Getter and Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }



      ////////////////////
     //----Methodes----//
    ////////////////////

    /* Chrypt */
    public String chrypt(String text , String key){
        String result = "";
        switch (name){
            case "Cezar":
                result = cezar_chrypt(text , key);
                break;
            case "Vigener":
                result = vigener_chrypt(text , key);
                break;
            case "Rsa":
                result = rsa_chrypt(text , key);
                break;
            case "Elgamel":
                result = elgamel_chrypt( text , key);
                break;
        }
        return result;
    }




    /* De_Chrypt */
    public String de_chrypt(String text , String key){
        String result = "";
        switch (name){
            case "Cezar":
                result = cezar_de_chrypt(text , key);
                break;
            case "Vigener":
                result = vigener_de_chrypt(text , key);
                break;
            case "Rsa":
                result = rsa_de_chrypt(text , key);
                break;
            case "Elgamel":
                result = elgamel_de_chrypt( text , key);
                break;
        }
        return result;
    }




    /* Cezar */
    public String cezar_chrypt(String text, String key) {
        int k = Integer.valueOf(key);
        String crypted = "";
        for (int i = 0, len = text.length(), buffer = 0; i < len; i++) {
            buffer = ((int) text.charAt(i)) + k;
            crypted = crypted + (char)(buffer);
        }
        return crypted;
    }

    public String cezar_de_chrypt(String text, String key) {
        int k = Integer.valueOf(key);
        String decrypted = "";
        for (int i = 0, len = text.length(), buffer = 0; i < len; i++) {
            buffer = ((int) text.charAt(i)) - k;
            decrypted = decrypted + (char)(buffer);
        }
        return decrypted;
    }



    //TODO


    /* Vigener */
    private String vigener_chrypt(String text, String key) {
        return "";
    }

    private String vigener_de_chrypt(String text, String key) {
        return "";
    }


    /* Rsa */
    private String rsa_chrypt(String text, String key) {
        return "";
    }

    private String rsa_de_chrypt(String text, String key) {
     return "";
    }


    /* Elgamel */
    private String elgamel_chrypt(String text, String key) {
        return "";
    }

    private String elgamel_de_chrypt(String text, String key) {
        return "";
    }

    //--------------------------------------

}
