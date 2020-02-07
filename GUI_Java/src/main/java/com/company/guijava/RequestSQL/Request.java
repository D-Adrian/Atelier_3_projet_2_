package com.company.guijava.RequestSQL;

import com.company.guijava.Connexion;
import com.company.guijava.Save.JSonReader;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

public class Request {

    private Connexion connexion = new Connexion();
    private RequestReader request = new RequestReader();
    private PreparedStatement prep1 = null;


    /**
     * Permet de s'avoir si les coordonnées entré sont exact
     * @param mail : mail de l'utilisateur
     * @param password : mot de passe de l'utilisateur
     * @return Retourne la liste contenant le mail, le mot de passe, l'id de l'utilisateur et le rôle de ce dernier
     */

    public List<String> loginRequest(String mail, String password) {

        String loginR = "SELECT email,mot_de_passe, id, role_utilisateur FROM utilisateur WHERE email = ? AND mot_de_passe = ?";

        try {
            prep1 = connexion.connect().prepareStatement(loginR, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, mail);
            prep1.setString(2, password);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            if (!values.isEmpty()) {
                System.out.println("dans la base");
            } else {
                System.out.println("pas dans la base");
            }
            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet de crée une nouveau compte utilisateur
     * @param nom : nom de l'utilisateur
     * @param prenom : prénom de l'utilisateur
     * @param email : email de l'utilisateur
     * @param mot_de_passe : mot de passe de l'utilisateur
     * @param numero_portable : numero_portable de l'utilisateur
     * @param adresse_postale : adresse_postale de l'utilisateur
     * @param code_postale : code_postale de l'utilisateur
     * @param siege_le_plus_proche : siège le plus proche de l'utilisateur
     * @param distance_estime : distance estimé entre le siège et le domicile de l'utilisateur
     */

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
            System.out.println("insert " + nom);

        } catch (Exception e) {
            System.out.println("not insert");
        }

    }

    /**
     * Permet de recuperer la liste des produits
     * @return : retourne une liste contenant le nom des produits
     */

