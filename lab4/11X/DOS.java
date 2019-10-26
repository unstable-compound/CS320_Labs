import java.util.*;



public class DOS {
   public static void main(String argv[]) throws Exception {
    String filename = argv[0];
    String[] fields = filename.split("[.]");
    int distance = 0;
    
    if (fields[1].equals("ig")) {


      Graph<Integer> g = GraphUtils.readIntegerGraph(fields[0]);

      Integer source_node = Integer.parseInt(argv[1]);
      Integer dest_node = Integer.parseInt(argv[2]);

      BreadthFirstPaths <Integer> BFP = new BreadthFirstPaths<Integer>(g, source_node); 
      distance = BFP.distTo(dest_node);
      Deque<Integer> path = BFP.pathTo(dest_node);

      System.out.println("Degrees of Separation: " + distance);
      System.out.println("Path: ");
      for(Integer item: path){
        System.out.println(item);
      }



    } else if (fields[1].equals("sg")) {


      Graph<String> g = GraphUtils.readStringGraph(fields[0],argv[1]);
      String source_node = argv[2];
      String dest_node = argv[3];

      BreadthFirstPaths <String> BFP = new BreadthFirstPaths<String>(g, source_node); 
      distance = BFP.distTo(dest_node);
      Deque<String> path = BFP.pathTo(dest_node);

      System.out.println("Degrees of Separation: " + distance);
      System.out.println("Path: ");
      for(String item: path){
        System.out.println(item);
      }

    }


    
  }

}
