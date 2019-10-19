class NegExp extends Exp {
  private Exp right;
  NegExp(Exp right) {this.right = right;}

  int eval() {
    return -right.eval();
  }
 
  void emit() {
    
    out.println("PUSH " + right.eval());
    out.println("NEG");
  }
}

