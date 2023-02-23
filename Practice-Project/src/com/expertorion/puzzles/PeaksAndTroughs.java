package com.expertorion.puzzles;

import java.util.Scanner;

public class PeaksAndTroughs {
	private static int n;
	private static int peakCount=0, troughCount=0;
	
	public static void main(String [] args) {		
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("Input No. of elements in an Array : ");
		n = sc.nextInt();
		
		if(n<=0) {			
			System.out.println("Please input a positive integer : ");		    
		}
		
		int[] inputArray=new int[n];
		
		System.out.println("Input an array : ");
		for (int i=0;i<n;i++) {					
			inputArray[i] = sc.nextInt();
		}
		
		if (n==2) {
			if (inputArray[0]>inputArray[1]) {
				peakCount++;
				troughCount++;
				System.out.println(" Peak Found. Value : "+inputArray[0]);
				System.out.println(" Trough Found. Value : "+inputArray[1]);
			}
			else if (inputArray[0]<inputArray[1]) {
				peakCount++;
				troughCount++;
				System.out.println(" Peak Found. Value : "+inputArray[1]);
				System.out.println(" Trough Found. Value : "+inputArray[0]);
			}					
		}			
		
		findPeaks(inputArray) ;
		findTroughs(inputArray) ;
		
		System.out.println("----------------------------------------------");
		System.out.println("Total Peaks   Found : " + peakCount );
		System.out.println("Total Troughs found : " + troughCount );	
		System.out.println("----------------------------------------------");
	}	
	
	public static void findPeaks(int[] arr) {
		if (arr[0]>arr[1]) {
			peakCount++;
			System.out.println(" Peak  : "+arr[0]);
		}
		
				
		for ( int i=1 ; i<n-1 ; i++) {
			
			
			if ( arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
				peakCount++;
				System.out.println(" Peak  : "+arr[i]);
			}		
		}
		if (arr[n-1]>arr[n-2]) {
			peakCount++;
			System.out.println(" Peak  : "+arr[n-1]);
		}		
	}
	
	public static void findTroughs(int[] arr) {
		if (arr[0]<arr[1]) {
			troughCount++;
			System.out.println(" Trough : "+arr[0]);
		}		
		for ( int i=1 ; i<n-1 ; i++) {
			if ( arr[i] < arr[i-1] && arr[i] < arr[i+1]) {
				troughCount++;
				System.out.println(" Trough : "+arr[i]);
			}	
		}
		if (arr[n-1]<arr[n-2]) {
			troughCount++;
			System.out.println(" Trough : "+arr[n-1]);
		}
	}
}