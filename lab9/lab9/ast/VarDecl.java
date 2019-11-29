package ast;
import compiler.Failure;
import compiler.Position;

/** Abstract syntax for variable declarations.
 */
public class VarDecl extends PosStmt {

    /** The type of the declared variables.
     */
    private Type type;

    /** The names of the declared variables.
     */
    private Id[] vars;

    /** Default constructor.
     */
    public VarDecl(Position pos, Type type, Id[] vars) {
        super(pos);
        this.type = type;
        this.vars = vars;
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "VarDecl");
        out.indent(n+1, type.toString());
	for (Id v : vars) 
           v.indent(out, n+1);
    }

    /** Generate a pretty-printed description of this abstract syntax
     *  node using the concrete syntax of the mini programming language.
     */
    public void print(TextOutput out, int n) {
        out.indent(n);
        out.print(type.toString());
        out.print(" ");
        for (int i=0; i<vars.length; i++) {
           if (i>0) {
               out.print(", ");
           }
           out.printDef(vars[i]);
        }
        out.println(";");
    }

    /** Output a description of this node (with id n) in dot format,
     *  adding an extra node for each subtree.
     */
    public int toDot(DotOutput dot, int n) {
        int c = type.toDot(dot, n, "type", node(dot, "VarDecl", n));
        for (int i=0; i<vars.length; i++) {
            c = vars[i].toDot(dot, n, "" + i, c);
        }
        return c;
    }

    /** Run scope analysis on this statement.  The scoping parameter
     *  provides access to the scope analysis phase (in particular,
     *  to the associated error handler), and the env parameter
     *  reflects the environment at the start of the statement.  The
     *  return result is the environment at the end of the statement.
     */
    public Env analyze(ScopeAnalysis scoping, Env env) {
	for (Id v: vars) 
            env = v.extend(type, env);
        return env;
    }

    /** Generate a dot description for the environment structure of this
     *  program.
     */
    public void dotEnv(DotEnvOutput dot) {
	for (Id v: vars)
            v.dotEnv(dot);
    }

    /** Run type checker on this statement.  The typing parameter
     *  provides access to the type analysis phase (specifically,
     *  to the associated error handler).
     */
    public void analyze(TypeAnalysis typing) {
	for (Id v: vars)
            v.setType(type);
    }

    /** Run initialization analysis on this statement.  The init
     *  parameter provides access to an initialization analysis phase
     *  object (specifically, to an associated error handler).  The
     *  initialized parameter is the set of variables (each represented
     *  by pointers to environment entries) that have definitely been
     *  initialized before this statement is executed.
     */
    public VarSet analyze(InitAnalysis init, VarSet initialized) {
        return initialized; // No evaluation or initialization in a VarDecl
    }


    /** Attempt to simplify all of the expressions in this statement.
     */
    public void simplify() {
        /* nothing to simplify here */
    }

    /** Generate code for executing this statement.
     */
    public void compile(IA32Output a, int pushed) {
        /* no runtime effect (no initializer expressions) */
    }
}
