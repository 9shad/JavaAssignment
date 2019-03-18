/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3;

import java.util.ArrayList;

/**
 *
 * @author sindhwanin0507
 */
public class Solution {
    //Q2
        /**
         * array size is multiple of 3
         * segment is always multiple of three
         * arr = {2,-1,6,|22,-2,0,|8,7,9}
         * sorting based on position
         * first position of all segment, second position of all segments, third element of all segment
         * output = {-2,2,8,-1,6,9,0,7,22}
         * 
         * sorting with in same array
        */
        public static void main(String... args){
            
        	solutionSubmittedInExam();
        	optimizedSolution();
        	tryWithoutArray();
        }
        
        public static void solutionSubmittedInExam(){
        	int[] arr = {2,-1,6,22,-2,0,8,7,9};
            //int[] arr = {2,-1,4};
            int totalSegment = 3;
            //using below array to store index already used
            ArrayList<Integer> indicesUsed = new ArrayList<Integer>(); 
            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            for(int i = 0;i<arr.length;i+=totalSegment){ 
                //iterate i for number of segments (number of each segment)
                for(int j=i/3;j<arr.length-1;j+=totalSegment){ 
                //j represent element position in each segment
                    //System.out.println(i+" "+j);
                    int keyIndex = j;
                    indicesUsed.add(j);
                    for(int k=1;k<arr.length;k++){
                        if(!indicesUsed.contains(k)){
                            //System.err.println(i + " "+j+" "+k);
                            if(arr[keyIndex]>arr[k]){
                                keyIndex = k;
                            }
                        }
                    }
                    if(keyIndex != j){
                        int temp = arr[keyIndex];
                        arr[keyIndex] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            System.out.println("");
            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            System.out.println("");
        }
        
        public static void optimizedSolution(){ //uses two loops and an extra array
        	int[] arr = {2,-1,6,22,-2,0,8,7,9,5,4,3};
            //int[] arr = {2,-1,4};
        	//int[] arr = {2,-1,6,22,-2,0,8,7,9};
            int segmentSize = 3;
            //using below array to store index already used
            ArrayList<Integer> indicesUsed = new ArrayList<Integer>(); 
            
            System.out.println();
            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            System.out.println();
            
            int count = 0;
            for(int i=0; count!=segmentSize;){
                int keyIndex = i;
                indicesUsed.add(i);
                for(int k=1;k<arr.length;k++){
                    if(!indicesUsed.contains(k)){
                    	//System.err.println(i +" "+k);
                        if(arr[keyIndex]>arr[k]){
                            keyIndex = k;
                        }
                    }
                }
                if(keyIndex != i){
                    int temp = arr[keyIndex];
                    arr[keyIndex] = arr[i];
                    arr[i] = temp;
                }
                if(i < arr.length && i+segmentSize <arr.length){
                    i+=segmentSize;
                }else{
                    i = ++count;
                }
            }

            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            System.out.println("");
        }
        
        public static void tryWithoutArray(){ //uses two loops with out any extra array
            int[] arr = {2,-1,6,22,-2,0,8,7,9};
            //int[] arr = {2,-1,4};
        	//int[] arr = {2,-1,6,22,-2,0,8,7,9,5,4,3};
            int totalSegment = 3;
            int outerCount=0;
            int innerCount=arr.length-1;
            int count = 0;
            System.out.println("");
            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            for(int i=0; outerCount!=totalSegment;){
            	int j=i+totalSegment > arr.length-1 ? ++count : i+totalSegment; //deciding where to start j
            	innerCount--; //inner loop should execute one less time, every time 
                int index = i;
            	for(int k = innerCount;k>=0;k--){
                	//System.out.println(i+" "+j);
                	if(arr[index] > arr[j]){
                		index = j;
                	}
                	//rotating j if it has become greater than size
                	if(j < arr.length && j+totalSegment <arr.length){
                        j+=totalSegment;
                    }else{
                    	j = (j + totalSegment) - arr.length + 1;
                    }
                }
            	if(i != index){
            		int temp = arr[i];
            		arr[i] = arr[index];
            		arr[index] = temp;
            	}

                //rotating i if it becomes greater than array size
                if(i < arr.length && i+totalSegment <arr.length){
                    i+=totalSegment;
                }else{
                    i = ++outerCount;
                }
                
            }
            System.out.println("");
            for(int index = 0; index<arr.length;index++){
                System.out.print(arr[index]+" ");
            }
            System.out.println("");
        }
        
       
    
}
