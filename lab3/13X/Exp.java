import java.io.*;


abstract class Exp {
  PrintStream out;
  Exp(){
    out = System.out;
  }
  abstract int eval();
  abstract void emit();
}


    
