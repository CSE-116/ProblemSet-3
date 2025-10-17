package problem;

import problem.datastructures.BST;
import problem.datastructures.BinaryTreeNode;
import problem.datastructures.comparators.Comparator;

public class ProblemSet3 {

    /**
     * Find the maximum value in a BST of integers
     *
     * @param bst A binary search tree of integers
     * @return The maximum value in bst according to its comparator. Returns 0 if bst is empty
     */
    public static int maxBST(BST<Integer> bst) {
        return 0;
    }

    /**
     * Find the maximum value in a binary tree of integers according to the provided comparator. Note that this does
     * not always return the largest integer. The comparator is used to determine what "maximum" means. You can think
     * of maximum as the value that would be last if all the values were sorted
     *
     * @param binaryTree A binary tree of integers
     * @param comparator Comparator to be used to determine the maximum value
     * @return The maximum value according to the comparator. Returns 0 if binaryTree is empty
     */
    public static int maxBinaryTree(BinaryTreeNode<Integer> binaryTree, Comparator<Integer> comparator) {
        return 0;
    }

    /**
     * Checks if the binary tree is a valid BST according to the comparator.
     * <p>
     * An empty tree should be considered a valid BST.
     *
     * You may assume there are no duplicate values in the input tree
     *
     * @param binaryTree The binary tree to check
     * @param comparator Comparator to be used to determine if binaryTree is a BST
     * @return true if binaryTree is a BST according to comparator, false otherwise
     */
    public static boolean isBST(BinaryTreeNode<Integer> binaryTree, Comparator<Integer> comparator) {
        return true;
    }

}
