package com.company.guijava.RequestSQL;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe sert à lire les requêtes
 */

public class RequestReader {

    public RequestReader() {
    }

    /**
     * Permet de lire la requête
     * @param results : resultat de la requête
     * @return : retourne l'ensemble des valeurs obtenu
     */

    public List<String> seeRequest(ResultSet results) {
        ArrayList values = new ArrayList();

        try {
            ResultSetMetaData md = results.getMetaData();
            int columnCount = md.getColumnCount();

            while(results.next()) {
                for(int columnIndex = 1; columnIndex <= columnCount; ++columnIndex) {
                    String columnName = md.getColumnName(columnIndex);
                    String value = results.getString(columnIndex);
                    System.out.println(columnName + ":  " + value);
                    values.add(value);
                }
            }

            return values;
        } catch (Exception var8) {
            System.out.println("connexion to database failed =>  " + var8);
            return null;
        }
    }
}