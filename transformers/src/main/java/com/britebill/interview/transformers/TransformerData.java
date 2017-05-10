package com.britebill.interview.transformers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TransformerData bean
 */
public class TransformerData {

    /**
     * 1) convert every element of input list to uppercase
     * 2) sort list by word length
     * 3) removes duplicates
     * 4) elements with characters are filtered out
     *
     * @param src input list of words
     * @return
     */
    public List<String> transformData (List<String> src) {
        if (src==null) {
            return new ArrayList<>();
        }

        return src.stream()
                .filter(word->word.chars().mapToObj(i -> (char) i).allMatch(Character::isAlphabetic))
                .map(word->word.toUpperCase())
                .sorted(Comparator.comparingInt(String::length))
                .distinct()
                .collect(Collectors.toList());
    }
}
