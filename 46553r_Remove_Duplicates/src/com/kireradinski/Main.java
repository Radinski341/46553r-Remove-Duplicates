package com.kireradinski;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] array = {"mango", "avocado", "apple", "orange", "avocado", "banana", "apple", "pineapple", "kiwi", "strawberries", "avocado"};
        String[] array2 = {"corvette", "skyline", "GTR", "supra", "audi", "corvette", "BMW", "mercedes", "alfa", "ferrari", "alfa", "supra"};
        System.out.println("Original array: " + Arrays.toString(array));
        removeDuplicates(array);
        System.out.println("Original array: " + Arrays.toString(array2));
        removeDuplicates(array2);
    }
    public static void removeDuplicates(String[] array){
        //1.Create new array with the same length as original array
        String[] newArray = new String[array.length];
        //1.1.Create array that we will store one of the duplicates in it (size is half of the original array)
        String[] duplicates = new String[array.length / 2];
        //2.Loop trough original array
        for(String word : array){
            //3.Initialize variables that will store info if member in array should be copied or not
            boolean copyWord = true;
            int timesChecked = 0;
            //4.Loop through the same array but now with for loop to record the index
            for(int index = 0; index < array.length; index++){
                //5.If the word from the first loop is equal with the word with index from the second loop
                if(word.equals(array[index])){
                    //6.The word will be equals at least once because we are looping twice int the same array.
                    //If the word is equal for second time we set copyWord to false because we don't want it in the new array
                    if(timesChecked >= 1){
                        copyWord = false;
                        //7.Add the duplicate word in duplicates array
                        for(int duplicatesIndex = 0; duplicatesIndex < duplicates.length; duplicatesIndex++){
                            if(duplicates[duplicatesIndex] == null){
                                duplicates[duplicatesIndex] = word;
                                break;
                            }
                            //7.1.If word is already in duplicates array we don't add it and break from the loop
                            if(duplicates[duplicatesIndex].equals(word)){
                                break;
                            }

                        }
                    }
                    //8.Update how many times is this word in to array
                    timesChecked++;
                }
            }
            //9. If the word is not duplicate we store it in new array
            if(copyWord){
                //10. Find the index of first null value and replace it with the word
                for(int newArrIndex = 0; newArrIndex < newArray.length; newArrIndex++){
                    if(newArray[newArrIndex] == null){
                        newArray[newArrIndex] = word;
                        break;
                    }
                }
            }
        }
        //11. Find the length of final array without null values
        int finalArrayLength = 0;
        for(int stopIndex = 0; stopIndex < newArray.length; stopIndex++){
            if(newArray[stopIndex] == null){
                finalArrayLength = stopIndex;
                break;
            }
        }
        //11. Find the length of duplicates array without null values
        int duplicatesLength = 0;
        for (int duplicatesStopIndex = 0; duplicatesStopIndex < duplicates.length; duplicatesStopIndex++){
            if(duplicates[duplicatesStopIndex] == null){
                duplicatesLength = duplicatesStopIndex;
                break;
            }
        }
        //12. Add all the words from new array to the final array
        String[] finalArray = new String[finalArrayLength + duplicatesLength];
        for(int finalArrIndex = 0; finalArrIndex < finalArrayLength; finalArrIndex++){
            finalArray[finalArrIndex] = newArray[finalArrIndex];
        }
        //12. Add all the words from duplicates array to the final array
        for (int duplicatesArrIndex = 0; duplicatesArrIndex < duplicatesLength ; duplicatesArrIndex++){
            finalArray[finalArrayLength + duplicatesArrIndex] = duplicates[duplicatesArrIndex];
        }
        System.out.println("Array with removed duplicates: "+ Arrays.toString(finalArray));
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }
}
