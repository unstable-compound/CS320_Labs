abstract class Exp {
  abstract int eval();
}

class NumExp extends Exp {
  private int num;
  NumExp(int num) {this.num = num;}

  int eval() {
    return num;
  }
}

class AddExp extends Exp {
  private Exp left;
  private Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() + right.eval();
  }
}

class SubExp extends Exp {
  private Exp left;
  private Exp right;
  SubExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() - right.eval();
  }
}

class Example {
  public static void main(String argv[]) {
    Exp e = new SubExp(new NumExp(5),
                       new AddExp(new NumExp(2),
                                  new NumExp(3)));

    System.out.println("value = " + e.eval());
  }
}



    