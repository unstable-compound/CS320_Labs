public class ArrayObjSequence implements ObjSequence {
  final static private int INITIAL_CAPACITY = 10;

  private Object[] contents;
  private int size;

  ArrayObjSequence() {
    contents = new Object[INITIAL_CAPACITY];
    size = 0;
  }

  // Double the array size whenever we run out of room.
  // (This can save exponential time at the cost of up to 2X wasted space.)
  private void ensureOneMore() {
    if (size >= contents.length) {
      int newCapacity = contents.length * 2;
      contents = java.util.Arrays.copyOf(contents,newCapacity);
    }
  }    

  public void append(Object e) {
    ensureOneMore();
    contents[size++] = e;
  }

  public void prepend(Object e) {
    ensureOneMore();
    System.arraycopy(contents, 0, contents, 1, size);
    contents[0] = e;
    size++;
  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if (index < 0 || index >= size)
      throw new IllegalArgumentException("index " + index  + " out of range");
    return contents[index];
  }

}
