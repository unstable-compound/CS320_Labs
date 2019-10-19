class NumExp extends Exp {
  private int num;
  NumExp(int num) {this.num = num;}

  int eval() {
    return num;
  }
  void emit()
  {
    out.println("PUSH " + num); 
  }
}

