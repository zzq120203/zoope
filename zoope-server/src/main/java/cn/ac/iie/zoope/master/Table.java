package cn.ac.iie.zoope.master;

import java.util.List;

public class Table {

    private String database;

    private String name;

    private List<FieldStruct> fields;

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FieldStruct> getFields() {
        return fields;
    }

    public void setFields(List<FieldStruct> fields) {
        this.fields = fields;
    }
}
