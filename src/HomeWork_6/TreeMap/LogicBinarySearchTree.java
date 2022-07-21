package HomeWork_6.TreeMap;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class LogicBinarySearchTree <T extends Comparable<T>> implements BinarySearchTree<T>  {
    private static class Node<T> {
        T element;
        Node<T> left;
        Node<T> right;

        public Node(T element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node<T> root;
    private int size;

    /**
     * Create a new LogicBinarySearchTree and insert all the elements into it.
     *
     * @return A new LogicBinarySearchTree object.
     */
    public static <T extends Comparable<T>> LogicBinarySearchTree<T> of(T... elements) {
        LogicBinarySearchTree bst = new LogicBinarySearchTree();
        Stream.of(elements)
                .forEach(bst::insert);
        return bst;
    }

    @Override
    // This method is checking if the root is null, if it is, it will create a new node and set the root to that node. If
    // the root is not null, it will call the insert method with the root and the element.
    public boolean insert(T element) {
        if (root == null) {
            root = new Node<>(element);
            size++;
            return true;
        } else {
            return insert(root, element);
        }
    }


    /**
     * If the element is less than the current node, insert it in the left subtree, otherwise insert it in the right
     * subtree
     *
     * @param current The current node we are looking at.
     * @param element The element to be inserted.
     * @return The boolean value of whether or not the element was inserted.
     */
    private boolean insert(Node<T> current, T element) {
        if (element.compareTo(current.element) < 0) {
            if (current.left == null) {
                current.left = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.left, element);
            }
        } else if (element.compareTo(current.element) > 0) {
            if (current.right == null) {
                current.right = new Node<>(element);
                size++;
                return true;
            } else {
                return insert(current.right, element);
            }
        } else {
            return false;
        }
    }

    /**
     * If the root is null, return false. Otherwise, if the root is the element, return true. Otherwise, if the element is
     * less than the root, return the result of calling contains on the left subtree. Otherwise, return the result of
     * calling contains on the right subtree
     *
     * @param element the element to be searched for
     * @return The boolean value of whether or not the element is in the tree.
     */
    @Override
    public boolean contains(T element) {
        return contains(root, element);
    }

    /**
     * If the current node is null, then the element is not in the tree. Otherwise, if the element is less than the current
     * node's element, then the element is in the left subtree. Otherwise, if the element is greater than the current
     * node's element, then the element is in the right subtree. Otherwise, the element is equal to the current node's
     * element, so the element is in the tree
     *
     * @param current the current node
     * @param element the element to search for
     * @return The boolean value of whether or not the element is in the tree.
     */
    private boolean contains(Node<T> current, T element) {
        if (current == null) {
            return false;
        } else if (element.compareTo(current.element) < 0) {
            return contains(current.left, element);
        } else if (element.compareTo(current.element) > 0) {
            return contains(current.right, element);
        } else {
            return true;
        }
    }

    @Override
    // Returning the size of the tree.
    public int size() {
        return size;
    }

    @Override
    // This is a recursive method that is returning the depth of the tree.
    public int depth() {
        return root != null ? depth(root) - 1 : 0;
    }

    /**
     * If the current node is null, return 0. Otherwise, return 1 plus the maximum of the depths of the left and right
     * subtrees
     *
     * @param current the current node
     * @return The depth of the tree.
     */
    private int depth(Node<T> current) {
        if (current == null) {
            return 0;
        } else {
            return 1 + Math.max(depth(current.left), depth(current.right));
        }
    }

    @Override
    // This is a recursive method that is returning the depth of the tree.
    public void inOrderTraversal(Consumer<T> consumer) {
        inOrderTraversal(root,consumer);
    }
    /**
     * If the current node is not null, then traverse the left subtree, visit the current node, and then traverse the right
     * subtree.
     *
     * @param current the current node
     * @param consumer A function that takes in a generic type T and returns void.
     */
    private void inOrderTraversal(Node<T>current, Consumer<T> consumer){
        if(current != null){
            inOrderTraversal(current.left, consumer);
            consumer.accept(current.element);
            inOrderTraversal(current.right, consumer);
        }

    }

    @Override
    // This is a method that is returning the size of the tree.
    public String toString() {
        Node node = new Node(size);
        return "LogicBinarySearchTree{" +
                "root=" + root +
                '}'+ node.toString();

    }
}
