package com.testTask.testUtility;

import java.io.*;

public class Utility {

static ProcessingParameters processingParameters = new ProcessingParameters();



    public static void main(String[] args) {
        int count = 0;
//        for (int i = 0; i < args.length; i++) {
//            System.out.println(args[i]);
//        }
        String[] mas = new String[]{"-o", "src/main/java/com/testTask/testUtility", "-p", "prefix_", "-f","src/main/java/com/testTask/testUtility/in1.txt"};

        for (int i = 0; i < args.length; i++) {
            if(count == 1){
                count=0;
                continue;
            }else if(args[i].equals("-o")){
                processingParameters.setPath(args[i+1]);
                count=1;
            }else if(args[i].equals("-p")){
                processingParameters.setPrefix(args[i+1]);
                count=1;
            }else if(args[i].equals("-a")){
                processingParameters.setAddNowFile(true);
            }else if(args[i].equals("-f")){
                processingParameters.setExtendedInfo(true);
            }else if(args[i].equals("-s")){
                processingParameters.setShortInfo(true);
            }else{
                File file = new File(args[i]);
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



