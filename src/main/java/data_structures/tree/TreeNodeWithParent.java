package data_structures.tree;

public class TreeNodeWithParent<U> extends TreeNode<U>{
    TreeNodeWithParent<U> parent;

    public TreeNodeWithParent(U key, TreeNodeWithParent<U> parent) {
        super(key);
        this.parent = parent;
    }

    public TreeNodeWithParent(U key) {
        this(key, null);
    }
}
