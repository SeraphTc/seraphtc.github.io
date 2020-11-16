package com.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihuaqing <lihuaqing@kuaishou.com>
 * Created on 2020/9/19
 */

public class TreePath {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    public static void main(String[] args) {

    }

}
