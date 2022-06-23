package com.alphaq.yallabusserver;

import com.alphaq.yallabusserver.service.CompanyService;
import com.alphaq.yallabusserver.service.LkTownService;
import com.alphaq.yallabusserver.service.LkUniversityService;
import com.alphaq.yallabusserver.service.StudentService;
import com.alphaq.yallabusserver.entity.Company;
import com.alphaq.yallabusserver.entity.LkTown;
import com.alphaq.yallabusserver.entity.LkUniversity;
import com.alphaq.yallabusserver.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

//@SpringBootTest
class YallaBusServerApplicationTests {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private LkTownService lkTownService;
    @Autowired
    private LkUniversityService lkUniversityService;
    @Autowired
    private StudentService studentService;

    //@Test
    void contextLoads() {
    }

    //@Test
    void addCompany() {
        Company company = new Company();
        company.setCompanyName("sarkees");
        companyService.save(company);
    }

    //@Test
    void getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        System.out.println(companies);
    }

    //@Test
    void addLKTown() {
        long company_id = 1;
        LkTown lkTown = new LkTown();
        Company company = new Company();
        int count = lkTownService.getCount();
        List<Company> companies = companyService.getAllCompanies();
        for (Company element : companies) {
            if (element.getId() == company_id) {
                company = element;
                break;
            }
        }
        lkTown.setId(++count);
        lkTown.setCompany(company);
        lkTown.setTownName("طنامل");
        lkTownService.save(lkTown);
    }

    //@Test
    void getAllLkTowns() {
        List<LkTown> lkTowns = lkTownService.getAllLkTowns();
        System.out.println(lkTowns);
    }

    //@Test
    void getTownByTownIdAndCompanyId(){
        LkTown lkTown = new LkTown();
        lkTown.setId(1);
        lkTown = lkTownService.checkExistenceTownInCompany(lkTown,1);
        System.out.println(lkTown);

    }

    //@Test
    void addLkUniversity() {
        int company_id = 2;
        LkUniversity lkUniversity = new LkUniversity();
        Company company = new Company();
        company.setId(company_id);
        company = companyService.getCompanyById(company_id);
        lkUniversity.setCompany(company);
        lkUniversity.setUniversityName("النيل");
        lkUniversityService.save(lkUniversity);
    }

    //@Test
    void getAllLkUniversities() {
        List<LkUniversity> lkUniversities = lkUniversityService.getAllLkUniversities();
        System.out.println(lkUniversities);
    }

    //@Test
    void getUniversityByUniversityIdAndCompanyId(){
        LkUniversity lkUniversity = new LkUniversity();
        lkUniversity.setId(4);
        lkUniversity = lkUniversityService.checkExistenceUniversityInCompany(lkUniversity,2);
        System.out.println(lkUniversity);

    }

    //@Test
//    void addStudent() {
//        long company_id = 1;
//        long town_id = 2;
//        long university_id = 1;
//        Student student = new Student();
//        Company company = new Company();
//        LkTown lkTown = new LkTown();
//        LkUniversity lkUniversity = new LkUniversity();
//        int count = studentService.getCount();
//        List<Company> companies = companyService.getAllCompanies();
//        for (Company element : companies) {
//            if (element.getId() == company_id) {
//                company = element;
//                break;
//            }
//        }
//        List<LkTown> lkTowns = lkTownService.getAllLkTowns();
//        for (LkTown element : lkTowns) {
//            if (element.getId() == town_id) {
//                lkTown = element;
//                break;
//            }
//        }
//        List<LkUniversity> lkUniversities = lkUniversityService.getAllLkUniversities();
//        for (LkUniversity element : lkUniversities) {
//            if (element.getId() == university_id) {
//                lkUniversity = element;
//                break;
//            }
//        }
//        student.setId(++count);
//        student.setStdName("مصطفي ابراهيم عبدالباسط");
//        student.setStdPhone("01067893079");
//        student.setTown(lkTown);
//        student.setUniversity(lkUniversity);
//        student.setCompany(company);
//        student.setEndSubscriptionDate(LocalDate.now().plusDays(30));
//        student.setIsSubscribed(true);
//        studentService.save(student);
//    }

    //@Test
    void getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        System.out.println(students);
    }



}
