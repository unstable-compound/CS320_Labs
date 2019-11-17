class MulExp extends Exp {
  private Exp left;
  private Exp right;
  MulExp (Exp left, Exp right) {this.left = left; this.right = right;}

  void emit(Env<Integer> env, int depth) throws Env.UndefinedId
  {
    depth += 1;
  
    this.left.emit(env, depth);
    
    this.right.emit(env, depth+=1);
    System.out.println("MUL");

  }
}

