class LetExp extends Exp {
  private String x;
  private Exp d;
  private Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  void emit(Env<Integer> env, int depth) throws Env.UndefinedId
  {
  
    int depth_d = depth + 1;
    int depth_e = depth + 2;
    //generate code for d
    d.emit(env.extend(x, depth), depth_d);
    //this leaves value (x) on top of the stack

    //generate code for e
    e.emit(env, depth_e);

    System.out.println("SWAP 1");
    System.out.println("POP");






    //v is depth?**** in env.extend(x, v)
  }
}

