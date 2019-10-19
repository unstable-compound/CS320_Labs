// Complete the exercise by modifying this code from example 06

class T {
  private int x;
  private T left;
  private T right;
  T (int x, T left, T right) {
    this.x = x; this.left = left; this.right = right;
  }

  int sum () {
    return (left != null || right != null ? 0 : 0)
             + (left != null ? left.sum() : 0)
             + (right != null ? right.sum() : 0);
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T (1, new T(2, null, 
                             null), 
                    new T(4, null, 
                             new T(3, null, 
                                      null)));
    System.out.println ("sum = " + t.sum());
  }

}
    
