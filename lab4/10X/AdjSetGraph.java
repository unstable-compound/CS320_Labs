import java.util.*;

class  AdjSetGraph<V> implements Graph<V> {
  private Map<V,Set<V>> vertices;

  // complete the implementation by adding all the methods
  // defined in the Graph interface
  
  AdjSetGraph(){
    vertices = new HashMap<V, Set<V>>();
  }


  // Add a vertex. No-op if vertex already exists.
  public void addVertex(V v){
    if(vertices.containsKey(v))
      return;
    vertices.put(v /*key*/, new LinkedHashSet<V>() /*value = empty set*/);
  }

  // Return all the vertices 
  public Iterable<V> vertices(){
    return vertices.keySet();
  }

  // Return the number of vertices.
  public int vertexCount(){
    return vertices.size();
  }

  // Answer whether a particular vertex is in the graph
  public boolean hasVertex(V v){
    return vertices.containsKey(v);
  }

  // Add an edge between two vertices.
  // Raises IllegalArgumentException if either vertex is not in graph
  // No-op if edge already exists
  public void addEdge(V v1,V v2){

    Set<V> set1, set2;
    set1 = vertices.get(v1);  set2 = vertices.get(v2);
    //get value-sets for v1 and v2,    set1 = vertices.get(v1);  set2 = vertices.get(v2);
    //check if one V was not in the graph
    if(set1 == null || set2 == null)
    {
      throw new IllegalArgumentException();
    }
    // check if link already exists
    if(set1.contains(v2) || set2.contains(v1))
        return;


    //add link between the two
    set1.add(v2);  set2.add(v1);
    vertices.put(v1, set1);
    vertices.put(v2, set2);
  }

  // Return the neighbors of a vertex
  // Raises IllegalArgumentException if vertex is not in graph
  public Iterable<V> neighbors(V v){
    if(!vertices.containsKey(v))
      throw new IllegalArgumentException();
    return vertices.get(v);
  }

  // Return the degree (number of neighbors) of a vertex
  // Raises IllegalArgumentException if vertex is not in graph
  public int degree(V v){ 
    if(!vertices.containsKey(v))
      throw new IllegalArgumentException();
    int retval = vertices.get(v).size();

    return retval;
  }


  // (you may also wish to add private helper methods to perform
  //  tasks that are common to several public methods)

  // useful for debugging, once methods are implemented
  public String toString() {
    return GraphUtils.dumpGraph(this);
  }
}
  

	
