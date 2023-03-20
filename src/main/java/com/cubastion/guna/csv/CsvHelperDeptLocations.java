package com.cubastion.guna.csv;

import com.cubastion.guna.entity.DeptLocations;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperDeptLocations {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"dnumber", "dlocation"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<DeptLocations> csvToDeptLocation(InputStream is) {
        List<DeptLocations> deptLocationsList;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            deptLocationsList = new ArrayList<DeptLocations>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                DeptLocations dept = new DeptLocations();
                dept.setDnumber(Integer.valueOf(csvRecord.get("dnumber")));
                dept.setDlocation(csvRecord.get("dlocation"));

                deptLocationsList.add(dept);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return deptLocationsList;
    }
}
