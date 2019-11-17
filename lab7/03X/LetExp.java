class LetExp extends Exp {
  private String x;
  private Exp d;
  private Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  void emit(Env<Integer> env, int depth) throws Env.UndefinedId
  {
  
    
    //generate code for d

    d.emit(env, depth);
    //this leaves value (x) on top of the stack

    env = env.extend(x, depth += 1);
    //generate code for e
    e.emit(env, depth);

    System.out.println("SWAP 1");
    System.out.println("POP");






    //v is depth?**** in env.extend(x, v)
  }
}

