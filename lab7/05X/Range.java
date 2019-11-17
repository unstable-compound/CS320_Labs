import java.util.*;

class Range implements Iterable<Integer>{
  int low;
  int high;
  Range(int low, int high) {this.low = low; this.high = high;}
  public Iterator<Integer> iterator(){
    return new RangeIterator();
  }

  private class RangeIterator implements Iterator<Integer>{
    int current;
    RangeIterator() {current = low;}
    public boolean hasNext(){
      return (current < high);
    }
    public Integer next(){
      if (current < high)
      {
        int retval = current;
        current += 1;
        return retval;
      }
      else
        throw new NoSuchElementException();
    }
  }

}


