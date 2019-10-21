class AddExp extends Exp {
  private Exp left;
  private Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() + right.eval();
  }
  void emit() {

    this.left.emit();
    this.right.emit();
    out.println("ADD");

  }
}

