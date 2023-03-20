package com.cubastion.guna.csv;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Employee;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperDepartment {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"dname","dnumber","mgrssn","mgrstartdate"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Department> csvToDepartment(InputStream is) {
        List<Department> departmentList;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            departmentList = new ArrayList<Department>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Department department = new Department();
                department.setDnumber(Integer.valueOf(csvRecord.get("dnumber")));
                department.setDname(csvRecord.get("dname"));
                department.setMgrssn((csvRecord.get("mgrssn")));
                department.setMgrstartdate(csvRecord.get("mgrstartdate"));

                departmentList.add(department);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return departmentList;
    }
}
