package academy.kovalevskyi.algorithms.week2.day0;

import org.junit.jupiter.api.Test;

class IntTreeHelperTest {

  @Test
  void addNode() {
    IntTreeNode treeNode7 = new IntTreeNode(40, 40, 1, 1, 1, null, null);
    IntTreeNode treeNode6 = new IntTreeNode(35, 75, 2, 2, 2, null, treeNode7);
    IntTreeNode treeNode5 = new IntTreeNode(29, 29, 1, 1, 1, null, null);
    IntTreeNode treeNode4 = new IntTreeNode(5, 5, 1, 1, 1, null, null);
    IntTreeNode treeNode3 = new IntTreeNode(30, 134, 4, 3, 2, treeNode5, treeNode6);
    IntTreeNode treeNode2 = new IntTreeNode(20,25, 2, 2, 2, treeNode4, null);
    IntTreeNode treeNode1 = new IntTreeNode(26, 185,7, 4, 3, treeNode2, treeNode3);
    IntTreeHelper.printTree(treeNode1);
    var temp = IntTreeHelper.addNode(treeNode1,10);
    IntTreeHelper.printTree(temp);
  }

  @Test
  void rotateLeft() {
    IntTreeNode treeNode7 = new IntTreeNode(40, 40, 1, 1, 1, null, null);
    IntTreeNode treeNode6 = new IntTreeNode(35, 75, 2, 2, 2, null, treeNode7);
    IntTreeNode treeNode5 = new IntTreeNode(29, 29, 1, 1, 1, null, null);
    IntTreeNode treeNode4 = new IntTreeNode(5, 5, 1, 1, 1, null, null);
    IntTreeNode treeNode3 = new IntTreeNode(30, 134, 4, 3, 2, treeNode5, treeNode6);
    IntTreeNode treeNode2 = new IntTreeNode(20,25, 2, 2, 2, treeNode4, null);
    IntTreeNode treeNode1 = new IntTreeNode(26, 185,7, 4, 3, treeNode2, treeNode3);
    IntTreeHelper.printTree(treeNode1);
    var nodeRotateLeft = IntTreeHelper.rotateLeft(treeNode1);
    IntTreeHelper.printTree(nodeRotateLeft);
  }

  @Test
  void rotateRight() {
    IntTreeNode treeNode8 = new IntTreeNode(22, 22, 1, 1, 1, null, null);
    IntTreeNode treeNode7 = new IntTreeNode(40, 40, 1, 1, 1, null, null);
    IntTreeNode treeNode6 = new IntTreeNode(35, 75, 2, 2, 2, null, treeNode7);
    IntTreeNode treeNode5 = new IntTreeNode(29, 29, 1, 1, 1, null, null);
    IntTreeNode treeNode4 = new IntTreeNode(5, 5, 1, 1, 1, null, null);
    IntTreeNode treeNode3 = new IntTreeNode(30, 134, 4, 3, 2, treeNode5, treeNode6);
    IntTreeNode treeNode2 = new IntTreeNode(20,47, 3, 2, 2, treeNode4, treeNode8);
    IntTreeNode treeNode1 = new IntTreeNode(26, 207,8, 4, 3, treeNode2, treeNode3);
    IntTreeHelper.printTree(treeNode1);
    var nodeRotateLeft = IntTreeHelper.rotateRight(treeNode1);
    IntTreeHelper.printTree(nodeRotateLeft);
  }
  @Test
  void rotateRightSmall() {
    var nodes = new IntTreeNode(26, 26, 1, 1, 1, null, null);
    nodes = IntTreeHelper.addNode(nodes, 20);
    nodes = IntTreeHelper.addNode(nodes, 30);
    nodes = IntTreeHelper.addNode(nodes, 5);
    nodes = IntTreeHelper.addNode(nodes, 40);
    nodes = IntTreeHelper.addNode(nodes, 22);
    IntTreeHelper.printTree(nodes);
    var nodeRotateLeft = IntTreeHelper.rotateRight(nodes);
    IntTreeHelper.printTree(nodeRotateLeft);
    IntTreeHelper.printTree(IntTreeHelper.rotateLeft(nodeRotateLeft));
  }
  @Test
  void addNode4() {
    var nodes = new IntTreeNode(26, 26, 1, 1, 1, null, null);
    nodes = IntTreeHelper.addNode(nodes,20);
    nodes = IntTreeHelper.addNode(nodes,30);
    nodes = IntTreeHelper.addNode(nodes,5);
    nodes = IntTreeHelper.addNode(nodes,19);
    nodes = IntTreeHelper.addNode(nodes,35);
    nodes = IntTreeHelper.addNode(nodes,40);
    nodes = IntTreeHelper.addNode(nodes,2);
    nodes = IntTreeHelper.addNode(nodes,1);
    nodes = IntTreeHelper.addNode(nodes,29);
    IntTreeHelper.printTree(nodes);


    nodes = IntTreeHelper.rotateLeft(nodes);
    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.rotateRight(nodes);
    IntTreeHelper.printTree(nodes);

  }
  @Test
  void generateBalanceTree() {
    var nodes = new IntTreeNode(10, 10, 1, 1, 1, null, null);
    nodes = IntTreeHelper.addNode(nodes,-2);
    nodes = IntTreeHelper.addNode(nodes,12);
    nodes = IntTreeHelper.addNode(nodes,1);
    nodes = IntTreeHelper.addNode(nodes,2);
    nodes = IntTreeHelper.addNode(nodes,3);
    IntTreeHelper.printTree(nodes);
    nodes = IntTreeHelper.generateBalanceTree(nodes);
    IntTreeHelper.printTree(nodes);
  }
}