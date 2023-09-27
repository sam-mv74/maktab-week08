package ir.maktab101.hw08.domain;

import ir.maktab101.hw08.base.domain.BaseEntity;

import java.sql.Date;
import java.time.ZonedDateTime;

public class Product extends BaseEntity {
    public static final String TABLE_NAME = "product_tbl";

    public static final String NAME = "name";
    public static final String CREATE_DATE = "create_date";
    public static final String CATEGORY_ID = "category_id";
    public static final String BRAND_ID = "brand_id";
    private String name;
    private String createDate;
    private Category category;
    private Brand brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDate() {
        this.createDate=java.time.LocalDate.now().toString();
       return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
