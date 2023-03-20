package com.cubastion.guna.csv;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Project;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperProject {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"pnumber","pname","plocation","dnum"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Project> csvToProject(InputStream is) {
        List<Project> projectList;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            projectList = new ArrayList<Project>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Project project = new Project();
                project.setPnumber(Integer.valueOf(csvRecord.get("pnumber")));
                project.setPname(csvRecord.get("pname"));
                project.setPlocation((csvRecord.get("plocation")));
                project.setDnum(Integer.valueOf(csvRecord.get("dnum")));

                projectList.add(project);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return projectList;
    }
}
