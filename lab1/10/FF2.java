import java.io.*;
class FF2{
  public static void main (String argv[]) throws IOException {
    final int STACK_SIZE = 1024;
    final int[] stack = new int[STACK_SIZE];
    int sp = -1;
    stack[++sp] = 0;
    stack[++sp] = System.in.read();
    {int t = stack[sp-0]; stack[++sp] = t;}
    stack[++sp] = -10;
    stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
    while (stack[sp--] != 0) {
      stack[++sp] = -48;
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
      {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
      stack[++sp] = 10;
      stack[sp-1] = stack[sp-1] * stack[sp]; sp--;
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
      stack[++sp] = System.in.read();
      {int t = stack[sp-0]; stack[++sp] = t;}
      stack[++sp] = -10;
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
    }
    sp--;
    stack[++sp] = 1;
    {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
    {int t = stack[sp-0]; stack[++sp] = t;}
    while (stack[sp--] != 0) {
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[++sp] = 3;
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[++sp] = 3;
      stack[sp-1] = stack[sp-1] / stack[sp]; sp--;
      stack[sp-1] = stack[sp-1] * stack[sp]; sp--;
      stack[sp] = - stack[sp];
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
      {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
      stack[++sp] = 5;
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[++sp] = 5;
      stack[sp-1] = stack[sp-1] / stack[sp]; sp--;
      stack[sp-1] = stack[sp-1] * stack[sp]; sp--;
      stack[sp] = - stack[sp];
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
      {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
      sp--;
      stack[++sp] = 1;
      {int t = stack[sp-2]; stack[++sp] = t;}
      stack[++sp] = 0;
      stack[sp-1] = stack[sp-1] <= stack[sp] ? -1 : 0; sp--;
      while (stack[sp--] != 0) {
        sp--;
        stack[++sp] = 0;
        stack[++sp] = 70;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 108;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 105;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 109;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 0;
      }
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[++sp] = 0;
      stack[sp-1] = stack[sp-1] <= stack[sp] ? -1 : 0; sp--;
      while (stack[sp--] != 0) {
        sp--;
        stack[++sp] = 0;
        stack[++sp] = 70;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 108;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 97;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 109;
        System.out.write((byte) stack[sp--]); System.out.flush();
        stack[++sp] = 0;
      }
      while (stack[sp--] != 0) {
        {int t = stack[sp-3]; stack[++sp] = t;}
        System.out.print(stack[sp--]); System.out.flush();
        stack[++sp] = 0;
      }
      sp--;
      sp--;
      stack[++sp] = 10;
      System.out.write((byte) stack[sp--]); System.out.flush();
      {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
      stack[++sp] = 1;
      stack[sp-1] = stack[sp-1] + stack[sp]; sp--;
      {int t = stack[sp-1]; stack[sp-1] = stack[sp]; stack[sp] = t;}
      {int t = stack[sp-1]; stack[++sp] = t;}
      {int t = stack[sp-1]; stack[++sp] = t;}
      stack[sp-1] = stack[sp-1] <= stack[sp] ? -1 : 0; sp--;
    }
    stack[++sp] = 10;
    System.out.write((byte) stack[sp--]); System.out.flush();
    }
  }
