package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like project name, creation date,
 * project description, end date
 */
public class TableDetails implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableProject constructor, used to set all the column values of our table
     * @param id_projet project name
     * @param id_produit creation date
     * @param largeur_totale creation date
     * @param longueur_totale creation date
     * @param epaisseur_totale creation date
     * @param prix_ht creation date
     * @param tva creation date
     */
    public TableDetails(String id, String id_projet, String id_produit, String largeur_totale, String longueur_totale, String epaisseur_totale, String prix_ht, String tva) {
        super();

        this.listValues.add(id);
        this.listValues.add(id_projet);
        this.listValues.add(id_produit);
        this.listValues.add(largeur_totale);
        this.listValues.add(longueur_totale);
        this.listValues.add(epaisseur_totale);
        this.listValues.add(prix_ht);
        this.listValues.add(tva);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}