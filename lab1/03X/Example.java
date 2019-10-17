//Excercise 03 in Homework One
//CS320
//Curtis Lewis
//10/4/2019

class Example {
  public static void main(String argv[]) {
    int n = Integer.parseInt(argv[0]);
    for(int i = 1; i <=n; ++i)
    {
      if(i % 3 != 0 && i % 5 != 0)
      {
        System.out.println(i);
      }
      else{
        if(i % 3 == 0)
        {
          System.out.print("Flim");
        }
        if(i %5 == 0)
        {
          System.out.print("Flam");
        }
        System.out.println();
      }

    }

  }

}

