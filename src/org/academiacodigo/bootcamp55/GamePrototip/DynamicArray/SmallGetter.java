package org.academiacodigo.bootcamp55.GamePrototip.DynamicArray;

public class SmallGetter {

    public int smallGetter (int[] arr){
        int bigOne = 0;
        int  smallOne = 0;
        int tempSmall = 0;

        for(int i = 0; i< arr.length;i++){
            if(arr[i]>bigOne){
                bigOne = arr[i];
            }
        }

        if(arr.length>2) {
            for (int i = 0; i < arr.length; i++) {

                if (i == 0) {
                    if (arr[i] < bigOne && arr[i] < arr[i] + 1) {
                        smallOne = arr[i];
                        tempSmall = arr[i];
                    }
                } else {
                    if (arr[i] < bigOne && arr[i] < arr[i] + 1 && arr[i] < tempSmall) {
                        smallOne = arr[i];
                        tempSmall = smallOne;
                    }
                }

            }
        }
        else if (arr.length==2){
            for (int i = 0; i < 1;i++){
                if(arr[i]<arr[i+1]){
                    smallOne = arr[i];
                }
                else{
                    smallOne = arr[i+1];
                }
            }
        }
        else if(arr.length==1){
            smallOne = arr[0];
        }
        return smallOne;
    }



}
