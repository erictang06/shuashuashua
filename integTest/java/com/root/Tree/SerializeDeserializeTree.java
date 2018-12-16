package com.root.Tree;

import com.root.common.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class SerializeDeserializeTree {
  private static final String SPLITER = ",";
  private static final String NULL_NODE = "X";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(root, sb);
    return sb.toString();
  }

  private void buildString(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append(NULL_NODE).append(SPLITER);
    } else {
      sb.append(node.val).append(SPLITER);
      buildString(node.left, sb);
      buildString(node.right, sb);
    }
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(SPLITER)));
    return buildTree(nodes);
  }

  private TreeNode buildTree(Queue<String> nodes) {
    String val = nodes.remove();
    if (val.equals(NULL_NODE)) {
      return null;
    } else {
      TreeNode node = new TreeNode(Integer.valueOf(val));
      node.left = buildTree(nodes);
      node.right = buildTree(nodes);
      return node;
    }
  }

}
