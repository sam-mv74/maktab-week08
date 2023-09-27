package ir.maktab101.hw08.domain;

import ir.maktab101.hw08.base.domain.BaseEntity;

public class Category extends BaseEntity {

    public static final String TABLE_NAME = "category_tbl";

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
