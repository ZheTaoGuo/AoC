package AoC.day1;

import java.nio.file.Files;
import java.io.File;
import java.util.*;

public class Day_1 {

    public static Integer compareDistances(List<String> file) {

        List<String> input = file;

        List<Integer> group1LocS = new ArrayList<>();
        List<Integer> group2LocS = new ArrayList<>();

        for (String line:input) {
            group1LocS.add(Integer.valueOf(line.split(" +")[0]));
            group2LocS.add(Integer.valueOf(line.split(" +")[1]));
        }
        //PART A
        group1LocS.sort(Comparator.comparingInt(Integer::valueOf));
        group2LocS.sort(Comparator.comparingInt(Integer::valueOf));
        int sum = 0;

        for(int i=0;i < group1LocS.size();i++){
            sum += Math.abs(group1LocS.get(i)-group2LocS.get(i));
        }
        return sum;
    }
    public static int calculateSum(List<Integer> leftList, List<Integer> rightList) {
        Map<Integer, Integer> rightCountMap = new HashMap<>();
        for (int num : rightList) {
            rightCountMap.put(num, rightCountMap.getOrDefault(num ,0) + 1);
        }

        int totalSum = 0;
        for (int num : leftList) {
            int countInRight = rightCountMap.getOrDefault(num, 0);
            totalSum += num * countInRight;
        }
        return totalSum;
    }
    public static Integer findSimiliarityScore(List<String> file){
        List<String> input = file;
        List<Integer> group1Locs = new ArrayList<>();
        List<Integer> group2Locs = new ArrayList<>();
 
        for(String line:input){
            group1Locs.add(Integer.valueOf(line.split(" +")[0]));
            group2Locs.add(Integer.valueOf(line.split(" +")[1]));
        }
        int result = calculateSum(group1Locs, group2Locs);
        return result;
    }
    public static void main(String[] args) throws Exception {

        //PART A
        Integer partAResult = compareDistances(Files.readAllLines(new File("input.txt").toPath()));
        System.out.println("Part A Result" + partAResult);

        //PART B
        Integer partBResult = findSimiliarityScore(Files.readAllLines(new File("input.txt").toPath()));
        System.out.println("Part B Result" + partBResult);
    }
}