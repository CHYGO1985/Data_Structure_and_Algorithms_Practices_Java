class CacheNode {
  key: number;
  value: number;
  prev: CacheNode | null;
  next: CacheNode | null;

  constructor(key: number, value: number) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

class LRUCache1 {
  private capacity: number;
  private map: Map<number, CacheNode>;
  private head: CacheNode;
  private tail: CacheNode;

  constructor(capacity: number) {
    this.capacity = capacity;
    this.map = new Map<number, CacheNode>();

    // dummy head and tail to avoid null checks
    this.head = new CacheNode(0, 0);
    this.tail = new CacheNode(0, 0);

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  // Move a node to the head (most recently used)
  private moveToHead(node: CacheNode): void {
    this.removeNode(node);
    this.addNode(node);
  }

  // Remove a node from the linked list
  private removeNode(node: CacheNode): void {
    const prev = node.prev;
    const next = node.next;

    if (prev) prev.next = next;
    if (next) next.prev = prev;
  }

  // Add a node right after the head (most recently used position)
  private addNode(node: CacheNode): void {
    node.prev = this.head;
    node.next = this.head.next;

    if (this.head.next) this.head.next.prev = node;
    this.head.next = node;
  }

  // Remove the least recently used (LRU) node, which is before the tail
  private removeTail(): CacheNode {
    const lru = this.tail.prev!;
    this.removeNode(lru);
    return lru;
  }

  get(key: number): number {
    const node = this.map.get(key);
    if (!node) return -1;

    // Move the accessed node to the head (most recently used)
    this.moveToHead(node);

    return node.value;
  }

  put(key: number, value: number): void {
    const node = this.map.get(key);

    if (node) {
      // Update the value and move to the head
      node.value = value;
      this.moveToHead(node);
    } else {
      // Add a new node
      const newNode = new CacheNode(key, value);
      this.map.set(key, newNode);
      this.addNode(newNode);

      // If over capacity, remove the LRU node
      if (this.map.size > this.capacity) {
        const tail = this.removeTail();
        this.map.delete(tail.key);
      }
    }
  }
}