    public List<String> listOfProduct() {
        String displayP = "SELECT nom_produit FROM produit ";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();
            return values;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet de recuperer la liste des matériaux
     * @return : retourne la liste contenant le nom des matériaux
     */

    public List<String> listOfMaterial() {
        String displayP = "SELECT nom_materiau FROM materiau ";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();
            return values;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet d'afficher tout les projets
     * @return : retourne une liste contenant l'id , le nom du projet , la date de création du projet et la date de fin du projet
     */

    public List<String> DisplayProject() {
        JSonReader register = new JSonReader();
        List<String> loginRegister = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String displayP = "SELECT id, nom_projet,date_creation,description_projet,date_fin \n" +
                "FROM projet WHERE id_utilisateur=? " +
                "ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, loginRegister.get(2));
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet d'afficher les informations d'un projet dans une fenetre d'édition pour uniquement ses projets
     * @param id_project : id du projet
     * @return : retourne une liste contenant le nom du projet et la description du projet par rapport a l'id de l'utilisateur
     */

    public List<String> DisplayProjectToEdit(String id_project) {
        JSonReader register = new JSonReader();
        List<String> loginRegister = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String displayP = "SELECT nom_projet,description_projet \n" +
                "FROM projet WHERE id_utilisateur=? AND id=? " +
                "ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, loginRegister.get(2));
            prep1.setString(2, id_project);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet d'afficher les informations d'un projet dans une fenetre d'édition dans le menu admin pour tout les projets
     * @param id_project : id du projet
     * @return : retourne une liste contenant le nom du projet et la description du projet de tout les projets
     */

    public List<String> DisplayProjectToEditAdmin(String id_project) {

        String displayP = "SELECT nom_projet,description_projet \n" +
                "FROM projet WHERE id=?  " +
                "ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, id_project);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet d'afficher les dimensions déja existance dans des fields
     * @param idProductProject : id produit-projet
     * @return : retourne une liste contenant la largeur_totale, la longueur_totale, l'épaisseur_totale et l'id du produit
     */

    public List<String> DisplayProductDimension(String idProductProject){
        String displayP = "SELECT largeur_totale, longueur_totale, epaisseur_totale, id_produit FROM produit_projet WHERE id=? ";

        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, idProductProject);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Permet d'afficher les modules et matériaux choisi par l'utilisateur
     * @param idProductProject : l'id du produit-projet
     * @return : retourne une liste contenant le nom du module et le nom du matériau
     */

    public List<String> DisplayProductMaterialModule(String idProductProject){
        String displayP = "SELECT PP.nom_module, M.nom_materiau FROM personnalisation_porte as PP " +
                " LEFT JOIN materiau as M ON M.id=PP.id_materiau " +
                " WHERE PP.id_produit_projet=? ";

        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, idProductProject);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Affiche tout les projets de tout les utilisateurs en mode admin
     * @return : retourne une liste contenant l'id du projet, le nom du projet, la date de création du projet, la date de fin du projet
     */

    public List<String> DisplayProjectAdmin() {

        String displayP = "SELECT id, nom_projet, date_creation, description_projet, date_fin " +
                " FROM projet " +
                " ORDER BY date_creation ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();/////////
            List<String> values = request.seeRequest(result);
            prep1.close();

            System.out.println(values);
            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Affiche tout les produits disponible
     * @return : retourne une liste contenant le nom du produit et la date d'ajout du produit
     */

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


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Affiche les détails de tout les produits liées au projet de l'utilisateur
     * @param idProject : l'id du projet
     * @return : retourne une liste contenant l'id du projet, l'id du produit , la largeur totale du produit , la longueur totale du produit , l'épaisseur totale du produit , le prix ht et la Tva
     */

    public List<String> DisplayDetails(String idProject) {

        String displayP = "SELECT id, id_projet, id_produit, largeur_totale, longueur_totale, epaisseur_totale, prix_ht, tva " +
                "FROM produit_projet WHERE id_projet=? " +
                "ORDER BY id_projet ASC";
        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, idProject);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;


        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Affiche les modules les plus utilisés
     * @return : retourne une liste contenant le nombre de module et le nom du module
     */

    public List<String> favoriteModules() {
        String requestModule = " SELECT count(nom_module) as nombre_module,nom_module\n" +
                "        FROM personnalisation_porte\n" +
                "        GROUP BY nom_module\n" +
                "        ORDER BY nombre_module DESC\n" +
                "        LIMIT 3";
        try {
            prep1 = connexion.connect().prepareStatement(requestModule, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;

        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Affiche le nombre de projet crée dans un label
     * @return : retourne une liste contenant le nombre d'id projet
     */

    public List<String> nbProject() {
        String requestProject = "SELECT count(tab.id) from (SELECT DISTINCT id_projet as id FROM produit_projet) as tab";
        try {
            prep1 = connexion.connect().prepareStatement(requestProject, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * la méthode permet de calculer et d'afficher le gain total par mois
     * @return : retourne une liste contenant le mois et le total
     */

    public List<String> gainTotal() {
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

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * la methode permet d'ajouter une description et un nom a un projet
     * @param name_project : nom du projet
     * @param desc_project : description du projet
     */

    public void newProject(String name_project, String desc_project) {

        JSonReader register = new JSonReader();
        List<String> newProject = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String requestnewProject = "INSERT INTO projet (nom_projet,date_creation ,description_projet,id_utilisateur) " +
                "VALUES (?,?,?, ?)";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.setString(1, name_project);
            prep1.setDate(2, date);

            prep1.setString(3, desc_project);
            prep1.setString(4, newProject.get(2));

            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert " + name_project + desc_project);

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * la méthode permet de modifier un projet déja existant
     * @param id_project : id du projet
     * @param name_project : nom du projet
     * @param desc_project : description du projet
     */

    public void editProject(String id_project, String name_project, String desc_project) {

        String requestnewProject = "UPDATE projet " +
                "SET nom_projet = ? , description_projet = ? " +
                "WHERE id = ?";
        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.setString(1, name_project);
            prep1.setString(2, desc_project);
            prep1.setString(3, id_project);
            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert ");

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * la méthode permet de mettre fin à un projet
     * @param idProject : id du projet
     */

    public void endProject(String idProject) {
        String requestnewProject = "UPDATE projet \n" +
                "SET date_fin = ? " +
                "WHERE id = ?";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());
        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.setDate(1, date);
            prep1.setString(2, idProject);

            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert " + date);

        } catch (Exception e) {
            System.out.println("not insert");
    }

    }
    /**
     * la méthode permet de recuperer l'id d'un produit selon son nom
     * @param productName : nom du produit
     * @return : retourne l'id du produit
     */

    public String selectIdProduct(String productName) {
        String requestnewProject = "SELECT id FROM produit WHERE nom_produit=?";

        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.setString(1, productName);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();

            return values.get(0);

        } catch (Exception e) {
            System.out.println("not found");
            return null;
        }
    }

    /**
     * la méthode permet de recuperer l'id , le prix au m2 par rapport a son nom
     * @param materialName : nom du matériau
     * @return : retourne une liste contenant l'id, le prix
     */

    public List<String> selectIdMaterial(String materialName) {
        String selectIdmaterial = "SELECT id, prix_m2_ht*(tva/100+1) FROM materiau WHERE nom_materiau=?";

        try {
            prep1 = connexion.connect().prepareStatement(selectIdmaterial);
            prep1.setString(1, materialName);
            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();
            return values;

        } catch (Exception e) {
            System.out.println("not received");
            return null;
        }
    }

    /**
     * la méthode permet d'inserer un produit à un projet
     * @param id_projet : id du projet
     * @param id_produit : id du produit
     * @param largeur_totale : largeur totale du produit
     * @param longueur_totale : longueur totale du produit
     * @param epaisseur_totale : epaisseur totale du produit
     * @param prix_ht : prix hors taxe
     */


    public void InsertProductToProject(String id_projet, String id_produit, String largeur_totale, String longueur_totale, String epaisseur_totale, String prix_ht) {
        String requestnewProject = "INSERT INTO produit_projet (id_projet,id_produit ,largeur_totale, longueur_totale, epaisseur_totale, prix_ht) " +
                "VALUES (?,?,?,?,?,?)";

        try {
            System.out.println("try to insert");

            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.setString(1, id_projet);
            prep1.setString(2, id_produit);
            prep1.setString(3, largeur_totale + "cm");
            prep1.setString(4, longueur_totale + "cm");
            prep1.setString(5, epaisseur_totale + "mm");
            prep1.setString(6, prix_ht);
            System.out.println("insert");

            prep1.executeUpdate();
            prep1.close();

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * la méthode permet de supprimer un produit liée à un projet
     * @param idProduitProjet : id du produit projet
     */

        public void deleteProductToProject(String idProduitProjet) {
        String requestDeleteProductToProject = "DELETE FROM produit_projet " +
                " WHERE id = ?";

        try {
            prep1 = connexion.connect().prepareStatement(requestDeleteProductToProject);
            prep1.setString(1, idProduitProjet);
            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert");

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * la méthode permet de supprimer un projet
     * @param idProduitProjet : id du produit projet
     */


    public void deleteProject(String idProduitProjet) {
        String requestDeleteProductToProject = "DELETE FROM projet " +
                " WHERE id = ?";

        try {
            prep1 = connexion.connect().prepareStatement(requestDeleteProductToProject);
            prep1.setString(1, idProduitProjet);
            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert");

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * la méthode permet d'éditer un projet déja existant
     * @param idProject : id du projet
     * @param idProduct : id du produit
     * @param largeur : largeur du produit
     * @param longueur : longueur du produit
     * @param epaisseur : epaisseur du produit
     * @param prix_ht : prix hors taxe
     */

    public void editProduct(String idProject, String idProduct, String largeur, String longueur, String epaisseur, String prix_ht){
        String requestnewProject = "UPDATE produit_projet \n" +
                "SET id_projet = ?, id_produit = ?, largeur_totale = ?, longueur_totale = ?, epaisseur_totale = ?, prix_ht = ? " +
                "WHERE id = ?";

        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert ");

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    /**
     * La requête permet d'afficher tout les devis de l'utilisateur
     * @return : retourne une liste contenant le nom produit et le prix
     */

    public List<String> DisplayDevisUser(){
        JSonReader register = new JSonReader();
        List<String> loginRegister = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String displayP = "SELECT P.nom_produit, PP.prix_ht " +
                "FROM produit_projet as PP " +
                "LEFT JOIN produit as P ON P.id=PP.id_produit " +
                "LEFT JOIN projet ON projet.id=PP.id_projet  " +
                "LEFT JOIN utilisateur as U ON U.id=projet.id_utilisateur " +
                " WHERE U.id=? ";

        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, loginRegister.get(2));

            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();
            return values;


        } catch (Exception e) {
            return null;
        }
    }


    /**
     * La requête permet d'afficher tout les devis de tout les utilisateurs
     * @return : retourne une liste contenant le nom produit et le prix
     */

    public List<String> DisplayDevisAdmin(){
        JSonReader register = new JSonReader();
        List<String> loginRegister = register.readFileLoginSession("src/main/java/com/company/guijava/userSession.json");

        String displayP = "SELECT P.nom_produit, PP.prix_ht " +
                "FROM produit_projet as PP " +
                "LEFT JOIN produit as P ON P.id=PP.id_produit " +
                "LEFT JOIN projet ON projet.id=PP.id_projet  " +
                "LEFT JOIN utilisateur as U ON U.id=projet.id_utilisateur ";

        try {
            prep1 = connexion.connect().prepareStatement(displayP, ResultSet.TYPE_SCROLL_SENSITIVE);
            prep1.setString(1, loginRegister.get(2));

            ResultSet result = prep1.executeQuery();
            List<String> values = request.seeRequest(result);
            prep1.close();
            return values;


        } catch (Exception e) {
            return null;
        }
    }

    public void newProduct (String name_product) {

        String requestnewProduct = "INSERT INTO produit (nom_produit,date_ajout) " +
                "VALUES (?,?)";

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        try {
            prep1 = connexion.connect().prepareStatement(requestnewProduct);
            prep1.setString(1, name_product);
            prep1.setDate(2, date);

            prep1.executeUpdate();
            prep1.close();

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

    public void deleteProduct(String nameProduct) {
        String requestDeleteProduct = "DELETE FROM produit " +
                " WHERE nom_produit = ?";

        try {
            prep1 = connexion.connect().prepareStatement(requestDeleteProduct);
            prep1.setString(1, nameProduct);
            prep1.executeUpdate();
            prep1.close();
            System.out.println("insert");

        } catch (Exception e) {
            System.out.println("not insert");
        }
    }

}
