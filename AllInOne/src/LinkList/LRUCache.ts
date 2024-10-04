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

/**
 *
 * Refactoring version
 * 
 * 
 * Key Changes in the Refactor:
Interface ICache<K, V>:
1.
Defines the contract that all cache implementations should follow, with get and put methods.
This interface is generic (K, V) for flexibility in the types of keys and values.
Abstract Class CacheBase<K, V>:
2.
Provides a common base class for all cache types.
Contains the shared logic for managing capacity and the hash map (map), ensuring DRY principles 
are followed. Enforces the structure of cache-related methods (get and put) but leaves their 
implementation to derived classes. It also provides helper methods like isAtCapacity to avoid 
repeating capacity-checking logic.LRUCache<K, V>:
3.
Extends CacheBase<K, V> to inherit common cache functionality.
Implements the specific logic for the LRU cache, such as moving nodes to the head when accessed and 
removing the least recently used node.
The doubly linked list operations remain similar to the previous solution.
Extensibility:
4.
New cache types like FIFO or LFU could be implemented by extending CacheBase<K, V> and implementing 
their own eviction policies while reusing common logic like managing capacity and storing key-value
 pairs.
 *
 */
// Interface for a generic cache
interface ICache<K, V> {
  get(key: K): V | -1;
  put(key: K, value: V): void;
}

// Doubly Linked List Node class
class ListNode<K, V> {
  key: K;
  value: V;
  prev: ListNode<K, V> | null;
  next: ListNode<K, V> | null;

  constructor(key: K, value: V) {
    this.key = key;
    this.value = value;
    this.prev = null;
    this.next = null;
  }
}

// Abstract base class for caches
abstract class CacheBase<K, V> implements ICache<K, V> {
  protected capacity: number;
  protected map: Map<K, ListNode<K, V>>;

  constructor(capacity: number) {
    this.capacity = capacity;
    this.map = new Map<K, ListNode<K, V>>();
  }

  abstract get(key: K): V | -1;

  abstract put(key: K, value: V): void;

  // Method to check if the cache is at capacity
  protected isAtCapacity(): boolean {
    return this.map.size >= this.capacity;
  }
}

// LRUCache class implementing CacheBase
class LRUCache2<K, V> extends CacheBase<K, V> {
  private head: ListNode<K, V>;
  private tail: ListNode<K, V>;

  constructor(capacity: number) {
    super(capacity);

    // Dummy head and tail nodes to simplify list operations
    this.head = new ListNode<K, V>(null as unknown as K, null as unknown as V);
    this.tail = new ListNode<K, V>(null as unknown as K, null as unknown as V);

    this.head.next = this.tail;
    this.tail.prev = this.head;
  }

  // Override the get method from CacheBase
  get(key: K): V | -1 {
    const node = this.map.get(key);
    if (!node) {
      return -1; // If key doesn't exist, return -1
    }

    // Move the accessed node to the head (most recently used)
    this.moveToHead(node);
    return node.value;
  }

  // Override the put method from CacheBase
  put(key: K, value: V): void {
    const node = this.map.get(key);

    if (node) {
      // Update value and move the node to the head (most recently used)
      node.value = value;
      this.moveToHead(node);
    } else {
      // Create a new node
      const newNode = new ListNode<K, V>(key, value);
      this.map.set(key, newNode);
      this.addNode(newNode);

      // If over capacity, remove the least recently used node
      if (this.isAtCapacity()) {
        const tail = this.removeTail();
        if (tail) {
          this.map.delete(tail.key);
        }
      }
    }
  }

  // Method to add a node at the head (most recently used position)
  private addNode(node: ListNode<K, V>): void {
    node.prev = this.head;
    node.next = this.head.next;

    if (this.head.next) {
      this.head.next.prev = node;
    }
    this.head.next = node;
  }

  // Method to remove a node from the doubly linked list
  private removeNode(node: ListNode<K, V>): void {
    const prevNode = node.prev;
    const nextNode = node.next;

    if (prevNode) prevNode.next = nextNode;
    if (nextNode) nextNode.prev = prevNode;
  }

  // Method to move a node to the head (most recently used position)
  private moveToHead(node: ListNode<K, V>): void {
    this.removeNode(node);
    this.addNode(node);
  }

  // Method to remove the least recently used (LRU) node, just before the tail
  private removeTail(): ListNode<K, V> | null {
    const lruNode = this.tail.prev;
    if (lruNode && lruNode !== this.head) {
      this.removeNode(lruNode);
      return lruNode;
    }
    return null;
  }
}

// Example usage:
const lruCache = new LRUCache2<number, number>(2);
lruCache.put(1, 1); // Cache is {1=1}
lruCache.put(2, 2); // Cache is {1=1, 2=2}
console.log(lruCache.get(1)); // returns 1, Cache is {2=2, 1=1}
lruCache.put(3, 3); // Evicts key 2, Cache is {1=1, 3=3}
console.log(lruCache.get(2)); // returns -1 (not found)
lruCache.put(4, 4); // Evicts key 1, Cache is {3=3, 4=4}
console.log(lruCache.get(1)); // returns -1 (not found)
console.log(lruCache.get(3)); // returns 3, Cache is {4=4, 3=3}
console.log(lruCache.get(4)); // returns 4, Cache is {3=3, 4=4}

// Example of FIFO implementation
// class FIFOCache<K, V> extends CacheBase<K, V> {
//   private queue: K[] = [];

//   get(key: K): V | -1 {
//       const node = this.map.get(key);
//       return node ? node.value : -1;
//   }

//   put(key: K, value: V): void {
//       if (this.map.has(key)) {
//           this.map.get(key)!.value = value;
//       } else {
//           if (this.isAtCapacity()) {
//               const oldestKey = this.queue.shift();
//               if (oldestKey) this.map.delete(oldestKey);
//           }
//           this.queue.push(key);
//           this.map.set(key, new ListNode(key, value));
//       }
//   }
// }
