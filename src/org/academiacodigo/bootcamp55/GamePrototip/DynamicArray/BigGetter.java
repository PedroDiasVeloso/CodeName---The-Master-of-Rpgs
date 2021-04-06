package org.academiacodigo.bootcamp55.GamePrototip.DynamicArray;

public class BigGetter {


    public int bigGetter(int[] array){
        int bigOne = 0;


        for(int i = 0; i < array.length; i++){
            if(array[i]>bigOne){
                bigOne = array[i];
            }
        }
        return bigOne;
    }
}
