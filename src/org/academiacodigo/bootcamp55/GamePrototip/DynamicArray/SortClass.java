package org.academiacodigo.bootcamp55.GamePrototip.DynamicArray;

public class SortClass {

    SmallGetter small = new SmallGetter();
    BigGetter big = new BigGetter();
    DynamicArray dynamicArray = new DynamicArray();

    private int[] result;
    private static int counter = 0;

    public SortClass(int[] result){
        this.result = new int[result.length];
    }



    public int[] makeSortingSmallToBig(int[] arr){
        if(counter == 0) {
            dynamicArray.setIntArray(arr);
        }

        while (counter < result.length) {
            int smallOne = small.smallGetter(arr);
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == smallOne) {
                    index = i;
                }
            }
            result[counter] = smallOne;
            counter++;

            int[] middleOne = dynamicArray.remove(index);

            return makeSortingSmallToBig(middleOne);
        }

        return result;
    }

    public int[] makeSortingBigToSmall(int[] arr){
        if(counter == 0){
            dynamicArray.setIntArray(arr);
        }


        while(counter<result.length){
            int bigOne = big.bigGetter(arr);
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == bigOne) {
                    index = i;
                }
            }

            result[counter]=bigOne;
            counter++;
            int[] middleOne = dynamicArray.remove(index);

            return makeSortingBigToSmall(middleOne);

        }
        return result;

    }




}
