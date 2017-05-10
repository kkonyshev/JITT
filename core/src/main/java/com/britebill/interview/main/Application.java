package com.britebill.interview.main;

import com.britebill.interview.transformers.TransformerData;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {

    public static void main (String []args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context/context.xml");
        FileDataReader fileDataReader = (FileDataReader) context.getBean("fileDataReader");

        List<String> data = fileDataReader.readData();
        TransformerData transformerData = (TransformerData) context.getBean("transformerData");
        List<String> transformedData = transformerData.transformData(data);

        transformedData.stream().forEach(d -> System.out.println (d));
    }
}
