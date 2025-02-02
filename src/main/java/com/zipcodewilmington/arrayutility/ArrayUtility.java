package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.Arrays;

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
        T[] mergedArray = mergeArrays(inputArray,arrayToMerge,clazz);

        T temp;
        Integer tempCount = 1;
        T maxValue = null;
        Integer maxCount = 1;

        for(int i=0;i<mergedArray.length;i++){
            temp = mergedArray[i];
            for(int j=i+1;j<mergedArray.length;j++){
                if(temp.equals(mergedArray[j])){
                    tempCount++;
                }
            }
            if(tempCount > maxCount){
                maxValue = temp;
                maxCount = tempCount;
            }
            tempCount = 1;
        }

        return maxValue;
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

    public T[] removeValue(T valueToRemove) {
        Integer numOfOccurences = getNumberOfOccurrences(valueToRemove);
        T[] returnArr = Arrays.copyOf(inputArray,inputArray.length-numOfOccurences);
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
