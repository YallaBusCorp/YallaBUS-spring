package com.alphaq.yallabusserver.dto;

import java.util.Objects;
import java.util.Set;

public class CompanyDTO {
    private Integer id;
    private String companyName;
    private String companyPhone;
    private String description;
    private String companyLocation;
    private String imgURL;
    private String facebookURL;
    private Set<StudentDTO> students;
    private Set<LkTownDTO> lkTowns;
    private Set<LkUniversityDTO> lkUniversities;
    private Set<EmployeeDTO> employees;
    private Set<AppointmentDTO> appointments;

    public CompanyDTO() {
    }

    public CompanyDTO(Integer id, String companyName, String companyPhone, String description, String companyLocation, String imgURL, String facebookURL, Set<StudentDTO> students, Set<LkTownDTO> lkTowns, Set<LkUniversityDTO> lkUniversities, Set<EmployeeDTO> employees, Set<AppointmentDTO> appointments) {
        this.id = id;
        this.companyName = companyName;
        this.companyPhone = companyPhone;
        this.description = description;
        this.companyLocation = companyLocation;
        this.imgURL = imgURL;
        this.facebookURL = facebookURL;
        this.students = students;
        this.lkTowns = lkTowns;
        this.lkUniversities = lkUniversities;
        this.employees = employees;
        this.appointments = appointments;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public void setStudents(Set<StudentDTO> students) {
        this.students = students;
    }

    public void setLkTowns(Set<LkTownDTO> lkTowns) {
        this.lkTowns = lkTowns;
    }

    public void setLkUniversities(Set<LkUniversityDTO> lkUniversities) {
        this.lkUniversities = lkUniversities;
    }

    public void setEmployees(Set<EmployeeDTO> employees) {
        this.employees = employees;
    }


    public void setAppointments(Set<AppointmentDTO> appointments) {
        this.appointments = appointments;
    }

    public Integer getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public String getDescription() {
        return description;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public Set<StudentDTO> getStudents() {
        return students;
    }

    public Set<LkTownDTO> getLkTowns() {
        return lkTowns;
    }

    public Set<LkUniversityDTO> getLkUniversities() {
        return lkUniversities;
    }

    public Set<EmployeeDTO> getEmployees() {
        return employees;
    }


    public Set<AppointmentDTO> getAppointments() {
        return appointments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyDTO that = (CompanyDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(companyName, that.companyName) && Objects.equals(companyPhone, that.companyPhone) && Objects.equals(description, that.description) && Objects.equals(companyLocation, that.companyLocation) && Objects.equals(imgURL, that.imgURL) && Objects.equals(facebookURL, that.facebookURL) && Objects.equals(students, that.students) && Objects.equals(lkTowns, that.lkTowns) && Objects.equals(lkUniversities, that.lkUniversities) && Objects.equals(employees, that.employees)  && Objects.equals(appointments, that.appointments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, companyPhone, description, companyLocation, imgURL, facebookURL, students, lkTowns, lkUniversities, employees, appointments);
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", description='" + description + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", imgURL='" + imgURL + '\'' +
                ", facebookURL='" + facebookURL + '\'' +
                ", students=" + students +
                ", lkTowns=" + lkTowns +
                ", lkUniversities=" + lkUniversities +
                ", employees=" + employees +
                ", appointments=" + appointments +
                '}';
    }
}
