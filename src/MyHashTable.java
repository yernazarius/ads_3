import java.util.Stack;

public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        this.chainArray = new HashNode[this.M];
    }

    public MyHashTable(int M) {
        if(M < 1) throw new IllegalArgumentException("M must be greater than 0");
        this.M = M;
        chainArray = new HashNode[this.M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % M);
    }

    public void put(K key, V value) {
        this.size++;
        int index = hash(key);
        if(chainArray[index] == null){
            chainArray[index] = new HashNode(key, value);
        } else {
            HashNode<K, V> head = chainArray[index];
            while(head.next != null) {
                head = head.next;
            }
            head.next = new HashNode(key, value);
        }
    }
    public V get (K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        while (head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> head = chainArray[index];
        HashNode<K, V> prev = null;
        while (head != null) {
            if(head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if(head == null) return null;
        this.size--;
        if(prev != null) {
            prev.next = head.next;
        } else {
            chainArray[index] = head.next;
        }
        return head.value;
    }
    public boolean contains(V value) {
        for(int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if(head.value.equals(value)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for(int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if(head.value.equals(value)) {
                    return head.key;
                }
                head = head.next;
            }
        }
        return null;
    }
    public int[] printBucketSize() {
        int[] bucketSize = new int[M];
        for(int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                bucketSize[i]++;
                head = head.next;
            }
        }
        return bucketSize;
    }

}