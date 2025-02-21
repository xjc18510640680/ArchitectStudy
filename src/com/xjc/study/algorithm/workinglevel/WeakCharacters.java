package com.xjc.study.algorithm.workinglevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WeakCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int[][] properties = null;

        try {
            n = Integer.parseInt(br.readLine());
            properties = new int[n][2];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                properties[i][0] = Integer.parseInt(st.nextToken()); // attack
                properties[i][1] = Integer.parseInt(st.nextToken()); // defense
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.err.println("Invalid input format: " + e.getMessage());
            return;
        }

        // Sort by attack in descending order, if same, sort by defense in ascending order.
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));

        int maxDefense = 0;
        int weakCount = 0;

        for (int[] property : properties) {
            if (property[1] < maxDefense) {
                weakCount++;
            } else {
                maxDefense = property[1];
            }
        }

        System.out.println(weakCount);
    }
}