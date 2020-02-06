package com.jizumer.journeytomoon;

import com.jizumer.Runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JourneyToMoonRunner implements Runner {
    private static final Scanner scanner = new Scanner(System.in);

    private static class AstronautsPerCountryResult {
        List<Integer> numberOfAstronautsPerCountry;
        int numberOfNotProposedAstronauts;
    }

    private static AstronautsPerCountryResult astronautsPerCountry(int[][] astronaut, int numberOfAstronauts) {

        List<List<Integer>> nationalities = new ArrayList<>(numberOfAstronauts);
        int n = astronaut.length;
        for (int i = 0; i < n; i++) {
            List<Integer> countryOfFirstAstronaut = countryOfAstronaut(nationalities, astronaut[i][0]);
            List<Integer> countryOfSecondAstronaut = countryOfAstronaut(nationalities, astronaut[i][1]);

            if (!countryOfFirstAstronaut.equals(countryOfSecondAstronaut)) {
                mergeCountries(nationalities, countryOfFirstAstronaut, countryOfSecondAstronaut);
            }
        }
        List<Integer> numberOfAstronautsPerCountry = new ArrayList<>(numberOfAstronauts - 1);
        int differentProposedAstronauts = 0;
        for (List<Integer> country : nationalities) {
            int astronautsInThisCountry = country.size();
            differentProposedAstronauts += astronautsInThisCountry;
            numberOfAstronautsPerCountry.add(astronautsInThisCountry);
        }

        AstronautsPerCountryResult result = new AstronautsPerCountryResult();
        result.numberOfAstronautsPerCountry = numberOfAstronautsPerCountry;
        result.numberOfNotProposedAstronauts = numberOfAstronauts - differentProposedAstronauts;

        return result;

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
    static int journeyToMoon(int n, int[][] astronaut) {
        AstronautsPerCountryResult astronautsPerCountryResult = astronautsPerCountry(astronaut, n);

        List<Integer> astronautsPerCountry = astronautsPerCountryResult.numberOfAstronautsPerCountry;
        System.out.println("{" + astronautsPerCountryResult.numberOfAstronautsPerCountry.size() + "," + astronautsPerCountryResult.numberOfNotProposedAstronauts + "}");
        int numberOfCountries = astronautsPerCountry.size();
        int pairs = 0;
        for (int i = 0; i < numberOfCountries - 1; i++) {
            for (int j = i + 1; j < numberOfCountries; j++) {
                System.out.print(pairs + "+=" + astronautsPerCountry.get(i) + "*"+ astronautsPerCountry.get(j)+ " = ");
                pairs += astronautsPerCountry.get(i) * astronautsPerCountry.get(j);
                System.out.println(pairs);
            }
        }

        for(int i = 0 ; i < numberOfCountries; i++){
            //count the not-proposed astronauts
            System.out.println("Count not propossed");
            System.out.print(pairs + "+=" + astronautsPerCountry.get(i) + "*"+ astronautsPerCountryResult.numberOfNotProposedAstronauts+ " = ");
            pairs += astronautsPerCountry.get(i) * astronautsPerCountryResult.numberOfNotProposedAstronauts;
            System.out.println(pairs);
        }
        if(astronautsPerCountryResult.numberOfNotProposedAstronauts > 1) {
            pairs += (astronautsPerCountryResult.numberOfNotProposedAstronauts - 1);
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
