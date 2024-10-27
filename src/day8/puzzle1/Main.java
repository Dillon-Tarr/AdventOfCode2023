package day8.puzzle1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static private final String INPUT_FILE_PATH = "src/day8/input.txt";
    static private final File INPUT_FILE = new File(INPUT_FILE_PATH);
    static private char[] instructionSet;
    static private final ArrayList<Node> nodes = new ArrayList<>();
    static private int stepCount = 0;

    public static void main(String[] args) {
        getInputData();
        travelToZZZ();
    }

    private static void getInputData() {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            instructionSet = br.readLine().toCharArray();
            br.readLine();
            String currentLine = br.readLine();
            while (currentLine != null) {
                nodes.add(new Node(currentLine));
                currentLine = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void travelToZZZ() {
        String currentLocation = "AAA";
        while (true) {
            for (char instruction : instructionSet) {for (Node node : nodes) {
                if (currentLocation.equals(node.getKey())) {
                    if (instruction == 'L') currentLocation = node.getLeftValue();
                    else currentLocation = node.getRightValue();
                    stepCount++;
                    break;
                }
                if (currentLocation.equals("ZZZ")) {
                    System.out.printf("\nTraveled from AAA to ZZZ in %d steps.", stepCount);
                    return;
                }
            }}
        }
    }

}
