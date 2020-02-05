package com.jizumer.journeytomoon;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.*;

public class JourneyToMoonRunner implements Runner {
    private static final Scanner scanner = new Scanner(System.in);

    private static int[] astronautsPerCountry(int[][] astronaut, int numberOfAstronauts) {

        List<List<Integer>> nationalities = new ArrayList<>(numberOfAstronauts);
        int n = astronaut.length;
        for (int i = 0; i < n; i++) {
            List<Integer> countryOfFirstAstronaut = countryOfAstronaut(nationalities, astronaut[i][0]);
            List<Integer> countryOfSecondAstronaut = countryOfAstronaut(nationalities, astronaut[i][1]);
            mergeCountries(nationalities, countryOfFirstAstronaut, countryOfSecondAstronaut);
        }
        int[] numberOfAstronautsPerCountry = new int[nationalities.size()];
        int i = 0;
        for (List<Integer> country : nationalities) {
            numberOfAstronautsPerCountry[i] = country.size();
            i++;
        }
        return numberOfAstronautsPerCountry;

    }

    private static List<Integer> countryOfAstronaut(List<List<Integer>> nationalities, int i) {
        List<Integer> country = null;
        for (List<Integer> nationality : nationalities) {
            if (nationality.contains(i)) {
                country = nationality;
            }
        }
        if (country == null) {
            country = new ArrayList<Integer>();
            country.add(Integer.valueOf(i));
            nationalities.add(country);
        }
        return country;
    }

    private static void mergeCountries(List<List<Integer>> nationalities, List<Integer> countryOfFirstAstronaut, List<Integer> countryOfSecondAstronaut) {
        countryOfFirstAstronaut.addAll(countryOfSecondAstronaut);
        nationalities.remove(countryOfSecondAstronaut);
    }


    // Complete the journeyToMoon function below.
    int journeyToMoon(int n, int[][] astronaut) {
        int[] astronautsPerCountry = astronautsPerCountry(astronaut, n);
        int numberOfCountries = astronautsPerCountry.length;
        int pairs = 0;
        for (int i = 0; i < numberOfCountries - 1; i++) {
            for (int j = i + 1; j < numberOfCountries; j++) {
                pairs += astronautsPerCountry[i] * astronautsPerCountry[j];
            }
        }
        return pairs;
    }

    @Override
    public void run(String[] args) throws IOException {


        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        int result = journeyToMoon(n, astronaut);


        scanner.close();
    }


}
