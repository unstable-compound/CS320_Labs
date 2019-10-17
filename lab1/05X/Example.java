//Curtis Lewis
//Excercise 05 - Homework 1
//10/4/2019


import java.io.*;
import java.nio.file.*;
import java.util.*;

class Example {
  public static void main (String argv[]) throws IOException {
    int[] list = readIntArray(argv[0]);




    int numBelowBounds = 0;
    int numAboveBounds = 0;
    //get number of bins
    int numBins = Integer.parseInt(argv[1]);
  
    //get min in lowest bin
    int min = Integer.parseInt(argv[2]);

    //get size of each bin
    int binSize = Integer.parseInt(argv[3]);


    int [] Bins = new int[numBins];
    int max = min + (binSize * numBins);

    //get lower and upper
    for(int i = 0; i < list.length; ++i)
    {
      if(list[i] < min)
      {
        numBelowBounds +=1;
      }
      else if(list[i] >= max)
      {
        numAboveBounds +=1;
      }
    }

    //get num for each bin.
    int lowerBound = min;
    int upperBound = min + binSize;


    System.out.println("x < " + min + ":" + " " + numBelowBounds);
    for(int i = 0; i < Bins.length; ++i)
    {
      Bins[i] = calcNumInThisRange(lowerBound, upperBound, list);
      System.out.println(lowerBound + " <= x < " + upperBound + ": " + Bins[i]);
      lowerBound = upperBound;
      upperBound += binSize;
    }

    System.out.println("x >= " + max + ": " + numAboveBounds);




  }

  private static int calcNumInThisRange(int min, int max, int [] list){
    int num = 0;
    for(int i = 0; i < list.length; i++)
    {
      if(list[i] >= min && list[i] < max)
      {
        num++;
      }
    }
    return num;
  }


  private static int[] readIntArray(String filename) throws IOException {
    try (BufferedReader f = Files.newBufferedReader(Paths.get(filename));
	 Scanner sc = new Scanner(f)) {
      int n = sc.nextInt();
      int[] is = new int[n];
      for (int i = 0; i < n; i++)
	is[i] = sc.nextInt();
      return is;
    }
  }
}


