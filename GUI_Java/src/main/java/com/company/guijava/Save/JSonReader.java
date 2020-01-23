package com.company.guijava.Save;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * This class is used to read information from a json file and returning them thanks to a list
 */
public class JSonReader {


    /**
     * This method read information from a json file given in parameters and returning them into a List
     * @param filePath      String : the filepath of the json that we want to open and where we will read information
     * @return              List : containing the information extract from the json
     */
    public List<String> readFileLoginRegister(String filePath) {
        FileInputStream fileStream = null;

        try {
            fileStream = new FileInputStream(filePath);
        } catch (Exception e) {
        }

        StringBuilder json = new StringBuilder();
        Scanner scanner = new Scanner(fileStream);
        while(scanner.hasNext())
            json.append(scanner.nextLine());
        scanner.close();
        json = new StringBuilder(json.toString().replaceAll("[\t ]", ""));

        //region close file
        try {
            fileStream.close();
        } catch(IOException e) {
            System.exit(-1);
        }
        //endregion

        JSONObject objet =null;
        // create a json object
        try {
            objet = new JSONObject(json.toString());
        }catch (Exception e){

            System.out.println(e);
        }


        //region return list or null
        try {
            List<String> loginInfo = new ArrayList<>();
            assert objet != null;
            String mail = objet.getString("mail");
            String password = objet.getString("password");
            loginInfo.add(password);
            loginInfo.add(mail);
            return loginInfo;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
        //endregion
    }


    /**
     * This method read information from a json file given in parameters and returning them into a List
     * @param filePath      String : the filepath of the json that we want to open and where we will read information
     * @return              List : containing the information extract from the json
     */
    public List<String> readFileLoginSession(String filePath) {
        FileInputStream fileStream = null;

        try {
            fileStream = new FileInputStream(filePath);
        } catch (Exception e) {
        }

        StringBuilder json = new StringBuilder();
        Scanner scanner = new Scanner(fileStream);
        while(scanner.hasNext())
            json.append(scanner.nextLine());
        scanner.close();
        json = new StringBuilder(json.toString().replaceAll("[\t ]", ""));

        //region close file
        try {
            fileStream.close();
        } catch(IOException e) {
            System.exit(-1);
        }
        //endregion

        JSONObject objet =null;
        // create a json object
        try {
            objet = new JSONObject(json.toString());
        }catch (Exception e){

            System.out.println(e);
        }


        //region return list or null
        try {
            List<String> loginInfo = new ArrayList<>();
            assert objet != null;
            String mail = objet.getString("mail");
            String password = objet.getString("password");
            String id = objet.getString("id");
            loginInfo.add(password);
            loginInfo.add(mail);
            loginInfo.add(id);
            return loginInfo;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
        //endregion
    }



    public List<List<String>> readFileDbCon(String filePath) {
        FileInputStream fileStream = null;
        try {
            fileStream = new FileInputStream(filePath);
        } catch (Exception e) {
            System.exit(-1);
        }

        StringBuilder json = new StringBuilder();
        Scanner scanner = new Scanner(fileStream);
        while(scanner.hasNext())
            json.append(scanner.nextLine());
        scanner.close();
        json = new StringBuilder(json.toString().replaceAll("[\t ]", ""));

        //region close file
        try {
            fileStream.close();
        } catch(IOException e) {
            System.exit(-1);
        }
        //endregion

        JSONObject objet =null;
        // create a json object
        try {
            objet = new JSONObject(json.toString());
        }catch (Exception e){

            System.out.println(e);
        }


        //region return list or null
        try {
            List<List<String>> loginInfo = new ArrayList<>();
            assert objet != null;

            String user = objet.getString("user");
            List<String> listeUser = new ArrayList<>();
            listeUser.add(user);
            loginInfo.add(listeUser);

            String password = objet.getString("password");
            List<String> listePassword = new ArrayList<>();
            listePassword.add(password);
            loginInfo.add(listePassword);
            //loginInfo.add(password);

            JSONArray url = objet.getJSONArray("url");
            List<String> listeUrl = new ArrayList<>();
            for (int i=0; i<url.length(); i++){
                listeUrl.add(url.get(i).toString());
            }
            loginInfo.add(listeUrl);
            return loginInfo;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
        //endregion
    }

}
