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
      Arrays.stream(a)
      .max().getAsInt();
      // replace this expression starting Arrays.stream(a)
    System.out.println(m);

    System.out.println("part b:");
    // fill in here with expression starting Arrays.stream(a)
    int b[] = 
      Arrays.stream(a)
      .filter(y -> ((y-1) % 3 == 0))
      .distinct()
      .toArray();
    Arrays.stream(b).forEachOrdered(x -> System.out.println(x));


    System.out.println("part c:");
    // fill in here with expresssion starting Arrays.stream(a)
    Arrays.stream(a)
      .dropWhile(y -> y != 0)
      .skip(1)// skip first 0
      .takeWhile(y -> y != 0)
      .forEachOrdered(x -> System.out.println(x));

    System.out.println("part d:");
    // fill in here with expresssion starting Arrays.stream(a)
    Arrays.stream(a)
      .forEachOrdered(y -> IntStream.
          range(0, y).forEach(x -> System.out.println(y)));

    System.out.println("part e:");
    int last = Arrays.stream(a)
      .reduce(0, (x,y) -> y); // replace this expression starting Arrays.stream(a)
    System.out.println(last);
  }
}
