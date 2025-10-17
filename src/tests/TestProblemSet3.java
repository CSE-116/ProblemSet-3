package tests;

import org.junit.Test;
import problem.ProblemSet3;
import problem.datastructures.BST;
import problem.datastructures.BinaryTreeNode;
import problem.datastructures.comparators.IntABSIncreasing;
import problem.datastructures.comparators.IntDecreasing;
import problem.datastructures.comparators.IntIncreasing;
import problem.datastructures.comparators.IntInverseDistanceFromReference;

import static org.junit.Assert.*;

public class TestProblemSet3 {

    /**
     *   3
     *  / \
     * 5  -10
     *
     */
    private BinaryTreeNode<Integer> smallTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(3,
                new BinaryTreeNode<>(5, null, null),
                new BinaryTreeNode<>(-10, null, null));

        return root;
    }

    /**
     *     10
     *    / \
     *   5   15
     *  /     \
     * 0       20
     *
     */
    private BinaryTreeNode<Integer> mediumTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10,
                new BinaryTreeNode<>(5,
                        new BinaryTreeNode<>(0, null, null),
                        null),
                new BinaryTreeNode<>(15,
                        null,
                        new BinaryTreeNode<>(20, null, null)
                ));

        return root;
    }

    /**
     *          0
     *        /   \
     *      5      -5
     *     / \       \
     *   10   3      -10
     *  /    /        / \
     * 12   4       -7  -14
     *  \                /
     *   11            -11
     *
     */
    private BinaryTreeNode<Integer> bigTree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(0,
                new BinaryTreeNode<>(5,
                        new BinaryTreeNode<>(10,
                                new BinaryTreeNode<>(12,
                                        null,
                                        new BinaryTreeNode<>(11, null, null)),
                                null),
                        new BinaryTreeNode<>(3,
                                new BinaryTreeNode<>(4, null, null),
                                null)),
                new BinaryTreeNode<>(-5,
                        null,
                        new BinaryTreeNode<>(-10,
                                new BinaryTreeNode<>(-7, null, null),
                                new BinaryTreeNode<>(-14,
                                        new BinaryTreeNode<>(-11, null, null),
                                        null))
                ));

        return root;
    }

    @Test
    public void testMaxBinaryTreeEmptyTree() {
        BinaryTreeNode<Integer> root = null;
        int answer = ProblemSet3.maxBinaryTree(root, new IntABSIncreasing());
        assertEquals(0, answer);
    }

    @Test
    public void testMaxBinaryTreeSingleNode() {
        int theOnlyValue = 100;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(theOnlyValue, null, null);
        assertEquals(theOnlyValue, ProblemSet3.maxBinaryTree(root, new IntIncreasing()));
        assertEquals(theOnlyValue, ProblemSet3.maxBinaryTree(root, new IntDecreasing()));
        assertEquals(theOnlyValue, ProblemSet3.maxBinaryTree(root, new IntABSIncreasing()));
        assertEquals(theOnlyValue, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(200)));
    }

    @Test
    public void testMaxBinaryTreeSmallTree() {
        /*
         *   3
         *  / \
         * 5  -10
         *
         */
        BinaryTreeNode<Integer> root = this.smallTree();
        assertEquals(5, ProblemSet3.maxBinaryTree(root, new IntIncreasing()));
        assertEquals(-10, ProblemSet3.maxBinaryTree(root, new IntDecreasing()));
        assertEquals(-10, ProblemSet3.maxBinaryTree(root, new IntABSIncreasing()));
        assertEquals(5, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(8)));
        assertEquals(3, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(-1)));
    }

    @Test
    public void testMaxBinaryTreeMediumTree() {
        /*
         *     10
         *    / \
         *   5   15
         *  /     \
         * 0       20
         *
         */
        BinaryTreeNode<Integer> root = this.mediumTree();
        assertEquals(20, ProblemSet3.maxBinaryTree(root, new IntIncreasing()));
        assertEquals(0, ProblemSet3.maxBinaryTree(root, new IntDecreasing()));
        assertEquals(20, ProblemSet3.maxBinaryTree(root, new IntABSIncreasing()));
        assertEquals(10, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(8)));
        assertEquals(15, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(15)));
    }

    @Test
    public void testMaxBinaryTreeLargeTree() {
        /*
         *          0
         *        /   \
         *      5      -5
         *     / \       \
         *   10   3      -10
         *  /    /        / \
         * 12   4       -7  -14
         *  \                /
         *   11            -11
         *
         */
        BinaryTreeNode<Integer> root = this.bigTree();
        assertEquals(12, ProblemSet3.maxBinaryTree(root, new IntIncreasing()));
        assertEquals(-14, ProblemSet3.maxBinaryTree(root, new IntDecreasing()));
        assertEquals(-14, ProblemSet3.maxBinaryTree(root, new IntABSIncreasing()));
        assertEquals(0, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(0)));
        assertEquals(10, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(8)));
        assertEquals(-14, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(-100)));
        assertEquals(5, ProblemSet3.maxBinaryTree(root, new IntInverseDistanceFromReference(6)));
    }

    @Test
    public void testIsBSTSmallTree() {
        /*
         *   3
         *  / \
         * 5  -10
         *
         */
        BinaryTreeNode<Integer> root = this.smallTree();
        assertFalse(ProblemSet3.isBST(root, new IntIncreasing()));
        assertTrue(ProblemSet3.isBST(root, new IntDecreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntABSIncreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(0)));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(8)));
        assertTrue(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(-100)));
        assertTrue(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(-8)));
    }

    @Test
    public void testIsBSTMediumTree() {
        /*
         *     10
         *    / \
         *   5   15
         *  /     \
         * 0       20
         *
         */
        BinaryTreeNode<Integer> root = this.mediumTree();
        assertTrue(ProblemSet3.isBST(root, new IntIncreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntDecreasing()));
        assertTrue(ProblemSet3.isBST(root, new IntABSIncreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(0)));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(8)));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(-100)));
        assertTrue(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(25)));
    }

    @Test
    public void testIsBSTBigTree() {
        /*
         *          0
         *        /   \
         *      5      -5
         *     / \       \
         *   10   3      -10
         *  /    /        / \
         * 12   4       -7  -14
         *  \                /
         *   11            -11
         *
         */
        BinaryTreeNode<Integer> root = this.bigTree();
        assertFalse(ProblemSet3.isBST(root, new IntIncreasing()));
        assertTrue(ProblemSet3.isBST(root, new IntDecreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntABSIncreasing()));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(0)));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(8)));
        assertTrue(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(-100)));
        assertFalse(ProblemSet3.isBST(root, new IntInverseDistanceFromReference(6)));
    }


}


