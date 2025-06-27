package com.testTask.testUtility;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ShortInfoStatistics {
    private int countElementString;
    private int countElementInt;
    private int countElementFloat;

    ProcessingParameters processingParameters;

    public ShortInfoStatistics(ProcessingParameters processingParameters){
        this.processingParameters = processingParameters;
    }

    public int getCountElementString() {
        return countElementString;
    }

    public void setCountElementString(int countElementString) {
        this.countElementString = countElementString;
    }

    public int getCountElementInt() {
        return countElementInt;
    }

    public void setCountElementInt(int countElementInt) {
        this.countElementInt = countElementInt;
    }

    public int getCountElementFloat() {
        return countElementFloat;
    }

    public void setCountElementFloat(int countElementFloat) {
        this.countElementFloat = countElementFloat;
    }

    public  void filteringByType(File file){
        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream).useLocale(Locale.US);
            FileWriter fileWriterInt = new FileWriter(processingParameters.getPath()+ "/" +processingParameters.getPrefix() + "integers.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterFloat = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "floats.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterStr = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "strings.txt", processingParameters.isAddNowFile());

        )
        {
            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
//                    fileInteger.add(scanner.nextInt());
                    countElementInt++;
                    fileWriterInt.write(scanner.nextInt() + "\n");
                }else if(scanner.hasNextFloat() || scanner.hasNextDouble()){
//                    fileFloat.add(scanner.nextFloat());
                    countElementFloat++;
                    fileWriterFloat.write(scanner.nextFloat() + "\n");
                } else if(scanner.hasNext()){
//                    fileString.add(scanner.nextLine());
                    String str = scanner.nextLine();
                    countElementString +=  str.length();
                    if(!str.isEmpty()) {
                        fileWriterStr.write(str + "\n");
                    }

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void PrintStatistics(){
        System.out.println("ГРУППА INT");
        System.out.println("Количество элементов добавленных в группу INT: " + countElementInt);

        System.out.println("ГРУППА FLOAT");
        System.out.println("Количество элементов добавленных в группу FLOAT: " + countElementFloat);

        System.out.println("ГРУППА STRING");
        System.out.println("Количество элементов добавленных в группу STRING: " + countElementString);

    }
}
