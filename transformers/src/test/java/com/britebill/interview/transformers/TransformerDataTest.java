package com.britebill.interview.transformers;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * Created by Konstantin Konyshev on 10/05/2017.
 */
public class TransformerDataTest {

    TransformerData transformerData;

    @Before
    public void init() {
        this.transformerData = new TransformerData();
    }

    @Test
    public void test_specialCharactersIgnored() {
        List<String> src = Arrays.asList("AB", ",", "{A", "C+");
        List<String> out = transformerData.transformData(src);
        assertThat(out).containsExactly("AB");
    }

    @Test
    public void test_removeRepeatedWords() {
        List<String> src = Arrays.asList("B", "A", "A", "A");
        List<String> out = transformerData.transformData(src);
        assertThat(out).containsExactly("B", "A");
    }

    @Test
    public void test_sortByLength() {
        List<String> src = Arrays.asList("ACC", "A", "CA");
        List<String> out = transformerData.transformData(src);
        assertThat(out).containsExactly("A", "CA", "ACC");
    }

    @Test
    public void test_uppercase() {
        List<String> src = Arrays.asList("acc", "A", "cA");
        List<String> out = transformerData.transformData(src);
        assertThat(out).containsExactly("A", "CA", "ACC");
    }
}
