package com.alphaq.yallabusserver.dto;

public class LkUniversityDTO {
    private Integer id;
    private String universityName;
    private CompanyDTO company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "LkUniversityDTO{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                ", company=" + company +
                '}';
    }
}
