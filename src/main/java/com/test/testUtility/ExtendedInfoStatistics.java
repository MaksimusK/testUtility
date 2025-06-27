package com.test.testUtility;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class ExtendedInfoStatistics {
    private int countElementString;
    private int countElementInt;
    private int countElementFloat;

    private int maxNumberInt;
    private int minNumberInt;

    private float maxNumberFloat;
    private float minNumberFloat;

    private int maxLengthString;
    private int minLengthString;

    private int sumInt;
    private int averageValueInt;

    private float sumFloat;
    private float averageValueFloat;

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
        try(FileReader fileInputStream = new FileReader(file);
            Scanner scanner = new Scanner(fileInputStream).useLocale(Locale.US);
            FileWriter fileWriterInt = new FileWriter(processingParameters.getPath()+ "/" +processingParameters.getPrefix() + "integers.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterFloat = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "floats.txt", processingParameters.isAddNowFile());
            FileWriter fileWriterStr = new FileWriter(processingParameters.getPath() + "/" + processingParameters.getPrefix() + "strings.txt", processingParameters.isAddNowFile());

        )
        {
            minNumberInt = Integer.MAX_VALUE;
            maxNumberInt = Integer.MIN_VALUE;

            minNumberFloat = Integer.MAX_VALUE;
            maxNumberFloat = Integer.MIN_VALUE;

            minLengthString = Integer.MAX_VALUE;
            maxLengthString = -1;

            while(scanner.hasNext()){

                if(scanner.hasNextInt()){
//                    fileInteger.add(scanner.nextInt());
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
//                    fileFloat.add(scanner.nextFloat());
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
//                    fileString.add(scanner.nextLine());
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        averageValueInt = sumInt / countElementInt;
        averageValueFloat = sumFloat / countElementFloat;
    }


    public void PrintStatistics(){
        System.out.println("-----------------------------------------");
        System.out.println("ГРУППА INT");
        System.out.println("Количество элементов добавленных в группу INT: " + countElementInt);
        System.out.println("MAX значение в группе INT:" + maxNumberInt);
        System.out.println("MIN значение в группе INT:" + minNumberInt);
        System.out.println("СУММА элементов в группе INT:" + sumInt);
        System.out.println("СРЕДНЕЕ ЗНАЧЕНИЕ элементов в группе INT:" + averageValueInt);
        System.out.println("-----------------------------------------");
        System.out.println("ГРУППА FLOAT");
        System.out.println("Количество элементов добавленных в группу FLOAT: " + countElementFloat);
        System.out.println("MAX значение в группе FLOAT:" + maxNumberFloat);
        System.out.println("MIN значение в группе FLOAT:" + minNumberFloat);
        System.out.println("СУММА элементов в группе FLOAT:" + sumFloat);
        System.out.println("СРЕДНЕЕ ЗНАЧЕНИЕ элементов в группе FLOAT:" + averageValueFloat);
        System.out.println("-----------------------------------------");
        System.out.println("ГРУППА STRING");
        System.out.println("Количество элементов добавленных в группу STRING: " + countElementString);
        System.out.println("MAX значение в группе STRING:" + maxLengthString);
        System.out.println("MIN значение в группе STRING:" + minLengthString);
        System.out.println("-----------------------------------------");
    }
}
