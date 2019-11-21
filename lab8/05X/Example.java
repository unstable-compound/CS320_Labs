import java.util.*;
import java.util.stream.*;

class Example {

  public static void main(String argv[]) {
    int a[] =
      Arrays.stream(argv)
      .mapToInt(s -> Integer.parseInt(s))
      .toArray();

    System.out.println("part a:");
    int m = 
      0; // replace this expression starting Arrays.stream(a)
    System.out.println(m);

    System.out.println("part b:");
    // fill in here with expresssion starting Arrays.stream(a)

    System.out.println("part c:");
    // fill in here with expresssion starting Arrays.stream(a)

    System.out.println("part d:");
    // fill in here with expresssion starting Arrays.stream(a)

    System.out.println("part e:");
    int last = 0; // replace this expression starting Arrays.stream(a)
    System.out.println(last);
  }
}
