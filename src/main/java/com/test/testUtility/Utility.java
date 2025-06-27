package com.test.testUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utility {
    static String path = ""; //-o
    static String prefix = ""; // -p
    static private  boolean addNowFile = false; // отвечает за дозапись -a
    static private boolean extendedInfo = false; //-f
    static private boolean shortInfo = false; //-s

    public static void main(String[] args) {
        int count = 0;
        String[] mas = new String[]{"-o", "src/main/java/com/test/testUtility", "-p", "prefix_", "src/main/java/com/test/testUtility/in1.txt"};
//        File file = new File("src/main/java/com/test/testUtility/in1.txt");
        List<File> files = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            if(count == 1){
                count=0;
                continue;
            }else if(mas[i] == "-o"){
                path = mas[i+1];
                count=1;
            }else if(mas[i] == "-p"){
                prefix = mas[i+1];
                count=1;
            }else if(mas[i] == "-a"){
                addNowFile = true;
                count=1;
            }else if(mas[i] == "-f"){
                extendedInfo = true;
                count=1;
            }else if(mas[i] == "-s"){
                shortInfo = true;
                count=1;
            }else{
                File file = new File(mas[i]);
                if(file.exists()){
                    files.add(file);
                }else{
                    System.out.println("Такого файла не существует!");
                }
            }
        }

//        List<String> fileString = new ArrayList<>();
//        List<Integer> fileInteger = new ArrayList<>();
//        List<Float> fileFloat = new ArrayList<>();
        for (int i = 0; i < files.size(); i++) {

            filteringByType(files.get(i));
        }
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



