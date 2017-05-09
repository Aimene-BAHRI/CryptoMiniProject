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
        int base = 0;
        for (int i = 0, len = text.length(), buffer = 0; i < len; i++) {
            if (text.charAt(i) != ' ') {
                if (text.charAt(i) >= 'A'  && text.charAt(i) <= 'Z')
                    base = 65;
                else if (text.charAt(i) >= 'a'  && text.charAt(i) <= 'z')
                    base = 97;

                buffer = (((int) text.charAt(i)) + k - base )% 26 + base;
                crypted = crypted + (char)(buffer);
            }
            else
                crypted = crypted + ' ';
        }
        return crypted;
    }

    public String cezar_de_chrypt(String text, String key) {
        int k = Integer.valueOf(key);
        String decrypted = "";
        int base = 0;
        for (int i = 0, len = text.length(); i < len; i++) {
            if (text.charAt(i) != ' '){
                int c = text.charAt(i);
                if (Character.isUpperCase(c)){
                    c = c - (k % 26);
                    if (c < 'A')
                        c += 26;
                }
                else if (Character.isLowerCase(c))
                    c = c - (k % 26);
                if(c<'a')
                    c=c+26;
                decrypted=decrypted+(char) c ;
            }
            else
                decrypted = decrypted + ' ';
        }
        return decrypted;
    }

    //TODO
    /* Vigener */
    private String vigener_chrypt(String text, String key) {
        String crypted = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            crypted += (char) ((c + key.charAt(j) - 12 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return crypted;
    }

    private String vigener_de_chrypt(String text, String key) {
        String decrypted;
        decrypted = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') continue;
            decrypted += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return decrypted;
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
