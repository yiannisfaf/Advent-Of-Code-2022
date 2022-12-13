import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1Calories {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        readFile();
    }

    static void readFile() throws FileNotFoundException, IOException {
        String file = "/Users/zitafafalios/Documents/code/AdventOfCode2022/Day1/input.txt";
        String currentLine;
        ArrayList<Integer> blocks = new ArrayList<Integer>();
        ArrayList<Integer> sums = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        while((currentLine = reader.readLine()) != null) {
            if (currentLine.equals("")) {
                sums.add(findSum(blocks));
                blocks.clear();
            } else {
                blocks.add(Integer.parseInt(currentLine));
            }
        }
        //System.out.println(Collections.max(sums)); --PART 1
        topThreeSum(sums);
        reader.close();
    }

    static int findSum(ArrayList<Integer> block) {
        int result = block.stream().mapToInt(Integer::intValue).sum();
        //System.out.println(result);
        return result;
    }

    //PART 2
    static void topThreeSum(ArrayList<Integer> sums) {
        ArrayList<Integer> sumsCopy = new ArrayList<>();
        sumsCopy = sums;
        int topThree = 0;
        for (int i = 0; i < 3; i++) {
            int max = Collections.max(sumsCopy);
            topThree = topThree + max;
            sumsCopy.remove(sumsCopy.indexOf(max));
        }
        System.out.println(topThree);
    }
}