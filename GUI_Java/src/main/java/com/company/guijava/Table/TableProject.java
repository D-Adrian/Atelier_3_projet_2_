package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like project name, creation date,
 * project description, end date
 */
public class TableProject implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableProject constructor, used to set all the column values of our table
     * @param nom_projet project name
     * @param date_creation creation date
     * @param description_projet project description
     * @param date_fin end date
     */
    public TableProject(String id_projet, String nom_projet, String date_creation, String description_projet, String date_fin) {
        super();

        this.listValues.add(id_projet);
        this.listValues.add(nom_projet);
        this.listValues.add(date_creation);
        this.listValues.add(description_projet);
        this.listValues.add(date_fin);
    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
