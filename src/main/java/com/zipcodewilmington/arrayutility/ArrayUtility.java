package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <T>{

    T[] inputArray;

    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate) {
        Integer count = 0;

        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i].equals(valueToEvaluate)){
                count++;
            }
        }

        for(int i=0;i<arrayToMerge.length;i++){
            if(arrayToMerge[i].equals(valueToEvaluate)){
                count++;
            }
        }

        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge,Class<T> clazz) {
        T[] returnArray = mergeArrays(inputArray,arrayToMerge,clazz);

        T previous = returnArray[0];
        T mostCommon = returnArray[0];
        int count = 1;
        int maxCount = 1;

        for(int i=1;i<returnArray.length;i++){
            if(returnArray[i].equals(previous)){
                count++;
            }
            else{
                if(count > maxCount){
                    maxCount = count;
                    mostCommon = returnArray[i-1];
                }
                previous = returnArray[i];
                count = 1;
            }
        }

        return mostCommon;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate) {
        Integer count = 0;
        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i].equals(valueToEvaluate)){
                count++;
            }
        }
        return count;
    }

    public T[] removeValue(T valueToRemove,Class<T> clazz) {
        Integer numOfOccurences = getNumberOfOccurrences(valueToRemove);
        T[] returnArr = (T[]) Array.newInstance(clazz,inputArray.length-numOfOccurences);
        int count = 0;

        for(int i=0,j=0;i<inputArray.length;i++){
            if(!inputArray[i].equals(valueToRemove)){
                returnArr[j++] = inputArray[i];
            }
        }
        return returnArr;
    }

    public T[] mergeArrays(T[] array1, T[] array2, Class<T> clazz){
        T[] returnArray = (T[]) Array.newInstance(clazz,array1.length+array2.length);
        int count = 0;

        for(int i=0;i<array1.length;i++){
            returnArray[count] = array1[i];
            count++;
        }

        for(int i=0;i<array2.length;i++){
            returnArray[count] = array2[i];
            count++;
        }

        return returnArray;
    }


}
