package com.xjc.study.algorithm.test;

import java.util.*;

public class HighFrequencyInterface {
        public static List<Integer> findHighFrequencyInterfaces(List<List<Integer>> invokes, int timeSegment, int minLimits) {
            Map<Integer, Integer> interfaceCounts = new HashMap<>();
            Map<Integer, List<List<Integer>>> timeWindowInvokes = new HashMap<>();
            List<Integer> highFrequencyInterfaces = new ArrayList<>();

            // Step 2: Traverse the call records and update the counts
            for (List<Integer> invoke : invokes) {
                int time = invoke.get(0);
                int interfaceId = invoke.get(1);
                interfaceCounts.put(interfaceId, interfaceCounts.getOrDefault(interfaceId, 0) + 1);

                // Group by time window
                int windowStart = time / timeSegment;
                int windowEnd = windowStart + (timeSegment - 1);
                for (int window = windowStart; window <= windowEnd; window++) {
                    List<List<Integer>> windowInvokes = timeWindowInvokes.getOrDefault(window, new ArrayList<>());
                    windowInvokes.add(invoke);
                    timeWindowInvokes.put(window, windowInvokes);
                }
            }

            // Step 4: Check high frequency interfaces
            for (int window = 0; window <= timeSegment / timeSegment; window++) {
                List<List<Integer>> windowCalls = timeWindowInvokes.get(window);
                if (windowCalls == null || windowCalls.size() < minLimits) {
                    continue;
                }
                for (List<Integer> call : windowCalls) {
                    int interfaceId = call.get(1);
                    if (!highFrequencyInterfaces.contains(interfaceId)) {
                        highFrequencyInterfaces.add(interfaceId);
                    }
                }
            }

            // Step 5: Sort the result
            Collections.sort(highFrequencyInterfaces);

            return highFrequencyInterfaces;
        }

        public static void main(String[] args) {
            List<List<Integer>> invokes = new ArrayList<>();
            invokes.add(Arrays.asList(0, 1));
            invokes.add(Arrays.asList(0, 10));
            invokes.add(Arrays.asList(9, 1));
            invokes.add(Arrays.asList(10, 10));
            invokes.add(Arrays.asList(20, 3));
            invokes.add(Arrays.asList(25, 3));
            invokes.add(Arrays.asList(100, 3));
            invokes.add(Arrays.asList(100, 3));

            List<Integer> result = findHighFrequencyInterfaces(invokes, 10, 2);
            System.out.println(result);
        }
}
