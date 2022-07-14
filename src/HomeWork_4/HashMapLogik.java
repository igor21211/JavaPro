package HomeWork_4;

import java.util.*;

import static java.util.Objects.hash;

public class HashMapLogik<K, V> implements MyHashMap<K, V> {


    private Node<K, V>[] hashtable;
    private int size = 0;
    private float threshold;

    public HashMapLogik() {
        hashtable = new Node[16];
        threshold = hashtable.length * 0.75f;
    }



   private   class Node<K, V> {
        private List<Node<K, V>> nodes;
        private int hash;
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            nodes = new LinkedList<Node<K,V>>();
        }


        public List<Node<K, V>> getNodes() {

            return nodes;
        }



        private void setValue(V value){
            this.value = value;
        }

        public int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }


    }

    /**
     * We create a new array of nodes that is twice the size of the old array, then we iterate through the old array and
     * insert each node into the new array
     */
    private void arrayDoubling(){
        Node<K,V> [] oldHashTable = hashtable;
        hashtable = new Node[oldHashTable.length*2];
        size = 0;
        for(Node<K,V> node: oldHashTable){
            if(node != null){
                for (Node<K,V> n : node.getNodes()){
                    insert(n.key,n.value);
                }
            }
        }

    }


    /**
     * If the hashcodes of the new node and the node from the list are the same, and the keys and values are not the same,
     * then add the new node to the list and return true
     *
     * @param nodeFromList The node from the list that we are currently iterating over.
     * @param newNode the new node that we want to add to the list
     * @param nodes the list of nodes that are in the bucket
     * @return The method returns a boolean value.
     */
    private boolean collisionProcessing(final Node<K,V> nodeFromList,
                                        final Node <K,V> newNode,
                                        final List<Node<K,V>> nodes){
        if(newNode.hashCode() == nodeFromList.hashCode() &&
          !Objects.equals(newNode.key,nodeFromList.key) &&
        !Objects.equals(newNode.value,nodeFromList.value)){
            nodes.add(newNode);
            size++;
            return true;
        }
        return false;
    }

    /**
     * If the key exists in the list, but the value is new, then update the value
     *
     * @param nodeFromList The node from the list that we're currently iterating over.
     * @param newNode the new node that we want to add to the list
     * @param value the value to be added to the map
     * @return The method returns a boolean value.
     */
    public boolean keyExistButValueNew(final Node<K,V> nodeFromList,
                                       final Node <K,V> newNode,
                                       final V value){

        if(newNode.getKey().equals(nodeFromList.getKey()) && !newNode.getValue().equals(nodeFromList.getValue())){
            nodeFromList.setValue(value);
            return true;
        }
        return false;
    }
    /**
     * If the index is empty, create a new node with a null key and null value, and add the new node to the list of nodes
     *
     * @param index the index of the hashtable where the new node will be added
     * @param newNode The node to be added to the hashtable.
     * @return A boolean value.
     */
    private boolean simpleAdd(int index, Node<K,V> newNode){
        hashtable[index] = new Node<>(null,null);
        hashtable[index].getNodes().add(newNode);
        size++;
        return true;
    }
    /**
     * > The hash function takes a key, multiplies it by 17, and then multiplies the result by 31. It then takes the
     * modulus of the result and the length of the hashtable
     *
     * @param key The key to hash
     * @return The hash value of the key.
     */
    public int hash(final K key) {
        int hash = 31;
        hash = hash * 17 * key.hashCode();
        return hash % hashtable.length;
    }


    @Override
    // This method is adding a new node to the hashtable.
    public boolean insert(final K key, final V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            arrayDoubling();
        }

        Node<K,V> newNode = new Node<>(key, value);
        int index = hash(key);

        if(hashtable[index] == null){
            return simpleAdd(index, newNode);
        }

        List<Node<K,V>> nodeList = hashtable[index].getNodes();

        for(Node<K,V> node : nodeList){
            if(keyExistButValueNew(node,newNode,value)||
            collisionProcessing(node,newNode,nodeList)){
                return true;
            }
        }
            return false;
    }

    @Override
    // This method is deleting a node from the hashtable.
    public boolean delete(final K key) {
        int index = hash(key);
        if(hashtable[index] == null)
         return false;

        if(hashtable[index].getNodes().size()==1){
            hashtable[index] = null;
            size--;
            return true;
        }

        List<Node<K,V>> nodeList = hashtable[index].getNodes();
        for (Node<K,V> node: nodeList){
            if(key.equals(node.getKey())){
                nodeList.remove(node);
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }



    @Override
    // This method is getting the value of the node with the specified key.
    public V get(final K key) {
        int index = hash(key);
        if(index < hashtable.length && hashtable[index] !=null){

            List<Node<K,V>> list = hashtable[index].getNodes();
            for (Node<K,V> node: list){
                if(key.equals(node.getKey())){
                    return node.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<V> iterator() {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj.getClass() != getClass()) {
            Node<K, V> node = (Node) obj;
            return (Objects.equals(node.key, node.getKey()) &&
                    Objects.equals(node.value, node.getValue()) ||
                    Objects.equals(node.hash, node.hashCode()));
        }
        return false;
    }


}
