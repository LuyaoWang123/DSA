package data_structures.tree;

import data_structures.linkedlist.Node;

public class TreeNode<U> extends Node<U>{
    TreeNode<U> left;
    TreeNode<U> right;

    public TreeNode(U key, TreeNode<U> left, TreeNode<U> right) {
        super(key);
        this.left = left;
        this.right = right;
    }

    public TreeNode(U key) {
        this(key, null, null);
    }
}