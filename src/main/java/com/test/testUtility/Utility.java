package com.test.testUtility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utility {
//    static String path = ""; //-o
//    static String prefix = ""; // -p
//    static private  boolean addNowFile = false; // отвечает за дозапись -a
//    static private boolean extendedInfo = false; //-f
//    static private boolean shortInfo = false; //-s
static ProcessingParameters processingParameters = new ProcessingParameters();
    //Статистика


    public static void main(String[] args) {
        int count = 0;
        String[] mas = new String[]{"-o", "src/main/java/com/test/testUtility", "-p", "prefix_", "-f","src/main/java/com/test/testUtility/in1.txt"};
//        File file = new File("src/main/java/com/test/testUtility/in1.txt");
//        List<File> files = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            if(count == 1){
                count=0;
                continue;
            }else if(mas[i] == "-o"){
                processingParameters.setPath(mas[i+1]);
                count=1;
            }else if(mas[i] == "-p"){
                processingParameters.setPrefix(mas[i+1]);
                count=1;
            }else if(mas[i] == "-a"){
                processingParameters.setAddNowFile(true);
            }else if(mas[i] == "-f"){
                processingParameters.setExtendedInfo(true);
            }else if(mas[i] == "-s"){
                processingParameters.setShortInfo(true);
            }else{
                File file = new File(mas[i]);
                if(file.exists()){
                    processingParameters.files.add(file);
                }else{
                    System.out.println("Такого файла не существует!");
                }
            }
        }

//        List<String> fileString = new ArrayList<>();
//        List<Integer> fileInteger = new ArrayList<>();
//        List<Float> fileFloat = new ArrayList<>();

        for (int i = 0; i < processingParameters.files.size(); i++) {
        if(processingParameters.isExtendedInfo()){
            ExtendedInfoStatistics extendedInfoStatistics = new ExtendedInfoStatistics(processingParameters);
            extendedInfoStatistics.filteringByType(processingParameters.files.get(i));
            extendedInfoStatistics.PrintStatistics();
            System.out.println();
        }else{
            ShortInfoStatistics shortInfoStatistics = new ShortInfoStatistics(processingParameters);
            shortInfoStatistics.filteringByType(processingParameters.files.get(i));
            System.out.println();
        }

        }
    }


}



