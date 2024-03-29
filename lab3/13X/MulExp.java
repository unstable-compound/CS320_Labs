class MulExp extends Exp {
  private Exp left;
  private Exp right;
  MulExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() * right.eval();
  }
  void emit() {

    out.println("PUSH " + left.eval());
    out.println("PUSH " + right.eval());
    out.println("MUL");
  }
}

