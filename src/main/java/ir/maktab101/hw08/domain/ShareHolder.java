package ir.maktab101.hw08.domain;

import ir.maktab101.hw08.base.domain.BaseEntity;

public class ShareHolder extends BaseEntity {

    public static final String TABLE_NAME = "shareholder_tbl";

    public static final String FULL_NAME = "full_name";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String NATIONAL_CODE = "national_code";
    private String fullName;
    private String phoneNumber;
    private String nationalCode;
    private Brand[] brands;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Brand[] getBrands() {
        return brands;
    }

    public void setBrands(Brand[] brands) {
        this.brands = brands;
    }
}
