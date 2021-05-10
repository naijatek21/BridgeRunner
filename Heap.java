
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * An instance is a max-heap or a min-heap of distinct values of type E <br>
 * with priorities of type double.
 */
public class Heap<E> {

  protected VP[] b;
  protected int size;
  protected HashMap<E, Integer> map; // "map" for dictionary

  /**
   * Constructor: an empty heap with capacity 10. <br>
   * It is a min-heap if isMin is true, a max-heap if isMin is false.
   */
  public Heap() {
    b = createVPArray(10);
    map = new HashMap<>();
  }

  /** A VP object houses a value and a priority. */
  class VP {
    E val; // The value
    double priority; // The priority

    /** An instance with value v and priority p. */
    VP(E v, double p) {
      val = v;
      priority = p;
    }

    /** Return a representation of this VP object. */
    @Override
    public String toString() {
      return "(" + val + ", " + priority + ")";
    }
  }

  /**
   * Add v with priority p to the heap. <br>
   * Throw an illegalArgumentException if v is already in the heap. <br>
   * The expected time is logarithmic and the <br>
   * worst-case time is linear in the size of the heap.
   */
  public void add(E v, double p) throws IllegalArgumentException {

    if (map.get(v) != null)
      throw new IllegalArgumentException();
    ensureSpace();
    map.put(v, size);
    size += 1;
    b[size - 1] = new VP(v, p);
    bubbleUp(size - 1);

  }

  /**
   * If size = length of b, double the length of array b. <br>
   * The worst-case time is proportional to the length of b.
   */
  protected void ensureSpace() {
    if (size == b.length)
      b = Arrays.copyOf(b, 2 * b.length);

  }

  /**
   * Return the size of this heap. <br>
   * This operation takes constant time.
   */
  public int size() { // Do not change this method
    return size;
  }

  /**
   * Swap b[i] and b[j]. <br>
   * Precondition: 0 <= i < heap-size, 0 <= j < heap-size.
   */
  void swap(int i, int j) {
    assert 0 <= i && i < size && 0 <= j && j < size;
    // TODO 3: When bubbling values up and (later on) down, two values,
    // say b[i] and b[j], will have to be swapped. At the same time,
    // the definition of map has to be maintained.
    // In order to always get this right, always use method swap for this.
    // Method swap is tested by testing procedure test12Swap
    // --it will find no errors if you write this method properly.
    VP temp = b[i];
    b[i] = b[j];
    map.put(b[j].val, i);
    b[j] = temp;
    map.put(temp.val, j);

  }

  /**
   * If a value with priority p1 should be above a value with priority p2 in the
   * heap, return 1. If priority p1 and priority p2 are the same, return 0. <br>
   * If a value with priority p1 should be below a value with priority p2 in the
   * heap, return -1. This is based on what kind of a heap this is, <br>
   * ... E.g. a min-heap, the value with the smallest priority is in the root.
   * <br>
   * ... E.g. a max-heap, the value with the largest priority is in the root.
   */
  public int compareTo(double p1, double p2) {
    if (p1 == p2)
      return 0;
    return p1 > p2 ? 1 : -1;
  }

  /**
   * If b[h] should be above b[k] in the heap, return 1.<br>
   * If b[h]'s priority and b[k]'s priority are the same, return 0. <br>
   * If b[h] should be below b[k] in the heap, return -1. <br>
   * This is based on what kind of a heap this is, <br>
   * ... E.g. a max-heap, the value with the largest priority is in the root. <br>
   * ... E.g. a min-heap, the value with the smallest priority is in the root.
   */
  public int compareTo(int h, int k) {
    return compareTo(b[h].priority, b[k].priority);
  }

  /**
   * Bubble b[k] up the heap to its right place. <br>
   * Precondition: 0 <= k < size and <br>
   * The class invariant is true, except perhaps that b[k] belongs above its <br>
   * parent (if k > 0) in the heap, not below it.
   */
  void bubbleUp(int k) {
    // TODO #4 This method should be called within insert in order
    // to bubble a value up to its proper place, based on its priority.
    // Do not use recursion. Use iteration.
    // Use method compareTo to test whether value k is in its right place.
    // If this method is written properly, testing procedures test13ensureSpace,
    // test15insert_BubbleUp(), test16insertMaxHeap_BubbleUp,
    // test17insert_BubbleUpDuplicatePriorities, and
    // test17insertMax_BubbleUpDuplicatePriorities will not find any errors.
    assert 0 <= k && k < size;
    int par = (k - 1) / 2;
    while (compareTo(par, k) == -1) {
      swap(k, par);
      k = par;
      par = (par - 1) / 2;
    }

  }

  /**
   * If this is a max-heap, return the heap value with highest priority. <br>
   * Do not change the heap. <br>
   * Throw a NoSuchElementException if the heap is empty.<br>
   * This operation takes constant time.
   */
  public E peek() {
    if (b.length == 0)
      throw new NoSuchElementException();
    return b[0].val;
  }

  /**
   * If k is not in 0..size-1, return. <br>
   * OTHERWISE:<br>
   * Bubble b[k] down in heap until it finds the right place. <br>
   * If there is a choice to bubble down to both the left and right children<br>
   * (because their priorities are equal), choose the right child. <br>
   * Precondition: 0 <= k < size and class invariant is true except that <br>
   * perhaps b[k] belongs below one or both of its children.
   */
  void bubbleDown(int k) {
    assert 0 <= k && k < size;
    if (!map.containsKey(b[k].val))
      return;

    int ch;

    while (2 * k + 1 < size) {
      ch = TargetChild(k);
      if (compareTo(k, ch) == -1) {
        swap(k, ch);
        k = ch;
      } else
        return;

    }

  }

  public int TargetChild(int i) {
    int c = 2 * i + 2; // is right child
    if (c >= size || compareTo(c - 1, c) == 1) {
      c = c - 1;
    }
    return c;
  }

  /**
   * If this is a max-heap, remove and return the heap value with highest
   * priority.<br>
   * Throw a NoSuchElementException if the heap is empty.<br>
   * The expected time is logarithmic and the worst-case time is linear in the
   * <br>
   * size of the heap. .
   */
  public E poll() {
    if (size == 0)
      throw new NoSuchElementException();
    E v = b[0].val;
    map.remove(b[0].val);
    size -= 1;
    if (size > 0) {
      b[0] = b[size];
      map.put(b[size].val, 0);
      b = Arrays.copyOf(b, b.length - 1);
      bubbleDown(0);
    }
    return v;
  }

  /**
   * Create and return an array of size n. <br>
   * This is necessary because generics and arrays don't interoperate nicely. <br>
   */
  VP[] createVPArray(int n) {
    return (VP[]) Array.newInstance(VP.class, n);
  }

  public VP[] getVPArray() {
    return b;
  }
}