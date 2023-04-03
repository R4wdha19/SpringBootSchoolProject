package com.codeline.SpringBootPractice.School.project.Service;


import com.codeline.SpringBootPractice.School.project.Model.School;
import com.codeline.SpringBootPractice.School.project.Repository.SchoolRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    @Autowired
    private SchoolRepository schoolRepository;

    public static final String pathToReports = "\"C:\\Users\\user013\\Downloads\\Reports\"";
    public String generateReport() throws FileNotFoundException, JRException {
        List<School> schoolList = schoolRepository.getAllSchools();
        File file = ResourceUtils.getFile("classpath:FirstProjectFile.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(schoolList);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("CreatedBy", "R");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters , dataSource);  //fillReport combine it all
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports+"\\schools.pdf");
        return "Report generated : " + pathToReports+"\\schools.pdf";
    }
}
