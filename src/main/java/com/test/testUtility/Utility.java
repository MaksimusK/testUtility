package com.test.testUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {

    public static void main(String[] args) {

        File file = new File("src/main/java/com/test/testUtility/in1.txt");
        List<String> fileString = new ArrayList<>();
        List<Integer> fileInteger = new ArrayList<>();
        List<Float> fileFloat = new ArrayList<>();

        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream)
        )
        {
            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
                    fileInteger.add(scanner.nextInt());
                }
                else if(scanner.hasNext()){
                    fileString.add(scanner.nextLine());
                }else if(scanner.hasNextFloat()){
                    fileFloat.add(scanner.nextFloat());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//
//        }


    }
}



