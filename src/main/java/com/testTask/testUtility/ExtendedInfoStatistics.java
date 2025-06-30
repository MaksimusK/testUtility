package com.testTask.testUtility;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ExtendedInfoStatistics {
    private static int countElementString;
    private static int countElementInt;
    private static int countElementFloat;

    private static int maxNumberInt =Integer.MIN_VALUE;
    private static int minNumberInt =Integer.MAX_VALUE;

    private static float maxNumberFloat = Float.MIN_VALUE;
    private static float minNumberFloat = Float.MAX_VALUE;

    private static int maxLengthString = -1;
    private static int minLengthString = Integer.MAX_VALUE;

    private static int sumInt;
    private static int averageValueInt;

    private static float sumFloat;
    private static float averageValueFloat;

    ProcessingParameters processingParameters;

    public ExtendedInfoStatistics(ProcessingParameters processingParameters){
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

    public int getMaxNumberInt() {
        return maxNumberInt;
    }

    public void setMaxNumberInt(int maxNumberInt) {
        this.maxNumberInt = maxNumberInt;
    }

    public int getMinNumberInt() {
        return minNumberInt;
    }

    public void setMinNumberInt(int minNumberInt) {
        this.minNumberInt = minNumberInt;
    }

    public float getMaxNumberFloat() {
        return maxNumberFloat;
    }

    public void setMaxNumberFloat(int maxNumberFloat) {
        this.maxNumberFloat = maxNumberFloat;
    }

    public float getMinNumberFloat() {
        return minNumberFloat;
    }

    public void setMinNumberFloat(int minNumberFloat) {
        this.minNumberFloat = minNumberFloat;
    }

    public int getMaxLengthString() {
        return maxLengthString;
    }

    public void setMaxLengthString(int maxLengthString) {
        this.maxLengthString = maxLengthString;
    }

    public int getMinLengthString() {
        return minLengthString;
    }

    public void setMinLengthString(int minLengthString) {
        this.minLengthString = minLengthString;
    }



    public  void filteringByType(File file){
        System.out.println(processingParameters.getPath()+ "/" +processingParameters.getPrefix() + "integers.txt");
        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream).useLocale(Locale.US);
            FileWriter fileWriterInt = new FileWriter(processingParameters.getPath()+ "/" +processingParameters.getPrefix() + "integers.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterFloat = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "floats.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterStr = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "strings.txt", processingParameters.isAddNowFile());

        )
        {


            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
                    int value = scanner.nextInt();

                    if(value > maxNumberInt){
                        maxNumberInt = value;
                    }
                    if(value < minNumberInt){
                        minNumberInt = value;
                    }
                    sumInt += value;
                    countElementInt++;
                    fileWriterInt.write(value + "\n");
                }else if(scanner.hasNextFloat() || scanner.hasNextDouble()){
                    float value = scanner.nextFloat();
                    if(value > maxNumberFloat){
                        maxNumberFloat = value;
                    }
                    if(value < minNumberFloat){
                        minNumberFloat = value;
                    }
                    sumFloat += value;
                    countElementFloat++;
                    fileWriterFloat.write(value + "\n");
                } else if(scanner.hasNext()){
                    String str = scanner.nextLine();

                    if(str.isEmpty()) {
                        continue;
                    }
                    countElementString +=  str.length();
                    if(str.length() > maxLengthString){
                        maxLengthString = str.length();
                    }
                    if(str.length() < minLengthString){
                        minLengthString = str.length();
                    }
                    if(!str.isEmpty()) {
                        fileWriterStr.write(str + "\n");
                    }

                }

            }
            if(countElementInt != 0){
                averageValueInt = sumInt / countElementInt;
            }if(countElementFloat != 0){
            averageValueFloat = sumFloat / countElementFloat;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void calculateAverageValueAndFloat(){

    }


    public void PrintStatistics(){
        if(countElementInt != 0){


        System.out.println("-----------------------------------------");
        System.out.println("ГРУППА INT");
        System.out.println("Количество элементов добавленных в группу INT: " + countElementInt);
        System.out.println("MAX значение в группе INT:" + maxNumberInt);
        System.out.println("MIN значение в группе INT:" + minNumberInt);
        System.out.println("СУММА элементов в группе INT:" + sumInt);
        System.out.println("СРЕДНЕЕ ЗНАЧЕНИЕ элементов в группе INT:" + averageValueInt);
        }else{
            File file2 = new File(processingParameters.getPath()+ "/" +
                    processingParameters.getPrefix() + "integers.txt");
            file2.delete();
        }if(countElementFloat != 0){

                System.out.println("-----------------------------------------");
                System.out.println("ГРУППА FLOAT");
                System.out.println("Количество элементов добавленных в группу FLOAT: " + countElementFloat);
                System.out.println("MAX значение в группе FLOAT:" + maxNumberFloat);
                System.out.println("MIN значение в группе FLOAT:" + minNumberFloat);
                System.out.println("СУММА элементов в группе FLOAT:" + sumFloat);
                System.out.println("СРЕДНЕЕ ЗНАЧЕНИЕ элементов в группе FLOAT:" + averageValueFloat);

        }else{
            File file2 = new File(processingParameters.getPath() + "/" +
                    processingParameters.getPrefix() + "floats.txt");
            file2.delete();
        }if(countElementString != 0){

        System.out.println("-----------------------------------------");
        System.out.println("ГРУППА STRING");
        System.out.println("Количество элементов добавленных в группу STRING: " + countElementString);
        System.out.println("MAX значение в группе STRING:" + maxLengthString);
        System.out.println("MIN значение в группе STRING:" + minLengthString);
        }else{
            File file2 = new File(processingParameters.getPath() + "/" +
                    processingParameters.getPrefix() + "strings.txt");
            file2.delete();
        }
        System.out.println("-----------------------------------------");
    }
}
