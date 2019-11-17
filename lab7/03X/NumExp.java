class NumExp extends Exp {
  private int num;
  NumExp(int num) {this.num = num;}


  void emit(Env<Integer> env, int depth) throws Env.UndefinedId
  {
    System.out.println("PUSH " + num);
  }
}

