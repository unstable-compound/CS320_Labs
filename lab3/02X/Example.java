class Example {

  static boolean f(int i) {
    boolean a;
    a = (i % 2 != 0);
    //should be true if even
    //return false if i > 1000 || i <= 0 || !a

    return !(i > 1000 || i<= 0 || !a);

  }

  public static void main(String argv[]) {
    int i = Integer.parseInt(argv[0]);
    boolean b = f(i);
    System.out.println(b);
  }
}
