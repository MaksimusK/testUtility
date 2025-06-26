package com.test.testUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utility {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/test/testUtility/in1.txt");
        List<String> fileString = new ArrayList<>();
        List<Integer> fileInteger = new ArrayList<>();
        List<Float> fileFloat = new ArrayList<>();
        String prefix = "";

        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream).useLocale(Locale.US);
            FileWriter fileWriterInt = new FileWriter(prefix + "integers.txt");
            FileWriter fileWriterFloat = new FileWriter(prefix + "floats.txt");
            FileWriter fileWriterStr = new FileWriter(prefix + "strings.txt");

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



