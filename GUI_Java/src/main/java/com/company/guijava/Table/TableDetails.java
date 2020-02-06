package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a Product-Project, like id product_project, project id, product id,
 * width, height, thickness, price, tva
 */
public class TableDetails implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableDetails constructor, used to set all the column values of our table
     * @param id id product_project
     * @param id_projet project id
     * @param id_produit product id
     * @param largeur_totale width
     * @param longueur_totale height
     * @param epaisseur_totale thickness
     * @param prix_ht price
     * @param tva tva
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