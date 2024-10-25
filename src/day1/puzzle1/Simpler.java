package day1.puzzle1;

import java.io.*;
import java.util.ArrayList;

public class Simpler {
    static private final String INPUT_FILE_PATH = "src/day1/input.txt";
    static private final File INPUT_FILE = new File(INPUT_FILE_PATH);

    private static final ArrayList<String> values = new ArrayList<>(1000);
    private static int sumOfRealCalibrationValues;

    public static void main(String[] args) {
        getGarbledValues();
        removeNonNumeralsFromValues();
        getRealCalibrationValues();

        System.out.println("\nSUM OF REAL CALIBRATION VALUES:\n"+sumOfRealCalibrationValues);
    }

    private static void getGarbledValues() {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))){
            String currentLine = br.readLine();

            while (currentLine != null) {
                values.add(currentLine);
                currentLine = br.readLine();
            }
            System.out.println("\nValues obtained from file.\nCurrent values:\n" + values);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static void removeNonNumeralsFromValues() {
        values.replaceAll(value -> value.replaceAll("[^0-9]", ""));
        System.out.println("\nNon-numerals removed from all values.\nCurrent values:\n" + values);
    }

    private static void getRealCalibrationValues() {
        for (int i = 0; i < values.size(); i++) {
            String fake = values.get(i);
            String real = ""+fake.charAt(0)+fake.charAt(fake.length()-1);
            values.set(i, real);
            sumOfRealCalibrationValues += Integer.parseInt(real);
        }
        System.out.println("\nReal values obtained from numeral-only values.\nReal values:\n" + values);
    }
}