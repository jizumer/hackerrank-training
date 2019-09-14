package com.jizumer.stringpermutation;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPermutationRunner implements Runner {
    @Override
    public void run(String[] args) throws IOException {
        String s1 = "dogss";
        String s2 = "gsosd";
        System.out.println(String.format("Result for %s and %s is %s", s1, s2, isPermutation(s1, s2)));
        String s3 = "tear";
        String s4 = "rate";
        System.out.println(String.format("Result for %s and %s is %s", s3, s4, isPermutation(s3, s4)));
        String s5 = "calabria";
        String s6 = "calbria";
        System.out.println(String.format("Result for %s and %s is %s", s5, s6, isPermutation(s5, s6)));
    }

    public Boolean isPermutation(final String s1, final String s2) {

        Function<String, String> classifier = (String character) -> {
            return character;
        };

        Map<String, Long> groupByCountS1 = groupByCountCharactersInString(s1);
        Map<String, Long> groupByCountS2 = groupByCountCharactersInString(s2);
        return checkCounterMaps(groupByCountS1, groupByCountS2);

    }


    private Map<String, Long> groupByCountCharactersInString(String s1) {
        return Arrays.asList(s1.split(""))
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


    private Boolean checkCounterMaps(Map<String, Long> grouByCount1, Map<String, Long> grouByCount2) {

        if (grouByCount1.size() != grouByCount2.size()) {

            return Boolean.FALSE;

        }

        for (String character : grouByCount1.keySet()) {

            if (!grouByCount2.containsKey(character)

                    || !grouByCount2.get(character).equals(grouByCount1.get(character))) {

                return Boolean.FALSE;

            }

        }

        return Boolean.TRUE;

    }
}
