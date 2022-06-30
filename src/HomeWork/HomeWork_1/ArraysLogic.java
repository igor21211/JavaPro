package HomeWork.HomeWork_1;

import HomeWork.HomeWork_1.MyArrayInteface;

import java.util.*;

public class ArraysLogic implements MyArrayInteface {

    private Integer[] MainArray = new Integer[0];

    public void array(Integer[] mainArray) {
        this.MainArray = mainArray;
    }


    @Override
    public void add(Integer I) {
        Integer[] array = new Integer[MainArray.length + 1];
        System.arraycopy(MainArray, 0, array, 0, MainArray.length - 1);
        array[array.length - 1] = I;
        array(array);
    }

    @Override
    public boolean add(int i, Integer I) {
        try {
            Integer[] array = new Integer[MainArray.length + 1];
            System.arraycopy(MainArray, 0, array, 0, i);
            array[i] = I;
            System.arraycopy(MainArray, i, array, i + 1, MainArray.length - i);
            array(array);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeByValue(Integer I) {
       try {
           for (int i = 0; i < MainArray.length; i++) {
               if (MainArray[i].equals(I)) {
                   remove(MainArray[i]);
               }
           }
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean set(int i, Integer I) {
        try {
            MainArray[i] = I;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void clear() {
        array(new Integer[0]);
    }

    @Override
    public Integer get(int i) {
        try {
            return MainArray[i];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return MainArray.length == 0;
    }

    @Override
    public boolean remove(int i) {
       try {
           Integer[] array = new Integer[MainArray.length - 1];
           System.arraycopy(MainArray, 0, array, 0, i);
           System.arraycopy(MainArray, i + 1, array, i, MainArray.length - (i + 1));
           array(array);
           return true;
       }catch (Exception e){
           return false;
       }
    }

    @Override
    public int size() {
        return MainArray.length;
    }


}