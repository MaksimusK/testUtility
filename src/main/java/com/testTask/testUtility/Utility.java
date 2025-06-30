package com.testTask.testUtility;

import java.io.*;

public class Utility {

static ProcessingParameters processingParameters = new ProcessingParameters();


    public static void main(String[] args) {
        int count = 0;
        String[] args1 =new String[]{"-o", "src/main/java/com/testTask/testUtility", "-f", "-a", "src/main/java/com/testTask/testUtility/in2.txt"};

        for (int i = 0; i < args1.length; i++) {
            if(count == 1){
                count=0;
                continue;
            }else if(args1[i].equals("-o")){
                processingParameters.setPath(args1[i+1]);
                count=1;
            }else if(args1[i].equals("-p")){
                processingParameters.setPrefix(args1[i+1]);
                count=1;
            }else if(args1[i].equals("-a")){
                processingParameters.setAddNowFile(true);
            }else if(args1[i].equals("-f")){
                processingParameters.setExtendedInfo(true);
            }else if(args1[i].equals("-s")){
                processingParameters.setShortInfo(true);
            }else{
                File file = new File(args1[i]);
                if(file.exists()){
                    processingParameters.files.add(file);
                }else{
                    System.out.println("Такого файла не существует!");
                }
            }
        }

        for (int i = 0; i < processingParameters.files.size(); i++) {
        if(processingParameters.isExtendedInfo()){
            ExtendedInfoStatistics extendedInfoStatistics = new ExtendedInfoStatistics(processingParameters);
            extendedInfoStatistics.filteringByType(processingParameters.files.get(i));
            extendedInfoStatistics.PrintStatistics();
            System.out.println();
        }else{
            ShortInfoStatistics shortInfoStatistics = new ShortInfoStatistics(processingParameters);
            shortInfoStatistics.filteringByType(processingParameters.files.get(i));
            shortInfoStatistics.PrintStatistics();
            System.out.println();
        }

        }
    }


}



