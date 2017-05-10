package com.britebill.interview.main;

import com.britebill.interview.transformers.TransformerData;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 *
 * Created by Konstantin Konyshev on 10/05/2017.
 */
public class ApplicationTest {

    ApplicationContext context;

    @Before
    public void init() {
         this.context = new ClassPathXmlApplicationContext("context/context.xml");

    }

    @Test
    public void test_springContext() {
        FileDataReader fileDataReader = context.getBean(FileDataReader.class);
        assertThat(fileDataReader).isNotNull();

        TransformerData transformerData = context.getBean(TransformerData.class);
        assertThat(transformerData).isNotNull();
    }

    @Test
    public void test_fileRead() {
        FileDataReader fileDataReader = context.getBean(FileDataReader.class);

        List<String> lines = fileDataReader.readData("/data/test_data.example");
        assertThat(lines).containsExactly("LINE1", "A", "B");
    }
}
