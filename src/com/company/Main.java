package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	massive();
	secondMassive();
    }
    public static void massive(){
        int razmer = 200000000;
        float[]arr= new float[razmer];
        for (int t=0; t<arr.length; t++){
            arr[t] = 1.0f;
        }
        long timeStart = System.currentTimeMillis();
        for (int t=0; t<arr.length; t++){
            arr[t] = (float) (arr[t] * Math.sin(0.2f + t / 5) * Math.cos(0.2f + t / 5) * Math.cos(0.4f + t / 2));
        }
        System.out.println("Время работы: " + (System.currentTimeMillis() - timeStart) + " миллисекунд.");

    }
    public static void secondMassive() {
        int razmer = 200000000;
        float[]arr= new float[razmer];
        for (int t=0; t<arr.length; t++){
            arr[t] = 1.0f;
        }
        long timeStart = System.currentTimeMillis();
        int[] leftHalf = new int[100000000];
        int[] rightHalf = new int[100000000];
        System.arraycopy(arr,0, leftHalf, 0,100000000);
        for (int t=0; t<arr.length; t++){
            arr[t] = (float) (arr[t] * Math.sin(0.2f + t / 5) * Math.cos(0.2f + t / 5) * Math.cos(0.4f + t / 2));
        }
        System.arraycopy(arr,100000000, rightHalf, 0,100000000);
        for (int t=0; t<arr.length; t++){
            arr[t] = (float) (arr[t] * Math.sin(0.2f + t / 5) * Math.cos(0.2f + t / 5) * Math.cos(0.4f + t / 2));
        }
        System.out.println(Arrays.toString(leftHalf));
        System.out.println(Arrays.toString(rightHalf));
        long timeStart = System.currentTimeMillis();

        int[] mergedArray = new int[200000000];
        System.arraycopy(leftHalf, 0, mergedArray,0,100000000);
        System.arraycopy(rightHalf, 0, mergedArray,0,100000000);
        System.out.println(Arrays.toString(mergedArray));
        long timeStart = System.currentTimeMillis();
    }

}
