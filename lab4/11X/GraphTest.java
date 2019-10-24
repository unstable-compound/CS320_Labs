public class GraphTest {

  public static void main(String argv[]) throws Exception {
    String filename = argv[0];
    String[] fields = filename.split("[.]");
    if (fields[1].equals("ig")) {
      Graph<Integer> g = GraphUtils.readIntegerGraph(fields[0]);
      GraphUtils.toDot(g,fields[0]);
    } else if (fields[1].equals("sg")) {
      Graph<String> g = GraphUtils.readStringGraph(fields[0],argv[1]);
      GraphUtils.toDot(g,fields[0]);
    }
  }
}
