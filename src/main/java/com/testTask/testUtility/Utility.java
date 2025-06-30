package com.testTask.testUtility;

import java.io.*;

public class Utility {

static ProcessingParameters processingParameters = new ProcessingParameters();


    public static void main(String[] args) {
        int count = 0;

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
                    System.out.println("Файл " + file.getName() +" не существует!");
                }
            }
        }


        if(processingParameters.isExtendedInfo()){
            ExtendedInfoStatistics extendedInfoStatistics = new ExtendedInfoStatistics(processingParameters);
            for (int i = 0; i < processingParameters.files.size(); i++) {
            extendedInfoStatistics.filteringByType(processingParameters.files.get(i));
            System.out.println();
            }
            extendedInfoStatistics.PrintStatistics();

        }else if(processingParameters.isShortInfo()){
            ShortInfoStatistics shortInfoStatistics = new ShortInfoStatistics(processingParameters);
            for (int i = 0; i < processingParameters.files.size(); i++) {
            shortInfoStatistics.filteringByType(processingParameters.files.get(i));
            System.out.println();
            }
            shortInfoStatistics.PrintStatistics();
        }else{
            ShortInfoStatistics shortInfoStatistics = new ShortInfoStatistics(processingParameters);
            for (int i = 0; i < processingParameters.files.size(); i++) {
                shortInfoStatistics.filteringByType(processingParameters.files.get(i));
                System.out.println();
            }
        }


    }


}



