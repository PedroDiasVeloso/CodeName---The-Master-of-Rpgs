package org.academiacodigo.bootcamp55.GamePrototip.DynamicArray;

public class DynamicArray {

    private int[] intArray = new int [0];
    private String[] stringArray = new String[0];


    public void setIntArray(int[] array){
        intArray = array;
    }
    public void setStringArray(String[] array){
        stringArray = array;
    }



    public int[] addInt(int element){

        int [] tempArray = new int[intArray.length+1];

        for(int i = 0; i < intArray.length; i++){
            tempArray[i]= intArray[i];
        }

        tempArray[intArray.length] = element;

        return intArray = tempArray;
    }

    public String[] addString(String element){
        String [] tempArray = new String[stringArray.length+1];

        for(int i = 0; i < stringArray.length; i++){
            tempArray[i] = stringArray[i];
        }

        tempArray[stringArray.length] = element;

        return stringArray = tempArray;
    }


    public int[] remove(int element) {
        int[] tempArray = new int[intArray.length - 1];
        int index = 0;

        for(int i = 0; i < intArray.length ; i++){
            if(intArray[i] == element){
                index = i;
            }
        }

        for (int i = 0, j = 0; i < intArray.length; i++) {
            if (i != index) {
                tempArray[j] = intArray[i];
                j++;
            }
        }
        return intArray = tempArray;
    }


    public int getByIndex(int index){

        return intArray[index];
    }




    public int length(){
        int counter = 0;

        for(int i = 0; i< intArray.length; i++){
            counter++;
        }
        return counter;
    }

}