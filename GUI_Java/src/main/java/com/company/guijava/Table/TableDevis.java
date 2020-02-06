package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a Quote, like project name, creation date,
 * project description, end date
 */
public class TableDevis implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableDevis constructor, used to set all the column values of our table
     * @param Designation quote name
     * @param Price price
     */
    public TableDevis(String Designation, String Price) {
        super();

        this.listValues.add(Designation);
        this.listValues.add(Price);

    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}