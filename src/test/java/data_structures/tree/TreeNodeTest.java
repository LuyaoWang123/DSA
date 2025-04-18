package data_structures.tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TreeNodeTest {

    @Test
    public void testConstructorWithOnlyKey() {
        TreeNode<Integer> node = new TreeNode<>(10);
        assertEquals(10, node.getKey());
        assertNull(node.left);
        assertNull(node.right);
    }

    @Test
    public void testConstructorWithKeyAndChildren() {
        TreeNode<Integer> leftChild = new TreeNode<>(5);
        TreeNode<Integer> rightChild = new TreeNode<>(15);
        TreeNode<Integer> parent = new TreeNode<>(10, leftChild, rightChild);

        assertEquals(10, parent.getKey());
        assertEquals(5, parent.left.getKey());
        assertEquals(15, parent.right.getKey());
        assertNull(parent.left.left);
        assertNull(parent.right.right);
    }

    @Test
    public void testNestedTreeStructure() {
        TreeNode<Integer> leftLeft = new TreeNode<>(1);
        TreeNode<Integer> left = new TreeNode<>(2, leftLeft, null);
        TreeNode<Integer> right = new TreeNode<>(3);
        TreeNode<Integer> root = new TreeNode<>(4, left, right);

        assertEquals(4, root.getKey());
        assertEquals(2, root.left.getKey());
        assertEquals(1, root.left.left.getKey());
        assertNull(root.left.right);
        assertEquals(3, root.right.getKey());
    }

    @Test
    public void testNullKeyIsAllowed() {
        TreeNode<String> node = new TreeNode<>(null);
        assertNull(node.getKey());
        assertNull(node.left);
        assertNull(node.right);
    }
}
