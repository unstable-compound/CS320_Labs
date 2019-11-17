class IdExp extends Exp {
    private String id;
  IdExp(String id) {this.id = id;}

  void emit(Env<Integer> env, int depth) throws Env.UndefinedId
  {
    int x_depth = env.lookup(id);
    int i = depth - x_depth;
    
    System.out.println("DUP " + (i));
    
  }
}

