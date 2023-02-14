package ru.otus.spring.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.*;

public class TestLauncherServiceImpl implements TestLauncherService {

    private final static String CSV_SEPARATOR = ",";
    private final static String LINE_SEPARATOR = " ";

    private String testName;

    private Resource test;

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }

    @Override
    public void getResource() {
        test = new ClassPathResource(testName);
    }

    @Override
    public void launchTest() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(test.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] line;
            while (reader.ready()) {
                line = reader.readLine().split(CSV_SEPARATOR);
                writer.write(String.join(LINE_SEPARATOR, line));
                writer.write("\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}