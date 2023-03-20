package com.cubastion.guna.csv;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.Dependent;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperDependant {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"essn","dependent_name","sex","bdate","relationship"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Dependent> csvToDependent(InputStream is) {
        List<Dependent> dependentList;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            dependentList = new ArrayList<Dependent>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Dependent dependent = new Dependent();
                dependent.setEssn(csvRecord.get("essn"));
                dependent.setDependent_name(csvRecord.get("dependent_name"));
                dependent.setSex((csvRecord.get("sex")));
                dependent.setBdate(csvRecord.get("bdate"));
                dependent.setRelationship(csvRecord.get("relationship"));

                dependentList.add(dependent);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dependentList;
    }
}