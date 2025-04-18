package data_structures.tree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TreeNodeWithParentTest {

    @Test
    public void testConstructorWithOnlyKey() {
        TreeNodeWithParent<Integer> node = new TreeNodeWithParent<>(42);
        assertEquals(42, node.getKey());
        assertNull(node.left);
        assertNull(node.right);
        assertNull(node.parent);
    }

    @Test
    public void testConstructorWithKeyAndParent() {
        TreeNodeWithParent<Integer> parent = new TreeNodeWithParent<>(10);
        TreeNodeWithParent<Integer> child = new TreeNodeWithParent<>(20, parent);

        assertEquals(20, child.getKey());
        assertSame(parent, child.parent);
        assertEquals(10, child.parent.getKey());
        assertNull(child.left);
        assertNull(child.right);
    }

    @Test
    public void testMultiLevelParentLink() {
        TreeNodeWithParent<Integer> grandparent = new TreeNodeWithParent<>(1);
        TreeNodeWithParent<Integer> parent = new TreeNodeWithParent<>(2, grandparent);
        TreeNodeWithParent<Integer> child = new TreeNodeWithParent<>(3, parent);

        assertEquals(3, child.getKey());
        assertEquals(2, child.parent.getKey());
        assertEquals(1, child.parent.parent.getKey());
        assertNull(child.left);
        assertNull(child.right);
    }

    @Test
    public void testNullKeyIsAllowed() {
        TreeNodeWithParent<String> node = new TreeNodeWithParent<>(null);
        assertNull(node.getKey());
        assertNull(node.parent);
    }
}
