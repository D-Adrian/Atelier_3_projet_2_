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

    // CHAQUE REQUETE, MET LES DANS DES METHODES DIFFERENTES


    private Connexion connexion = new Connexion();
    private RequestReader request = new RequestReader();
    private PreparedStatement prep1 = null;


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

    public List<String> selectIdMaterial(String materialName) {
        String requestnewProject = "SELECT id, prix_m2_ht*(tva/100+1) FROM materiau WHERE nom_materiau=?";

        try {
            prep1 = connexion.connect().prepareStatement(requestnewProject);
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
}
