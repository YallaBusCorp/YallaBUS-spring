package com.alphaq.yallabusserver.dto;

public class LkTownDTO {
    private Integer id;
    private String townName;
    private CompanyDTO company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "LkTownDTO{" +
                "id=" + id +
                ", townName='" + townName + '\'' +
                ", company=" + company +
                '}';
    }
}
