package com.company.guijava.RequestSQL;

import com.company.guijava.Connexion;
import com.company.guijava.Save.JSonReader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Request {

        // CHAQUE REQUETE, MET LES DANS DES METHODES DIFFERENTES


    private Connexion connexion = new Connexion();
    private RequestReader request =new RequestReader();
    private PreparedStatement prep1 = null;




    public List<String> loginRequest(String mail, String password) {

        String loginR = "SELECT email,mot_de_passe, id FROM utilisateur WHERE email = ? AND mot_de_passe = ?";


        try {
            prep1 = connexion.connect().prepareStatement(loginR, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, mail);
            prep1.setString(2, password);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            if(!values.isEmpty()){
                System.out.println("dans la base");
            }
            else {
                System.out.println("pas dans la base");
            }
            return values;


        }
        catch(Exception e){
            return null;
        }
    }


    public void signupRequest(String nom, String prenom, String email, String mot_de_passe, String numero_portable, String adresse_postale, String code_postale, String siege_le_plus_proche, String distance_estime) {

        String signupR = "INSERT INTO utilisateur (nom,prenom,email, mot_de_passe,numero_portable,adresse_postale, code_postale,siege_le_plus_proche,distance_estime) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        //voir avec un replace into

        try {
            prep1 = connexion.connect().prepareStatement(signupR);
            prep1.setString(1, nom);
            prep1.setString(2, prenom);
            prep1.setString(3, email);
            prep1.setString(4, mot_de_passe);
            prep1.setString(5, numero_portable);
            prep1.setString(6, adresse_postale);
            prep1.setString(7, code_postale);
            prep1.setString(8, siege_le_plus_proche);
            prep1.setString(9, distance_estime);


            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert "+ nom);

        }
        catch(Exception e) {
            System.out.println("not insert");
        }

    }



    public List<String> DisplayProject() {
        JSonReader register = new JSonReader();
        List<String> loginRegister = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String displayP = "SELECT nom_projet,date_creation,description_projet,date_fin \n" +
                "FROM projet WHERE id_utilisateur=? " +
                "ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, loginRegister.get(2));
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        }
        catch(Exception e){
            return null;
        }
    }

    public List<String> DisplayProjectAdmin() {

        String displayP = "SELECT nom_projet,date_creation,description_projet,date_fin \n" +
                "FROM projet" +
                "ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        }
        catch(Exception e){
            return null;
        }
    }


    public List<String> DisplayProduct() {

        String displayP = "SELECT nom_produit,date_ajout \n" +
                "FROM produit \n" +
                "ORDER BY date_ajout ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        }
        catch(Exception e){
            return null;
        }
    }

    public List<String> favoriteColor(){
        String requestColor = " SELECT count(couleur_module) as nombre_couleur,couleur_module\n" +
                "        FROM personnalisation_porte\n" +
                "        GROUP BY couleur_module\n" +
                "        ORDER BY nombre_couleur DESC\n" +
                "        LIMIT 3";
        try {
            prep1 = connexion.connect().prepareStatement(requestColor, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;

        }
        catch(Exception e){
            return null;
        }

    }

    public List<String> nbProject(){
        String requestProject = "SELECT count(tab.id) from (SELECT DISTINCT id_projet as id FROM produit_projet) as tab";
        try {
            prep1 = connexion.connect().prepareStatement(requestProject, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;

        }
        catch(Exception e){
            return null;
        }
    }

    public List<String> gainTotal(){
        String requestProject = "SELECT  month(projet.date_fin) as mois, (sum(prix_ht)) as total\n" +
                "FROM produit_projet\n" +
                "LEFT JOIN projet ON projet.id = produit_projet.id_projet \n" +
                "where year(projet.date_fin)=2019\n" +
                "group by mois\n" +
                "ORDER BY projet.date_fin ASC";
        try {
            prep1 = connexion.connect().prepareStatement(requestProject, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;

        }
        catch(Exception e){
            return null;
        }
    }



}
