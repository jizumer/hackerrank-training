package com.jizumer.icecreamparlor;

import com.jizumer.Runner;
import javafx.util.Pair;

import java.io.IOException;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/
 */
public class IceCreamParlorRunner implements Runner {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String[] args) throws IOException {

        int [] cost = {4, 3, 2, 5, 7};
        whatFlavors(cost, 8);
    }


    private void whatFlavors(int[] cost, int money) {

        Optional<Pair<Integer, OptionalInt>> resultPair = IntStream.range(0, cost.length - 1).mapToObj(i -> {

            return new Pair<>(i, IntStream.range(i + 1, cost.length).filter(j -> {
                return cost[i] + cost[j] == money;
            }).findAny());

        }).filter(pair -> {
            return pair.getValue().isPresent();
        }).findAny();
        System.out.println((resultPair.get().getKey() + 1) + " " + (resultPair.get().getValue().getAsInt() + 1));

    }

}

