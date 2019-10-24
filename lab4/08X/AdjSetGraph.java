import java.util.*;

class  AdjSetGraph<V> implements Graph<V> {
  private Map<V,Set<V>> vertices;

  // complete the implementation by adding all the methods
  // defined in the Graph interface

  // (you may also wish to add private helper methods to perform
  //  tasks that are common to several public methods)

  // useful for debugging, once methods are implemented
  public String toString() {
    return GraphUtils.dumpGraph(this);
  }
}
  

	
