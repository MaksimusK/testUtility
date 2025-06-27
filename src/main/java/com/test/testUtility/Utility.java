package com.test.testUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utility {
    static String prefix = "prefix_"; // -p
    static String path = "src/main/java/com/test/testUtility"; //-o
    static private  boolean addNowFile = true; // отвечает за дозапись -a
    static private boolean extendedInfo = false; //-f
    static private boolean hortInfo = false; //-s

    public static void main(String[] args) {

        File file = new File("src/main/java/com/test/testUtility/in1.txt");
//        List<String> fileString = new ArrayList<>();
//        List<Integer> fileInteger = new ArrayList<>();
//        List<Float> fileFloat = new ArrayList<>();

        filteringByType(file);
    }

    public static void filteringByType(File file){
        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream).useLocale(Locale.US);
            FileWriter fileWriterInt = new FileWriter(path+ "/" +prefix + "integers.txt", addNowFile);
            FileWriter fileWriterFloat = new FileWriter(path + "/" + prefix + "floats.txt", addNowFile);
            FileWriter fileWriterStr = new FileWriter(path + "/" + prefix + "strings.txt", addNowFile);

        )
        {
            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
//                    fileInteger.add(scanner.nextInt());
                    fileWriterInt.write(scanner.nextInt() + "\n");
                }else if(scanner.hasNextFloat() || scanner.hasNextDouble()){
//                    fileFloat.add(scanner.nextFloat());
                    fileWriterFloat.write(scanner.nextFloat() + "\n");
                } else if(scanner.hasNext()){
//                    fileString.add(scanner.nextLine());
                    fileWriterStr.write(scanner.nextLine() + "\n");

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



