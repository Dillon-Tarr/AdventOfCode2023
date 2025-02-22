package day12.part1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static private final String INPUT_FILE_PATH = "input-files/day12input.txt";
    static private final File INPUT_FILE = new File(INPUT_FILE_PATH);

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        getInputDataAndCreateSpringRows();
        System.out.println("\nSum of all rows' possible arrangement counts:\n\n"+SpringRow.getSumOfAllRowsArrangementCounts());

        System.out.println("\nExecution time in seconds: "+((double) (System.nanoTime()-startTime)/1000000000));
    }

    private static void getInputDataAndCreateSpringRows() {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
            String currentLine = br.readLine();
            while (currentLine != null) {
                new SpringRow(currentLine);
                currentLine = br.readLine();
            }
        } catch (IOException e) {throw new RuntimeException(e);}
    }

}