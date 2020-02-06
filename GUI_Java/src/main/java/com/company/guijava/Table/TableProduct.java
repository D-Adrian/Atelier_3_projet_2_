package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about leroy merlu product, like product name and creation date
 */
public class TableProduct implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableProduct constructor, used to set all the column values of our table
     * @param nom_produit product name
     * @param date_ajout creation date
     */
    public TableProduct(String nom_produit, String date_ajout) {
        super();

        this.listValues.add(nom_produit);
        this.listValues.add(date_ajout);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}

