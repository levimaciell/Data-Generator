package org.levi.files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class IntegerGenerator implements Generator<Integer>{

    private Random numberGenerator = new Random();

    @Override
    public List<Integer> generateData(int numberOfData) {

        List<Integer> generatedData = new LinkedList<>();

        for(int i = 0; i < numberOfData; i++){
            generatedData.add(numberGenerator.nextInt());
        }

        return generatedData;
    }

    public List<Integer> generateData(int numberOfData, int limit){

        if(limit <= 0)
            throw new RuntimeException("limit must be a positive number!");

        List<Integer> generatedData = new LinkedList<>();

        for(int i = 0; i < numberOfData; i++){
            generatedData.add(numberGenerator.nextInt(limit));
        }

        return generatedData;

    }

    @Override
    public void outputInFile(String fileName, List<Integer> elements) {

        try{
            BufferedWriter bWriter = new BufferedWriter(new FileWriter(fileName));

            for(Integer i : elements){
                bWriter.write(i);
            }

        }
        catch (IOException exp){
            System.err.println("Error: " + exp.getMessage());
        }

    }
}
