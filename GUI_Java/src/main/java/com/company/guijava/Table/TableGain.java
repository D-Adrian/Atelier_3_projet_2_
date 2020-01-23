package com.company.guijava.Table;


import com.company.guijava.ITable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create a line of a table containing information about a cargo, like project name, creation date,
 * project description, end date
 */
public class TableGain implements ITable {
    private List<String> listValues = new ArrayList<>();

    /**
     *  TableProject constructor, used to set all the column values of our table
     * @param mois project name
     * @param gain creation date
     */
    public TableGain(String mois, String gain) {
        super();

        this.listValues.add(mois);
        this.listValues.add(gain);
    }

    /**
     * This method get the list of the values we've add
     * @return      List : list of the added values
     */
    public List<String> getListValues() {
        return listValues;
    }


}
