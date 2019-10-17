import java.io.*;

/** Simple recursive-descent parser for simple language of arithmetic expressions, generating SM code as output
*/

class Parser {
  
  /** Class is parameterized by lexer and output streams. 
   */
  Parser(Lexer lexer, PrintStream out) {
    this.lexer = lexer; this.out = out;
  }

  private Lexer lexer; 
  private PrintStream out;

  /** Public entry point to parser and SM generator. 
   */
  void parse() throws Failure {
    lexer.nextToken();  // get initial token in place
    // input should be a single expression
    //parseExpr();
    parseComp();
    require(Token.EOF);
    // and we want to print its value
    emit("PRINTI");
    emit("PUSH 10");
    emit("PRINTC");
  }


  // primary : NUMBER
  //         | ( expr )

  private void parsePrimary() throws Failure {
    switch (lexer.token) {
      case TRUE:
        emit("PUSH -1");
        lexer.nextToken();
        return;
      case FALSE:
        emit("PUSH 0");
        lexer.nextToken();
        return;
    case NUMBER:
      emit("PUSH %s",lexer.lexeme);
      lexer.nextToken();
      return;
    case LPAR:
      lexer.nextToken();
      parseComp();
      require(Token.RPAR);
      return;
    default: throw unexpectedToken();
    }
  }

  // factor : - factor
  //        : primary
  private void parseFactor() throws Failure {
    switch (lexer.token) {
      case NOT:
        lexer.nextToken();
        parseFactor();
        emit("NOT");
        return;
    case MINUS:
      lexer.nextToken();
      parseFactor();
      emit("NEG");
      return;
    default:
      parsePrimary();
      return;
    }
  }

  // term : term  * factor
  //      | term / factor
  //      | factor
  // to avoid left-recursion, process this as
  // term : factor { (*|/) factor }
  private void parseTerm() throws Failure {
    parseFactor();
    while (true) {
      switch (lexer.token) {
        case AND:
          lexer.nextToken();
          parseFactor();
          emit("AND");
          break;
        case TIMES: 
          lexer.nextToken();
          parseFactor();
          emit("MUL");
          break;
        case DIVIDE:
          lexer.nextToken();
          parseFactor();
          emit("DIV");
          break;
        default:
          return;
      }
    }
  }

  // expr    : expr + term
  //         | expr - term
  //         | term
  // to avoid left-recursion, process this as
  // expr : term { (+|-) term }
  private void parseExpr() throws Failure {
    parseTerm();
    while (true) {
      switch(lexer.token) {
        case OR:
          lexer.nextToken();
          parseTerm();
          emit("NOT");
          emit("SWAP 1");
          emit("NOT");
          emit("AND");
          emit("NOT");
          break;
        case PLUS:
          lexer.nextToken();
          parseTerm();
          emit("ADD");
          break;
        case MINUS:
          lexer.nextToken();
          parseTerm();
          emit("NEG");
          emit("ADD");
          break;
        default:
          return;
      }
    }
  }

  // comp   : expr <= expr
  //        | expr
  //
  //comp  : expr {<= expr}
  private void parseComp() throws Failure{
    parseExpr();
    while(true)
    {
      switch (lexer.token) {
        case LEQ:
          lexer.nextToken();
          parseExpr();

          ban(Token.LEQ);//should cause error if second <= is found.
          emit("LEQ");
          break;

        default:
          return;
      }
    }

  }

  class Failure extends Exception {
    Failure(String text) {
      super(text);
    }
  }

  private Failure unexpectedToken() {
    return new Failure("Unexpected " + lexer.token.rep);
  }

  private void ban(Token tok) throws Failure{
    if(lexer.token == tok){
      throw new Failure("Expected no more " + tok.rep + "in this scope.");
    }
    //lexer.nextToken();
  }

  private void require(Token tok) throws Failure {
    if (lexer.token!=tok) {
      throw new Failure("Expected " + tok.rep + " but found " + lexer.token.rep);
    }
    lexer.nextToken();
  }

  private void emit(String s, Object... args) {
    out.printf(s,args);
    out.println();
  }
}    
