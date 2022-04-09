package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.dao.CompanyDAO;
import com.alphaq.yallabusserver.dao.LkTownDAO;
import com.alphaq.yallabusserver.dao.LkUniversityDAO;
import com.alphaq.yallabusserver.dao.StudentDAO;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class YallaBusServerApplicationTests {

    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private LkTownDAO lkTownDAO;
    @Autowired
    private LkUniversityDAO lkUniversityDAO;
    @Autowired
    private StudentDAO studentDAO;

    //@Test
    void contextLoads() {
    }

    //@Test
    void addCompany() {
        Company company = new Company();
        company.setCompanyName("sarkees");
        companyDAO.save(company);
    }

    //@Test
    void getAllCompanies() {
        List<Company> companies = companyDAO.getAllCompanies();
        System.out.println(companies);
    }

    //@Test
    void addLKTown() {
        long company_id = 1;
        LkTown lkTown = new LkTown();
        Company company = new Company();
        int count = lkTownDAO.getCount();
        List<Company> companies = companyDAO.getAllCompanies();
        for (Company element : companies) {
            if (element.getId() == company_id) {
                company = element;
                break;
            }
        }
        lkTown.setId(++count);
        lkTown.setCompany(company);
        lkTown.setTownName("طنامل");
        lkTownDAO.save(lkTown);
    }

    //@Test
    void getAllLkTowns() {
        List<LkTown> lkTowns = lkTownDAO.getAllLkTowns();
        System.out.println(lkTowns);
    }

    //@Test
    void addLkUniversity() {
        long company_id = 1;
        LkUniversity lkUniversity = new LkUniversity();
        Company company = new Company();
        int count = lkUniversityDAO.getCount();
        List<Company> companies = companyDAO.getAllCompanies();
        for (Company element : companies) {
            if (element.getId() == company_id) {
                company = element;
                break;
            }
        }
        lkUniversity.setId(++count);
        lkUniversity.setCompany(company);
        lkUniversity.setUniversityName("المنصورة");
        lkUniversityDAO.save(lkUniversity);
    }

    //@Test
    void getAllLkUniversities() {
        List<LkUniversity> lkUniversities = lkUniversityDAO.getAllLkUniversities();
        System.out.println(lkUniversities);
    }

    //@Test
    void addStudent() {
        long company_id = 1;
        long town_id = 2;
        long university_id = 1;
        Student student = new Student();
        Company company = new Company();
        LkTown lkTown = new LkTown();
        LkUniversity lkUniversity = new LkUniversity();
        int count = studentDAO.getCount();
        List<Company> companies = companyDAO.getAllCompanies();
        for (Company element : companies) {
            if (element.getId() == company_id) {
                company = element;
                break;
            }
        }
        List<LkTown> lkTowns = lkTownDAO.getAllLkTowns();
        for (LkTown element : lkTowns) {
            if (element.getId() == town_id) {
                lkTown = element;
                break;
            }
        }
        List<LkUniversity> lkUniversities = lkUniversityDAO.getAllLkUniversities();
        for (LkUniversity element : lkUniversities) {
            if (element.getId() == university_id) {
                lkUniversity = element;
                break;
            }
        }
        student.setId(++count);
        student.setStdName("مصطفي ابراهيم عبدالباسط");
        student.setStdPhone("01067893079");
        student.setTown(lkTown);
        student.setUniversity(lkUniversity);
        student.setCompany(company);
        student.setEndSubscriptionDate(LocalDate.now().plusDays(30));
        student.setIsSubscribed(true);
        studentDAO.save(student);
    }

    //@Test
    void getAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        System.out.println(students);
    }

}
