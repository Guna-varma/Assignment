package com.cubastion.guna.csv;

import com.cubastion.guna.entity.Department;
import com.cubastion.guna.entity.WorksOn;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CsvHelperWorksOn {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"essn","pno","hours"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<WorksOn> csvToWorksOn(InputStream is) {
        List<WorksOn> worksOnList;
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            worksOnList = new ArrayList<WorksOn>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                WorksOn worksOn = new WorksOn();
                worksOn.setEssn(csvRecord.get("essn"));
                worksOn.setPno(Integer.valueOf(csvRecord.get("pno")));
                worksOn.setHours(Double.valueOf((csvRecord.get("hours"))));

                worksOnList.add(worksOn);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return worksOnList;
    }

}