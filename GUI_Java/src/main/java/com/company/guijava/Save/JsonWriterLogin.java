package com.company.guijava.Save;

import org.json.JSONObject;
import java.io.FileWriter;


/**
 * This class is used to write information into a selected json file
 */
public class JsonWriterLogin {


    /**
     * This method required 3 param : mail and password of the user, and the filepath of the json where we want to write information
     * @param mail          String : the user's mail that we want to save
     * @param password      String : the user's password that we want to save
     * @param filePath      String : String : the filepath of the json that we want to open and where we will write
     */
    public void writeInFileRegister(String mail, String password, String filePath) {
        JSONObject obj = new JSONObject();

        FileWriter writer = null;
        try {
            obj.put("mail", mail);
            obj.put("password", password);
            writer = new FileWriter(filePath);
            obj.write(writer);
            writer.flush();
            writer.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }


    /**
     * This method required 3 param : mail and password of the user, and the filepath of the json where we want to write information
     * @param mail          String : the user's mail that we want to save
     * @param password      String : the user's password that we want to save
     * @param filePath      String : String : the filepath of the json that we want to open and where we will write
     * @param id            String : user's id
     * @param droit         String :
     */
    public void writeInFileSession(String mail, String password, String id , String droit, String filePath) {
        JSONObject obj = new JSONObject();

        FileWriter writer = null;
        try {
            obj.put("mail", mail);
            obj.put("password", password);
            obj.put("id", id);
            obj.put("droit", droit);
            writer = new FileWriter(filePath);
            obj.write(writer);
            writer.flush();
            writer.close();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
