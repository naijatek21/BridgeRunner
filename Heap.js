

class maxHeap {
  constructor() {
    this.heap = [];
  }
  insert(val) {
    //create a new child at the end of the heap
    this.heap.push(val);
    let index = this.heap.length - 1;
    this.__bubbleUp(index);
  }
  /**
   * This function returns the maximum value in the heap which is the root, i.e., the first value in the array. It does not modify the heap itself. The time complexity of this function is in O(1) constant time.
   */
  getMax() {
    if (this.heap.length != 0) return this.heap[0];
    return null;
  }
  /**
   * This function removes and returns the maximum value in the heap. The time complexity of this function is in O(log(n)) because that is the maximum number of nodes that would have to be traversed and/or swapped.
   */
  removeMax() {
    if (this.heap.length > 1) {
      let max = this.heap[0];
      // move the last child node to root
      this.heap[0] = this.heap.pop();
      this.__maxHeapify(0);
      return max;
    } else if (this.heap.length === 1) {
      return this.heap.pop();
    } else return null;
  }
  /**
   * This function restores the heap property after a node is removed. It swaps the values of the parent nodes with the values of their largest child nodes until the heap property is restored. The time complexity of this function is in O(log(n)) because that is the maximum number of nodes that would have to be traversed and/or swapped.
   */
  __maxHeapify(index) {
    while (true) {
      let leftChild = (index * 2) + 1;
      let rightChild = leftChild + 1;
      let largest = index;
      // if the leftChild exists & index value is less the left child, set the largest to leftChild
      if (this.heap.length > leftChild && this.heap[largest] < this.heap[leftChild]) largest = leftChild;
      // if the rightChild exists & index value is less the right child, set the largest to rightChild
      if (this.heap.length > rightChild && this.heap[largest] < this.heap[rightChild]) largest = rightChild;
      // if root/parent is not largest, then swap with the largest
      if (largest !== index) {
        let temp = this.heap[largest];
        this.heap[largest] = this.heap[index];
        this.heap[index] = temp;
        this.__maxHeapify(largest);
      } else break;
    }

  }
  /**
   * This function restores heap property by swapping the value at a parent node if it is less than the value at a child node. The time complexity of this function is in O(log(n)) because that is the maximum number of nodes that would have to be traversed and/or swapped.
   */
  __bubbleUp(index) {
    //Fetch the element that has to be moved
    const element = this.heap[index];
    while (index > 0) {
      // Find the parent element's index and fetch it
      let parentIndex = Math.floor((index - 1) / 2);
      let parent = this.heap[parentIndex];
      // if parent is lesser than child,then swap
      if (parent.speed <= element.speed) {
        this.heap[parentIndex] = element;
        this.heap[index] = parent;
        index = parentIndex;
      } else break;
    }
  }

  /**
   * Let’s build a max-heap now. Suppose we have nn elements in an array which represents our heap. For every node to be positioned in accordance with the max-heap property, we call the _maxHeapify method at every index of that array, starting from the bottom of the heap
   */
  buildHeap(arr) {
    this.heap = arr;
    for (let i = this.heap.length - 1; i >= 0; i--) {
      this.__maxHeapify(i);
    }
  }
}

// var tree = new maxHeap()
// var arr = [6, 9, 3, 4, 13, 22, 1, 30, 17]
// tree.buildHeap(arr)
// console.log(tree.heap)
// tree.removeMax();
// console.log(tree.getMax())
// console.log(tree.heap);