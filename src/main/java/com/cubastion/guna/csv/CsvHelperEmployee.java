package com.cubastion.guna.csv;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Employee;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperEmployee {
    public static String TYPE = "text/csv";
    static String[] HEADERs = {"fname", "minit", "lname", "bdate", "address", "sex", "salary", "superssn", "dno"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Employee> csvToEmployee(InputStream is) {
        List<Employee> employees;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            employees = new ArrayList<Employee>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Employee employee = new Employee();
                employee.setAddress(csvRecord.get("address"));
                employee.setBdate(csvRecord.get("bdate"));
                employee.setDno(Integer.valueOf(csvRecord.get("dno")));
                employee.setLname(csvRecord.get("lname"));
                employee.setFname(csvRecord.get("fname"));
                employee.setMinit(csvRecord.get("minit"));
                employee.setSalary(Double.valueOf(csvRecord.get("salary")));
                employee.setSsn(csvRecord.get("superssn"));

                employees.add(employee);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }


}