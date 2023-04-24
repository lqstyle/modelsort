package com.example.leetcode.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Test - TODO
 *
 * @author 11131329
 * @version 1.0
 * @since 2023/4/3 20:11
 */
public class Test {

    private static ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal3 = new ThreadLocal<>();
    private static ThreadLocal<String> threadLocal4 = new ThreadLocal<>();
    static int sum = 0;

    public static int countSubstrings(String s) {
        int res = 0;
        int size = s.length();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;

                while (l >= 0 && r < size && s.charAt(l--) == s.charAt(r++)) {
                    res++;
                }
            }
        }
        return res;
    }

    public TreeNode lowestCommonAnchor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        final TreeNode left = lowestCommonAnchor(root.left, p, q);

        final TreeNode right = lowestCommonAnchor(root.right, p, q);

        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public List<Integer> sub = new ArrayList<>();

    private List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        // int[] nums = { 5, 4, -1, 7, 8 };
        // TreeNode treeNode = new TreeNode(5);
        // TreeNode treeNode1 = new TreeNode(4);
        // TreeNode treeNode2 = new TreeNode(6);
        // treeNode.left = treeNode1;
        // treeNode.right = treeNode2;
        // // String s="30[a]2[bc]";
        // Stu stu1 = new Stu(1,"1");
        // Stu stu2 = new Stu(2,"2");
        // Stu[] stus = new Stu[]{stu1,stu2};
        // Arrays.sort(stus,(stu3,stu4)->stu4.val-stu3.val);
        // System.out.println(convertBST(treeNode));

        // int[][] ints = new int[6][2];
        // ints[0] = new int[] { 7, 0 };
        // ints[1] = new int[] { 4, 4 };
        // ints[2] = new int[] { 7, 1 };
        // ints[3] = new int[] { 5, 0 };
        // ints[4] = new int[] { 6, 1 };
        // ints[5] = new int[] { 5, 2 };
        //
        // System.out.println(reconstructQueue(ints));
        // System.out.println(cuttingRope1(120));
        // int[] a=new int[]{1,2,3,4,5};
        // int[] b=new int[]{4,5,3,2,1};
        // validateStackSequences(a,b);

        // levelOrder1(null);
        // int[] s = new int[]{1, 3, 2, 5, 6};
        // verifyPostorder(s);

        // ListNode listNode1 = new ListNode(1);
        // ListNode listNode2 = new ListNode(2);
        // ListNode listNode3 = new ListNode(3);
        // ListNode listNode4 = new ListNode(4);
        // ListNode listNode5 = new ListNode(5);
        // ListNode listNode6 = new ListNode(6);
        // ListNode listNode7 = new ListNode(7);
        // listNode1.next=listNode2;
        // listNode2.next=listNode3;
        // listNode3.next=listNode4;
        // listNode4.next=listNode5;
        // listNode5.next=listNode6;
        // listNode6.next=listNode7;
        // final ListNode swap = swap(listNode1);
        // System.out.println(swap);
        // int[] nums=new int[]{4,1,4,6};
        // System.out.println(singleNumbers(nums));
        // String s="abc";
        // System.out.println(permutation(s));
        int[] nums = { 100, 4, 200, 1, 3, 4 };
        // System.out.println(subSet(nums));
        // System.out.println(combinationSum4(nums,4));
        // System.out.println(longestPalindromeSubseq("bab"));
        // String[] strs = new String[]{"flower","flow","flight"};
        // System.out.println(longestCommonPrefix(strs));

        // ListNode head = new ListNode(1);
        // ListNode head1 = new ListNode(2);
        // ListNode head2 = new ListNode(3);
        // ListNode head3 = new ListNode(4);
        // ListNode head4 = new ListNode(5);
        // head.next=head1;
        // head1.next=head2;
        // head2.next=head3;
        // head3.next=head4;
        // splitListToParts(head,2);

        // String[] str = new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" };
        // System.out.println(calPoints(str));
        //
        // final ExecutorService executorService = Executors.newFixedThreadPool(1);
        // executorService.submit(()->{
        // threadLocal1.set("lq");
        // threadLocal1.set("lq1");
        // threadLocal1.set("lq2");
        // threadLocal2.set("lq1");
        // threadLocal3.set("lq2");
        // threadLocal4.set("lq3");
        // System.out.println(threadLocal1.get());
        // System.out.println(threadLocal2.get());
        // System.out.println(threadLocal3.get());
        // System.out.println(threadLocal4.get());
        // });
        // threadLocal1.set("lq");
        // threadLocal2.set("lq1");
        // threadLocal3.set("lq2");
        // threadLocal4.set("lq3");
        // System.out.println(threadLocal1.get());
        // System.out.println(threadLocal2.get());
        // System.out.println(threadLocal3.get());
        // System.out.println(threadLocal4.get());

        int[] num1 = new int[] { 1, 3, 5, 2, 4 };
        int[] num2 = new int[] { 5, 4, 3, 2, 1 };
        nextGreaterElement(num1, num2);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(res, path, 0, nums);
        return res;

    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] position = new int[nums2.length];
        Arrays.fill(position, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                final int pop = stack.pop();
                position[pop] = nums2[i];
            }
            map.put(nums2[i], i);
            stack.push(i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = position[map.get(nums1[i])];
        }
        return result;

    }

    public static String removeDuplicateLetters(String s) {
        final char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }

        boolean[] visited = new boolean[26];

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) {
                continue;
            }

            while (!deque.isEmpty() && deque.peekLast() > chars[i] && lastIndex[deque.peekLast() - 'a'] > i) {
                final char c = deque.removeLast();
                visited[c - 'a'] = false;
            }

            deque.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;

        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append(deque.pop());
        }
        return stringBuilder.toString();

    }

    public static void dfs(List<List<Integer>> res, List<Integer> path, int start, int[] s) {
        if (start == s.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.add(s[start]);
        dfs(res, path, start + 1, s);
        path.remove(path.size() - 1);
        dfs(res, path, start + 1, s);

    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] selected = new boolean[nums.length];
        Arrays.sort(nums);
        dfsAllUnique(res, path, selected, 0, nums.length, nums);
        return res;
    }

    public static void dfsAllUnique(List<List<Integer>> res, Deque<Integer> path, boolean[] selected, int start,
            int len, int[] nums) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (selected[i] || (i > 0 && nums[i] == nums[i - 1] && !selected[i - 1])) {
                continue;
            }
            selected[i] = true;
            path.addLast(nums[i]);
            dfsAllUnique(res, path, selected, start + 1, len, nums);
            path.removeLast();
            selected[i] = false;
        }
    }

    public static int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] = dp[i] + dp[i - num];
                }
            }
        }
        return dp[target];

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        dfsone(res, path, candidates, target, 0);
        return res;
    }

    public static void dfsone(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.addLast(candidates[i]);
            dfsone(res, path, candidates, target - candidates[i], i + 1);
            path.removeLast();
        }

    }

    public static void dddffss(List<List<Integer>> res, Deque<Integer> path, int target, int[] nums, int length) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < length; i++) {
            path.addLast(nums[i]);
            dddffss(res, path, target - nums[i], nums, length);
            path.removeLast();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] selected = new boolean[nums.length];
        dfsAll(res, path, selected, 0, nums.length, nums);
        return res;
    }

    public static void dfsAll(List<List<Integer>> res, Deque<Integer> path, boolean[] selected, int start, int len,
            int[] nums) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (selected[i]) {
                continue;
            }
            selected[i] = true;
            path.addLast(nums[i]);
            dfsAll(res, path, selected, start + 1, len, nums);
            path.removeLast();
            selected[i] = false;
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs1(res, list, 0, target, candidates);
        return res;
    }

    public static void dfs1(List<List<Integer>> res, List<Integer> list, int begin, int target, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs1(res, list, i, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(res, list, 0, target, candidates);
        return res;
    }

    public static void dfs2(List<List<Integer>> res, List<Integer> list, int begin, int target, int[] candidates) {

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            dfs2(res, list, i + 1, target - candidates[i], candidates);
            list.remove(list.size() - 1);
        }
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int res = 0;

        for (int i = 0; i < len; i++) {
            int j = i + 1;
            int r = 0;
            while (j < len) {
                r = r + nums[j++];
                res = Math.max(res, nums[i] + r);
            }
        }
        return res;
    }

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i) {
                max = Math.max(max, i + nums[i]);
            }
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    /**
     * 30[a]2[bc] a[a2[c]]
     *
     * @param s
     * @return
     */
    public static String decodeString(String s) {
        StringBuffer ans = new StringBuffer();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                ansStack.push(ans);
                multiStack.push(multi);
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    ansTmp.append(ans);
                }
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

    public static String decode(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        final char[] chars = s.toCharArray();

        ArrayDeque<Integer> multiStack = new ArrayDeque<>();
        int multi = 0;
        ArrayDeque<StringBuilder> charStack = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else if (c == '[') {
                multiStack.push(multi);
                multi = 0;
                charStack.push(ans);
                ans = new StringBuilder();
            } else {
                final StringBuilder tmp = charStack.pop();
                final Integer mul = multiStack.pop();
                for (int i = 0; i < mul; i++) {
                    tmp.append(ans);
                }
                ans = tmp;
            }
        }
        return ans.toString();
    }

    /**
     * 同样地，我们也可以将每个人按照身高从大到小进行排序，处理身高相同的人使用的方法类似，即：按照 h_ih i 为第一关键字降序，k_ik i
     * 为第二关键字升序进行排序。如果我们按照排完序后的顺序，依次将每个人放入队列中，那么当我们放入第 ii 个人时：
     * <p>
     * 第 0, \cdots, i-10,⋯,i−1 个人已经在队列中被安排了位置，他们只要站在第 ii 个人的前面，就会对第 ii
     * 个人产生影响，因为他们都比第 ii 个人高；
     * <p>
     * 而第 i+1, \cdots, n-1i+1,⋯,n−1 个人还没有被放入队列中，并且他们无论站在哪里，对第 ii 个人都没有任何影响，因为他们都比第
     * ii 个人矮。
     * <p>
     * 在这种情况下，我们无从得知应该给后面的人安排多少个「空」位置，因此就不能沿用方法一。但我们可以发现，后面的人既然不会对第 ii
     * 个人造成影响，我们可以采用「插空」的方法，依次给每一个人在当前的队列中选择一个插入的位置。也就是说，当我们放入第 ii
     * 个人时，只需要将其插入队列中，使得他的前面恰好有 k_ik i 个人即可。
     *
     * @param people
     * @return
     */
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        final char[] chars = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public int[] reversePrint(ListNode head) {

        ListNode tmp = head;

        ListNode pre = null;
        int i = 0;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
            i++;
        }

        tmp = pre;

        int[] res = new int[i];
        i = 0;
        while (tmp != null) {
            res[i] = tmp.val;
            tmp = tmp.next;
            i++;

        }
        return res;
    }

    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return rec(0, 0, inorder.length - 1);
    }

    public TreeNode rec(int pre_root, int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }

        TreeNode treeNode = new TreeNode(preorder[pre_root]);
        int idx = map.get(preorder[pre_root]);

        treeNode.left = rec(pre_root + 1, in_left, idx - 1);

        treeNode.right = rec(pre_root + (idx - in_left) + 1, idx + 1, in_right);
        return treeNode;
    }

    // 8 2 3 3
    public static int cuttingRope(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static int cuttingRope1(int n) {
        int[] dp = new int[n + 1];

        int mod = 1000000007;
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax % mod, Math.max(j * (i - j) % mod, j * dp[i - j] % mod));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }

    public static ListNode swap(ListNode list) {

        ListNode sentinel = new ListNode(0);
        sentinel.next = list;

        ListNode tmp = sentinel;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode node1 = tmp.next;
            ListNode node2 = tmp.next.next;
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            tmp = node1;
        }
        return sentinel.next;
    }

    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recursive(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public static boolean recursive(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recursive(A.left, B.left) && recursive(A.right, B.right);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> arrayDeque = new ArrayDeque<>();
        recursive(root, target, result, arrayDeque);
        return result;
    }

    public static void recursive(TreeNode node, int target, List<List<Integer>> result, Deque<Integer> arrayDeque) {
        if (node == null) {
            return;
        }

        arrayDeque.addLast(node.val);
        target = target - node.val;

        if (0 == target && node.left == null && node.right == null) {
            result.add(new ArrayList<>(arrayDeque));
        }

        recursive(node.left, target, result, arrayDeque);

        recursive(node.right, target, result, arrayDeque);

        arrayDeque.removeLast();

    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) {
            return false;
        }
        if (pushed.length != popped.length) {
            return false;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int len = pushed.length;
        for (int i = 0, j = 0; i < len; i++) {
            deque.push(pushed[i]);
            while (!deque.isEmpty() && deque.peek().equals(popped[j])) {
                deque.pop();
                j++;
            }
        }
        return deque.isEmpty();
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            final int size = deque.size();
            for (int i = 0; i < size; i++) {
                final TreeNode treeNode = deque.removeFirst();
                result.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isfirstLeft = true;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                final TreeNode poll = queue.poll();
                if (isfirstLeft) {
                    levelList.addLast(poll.val);
                } else {
                    levelList.addFirst(poll.val);
                }

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            result.add(new ArrayList<>(levelList));
            isfirstLeft = !isfirstLeft;
        }
        return result;
    }

    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

    public static int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }

    public int maxValue1(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j]);
                }
                if (j > 0) {
                    f[i][j] = Math.max(f[i][j], f[i][j - 1]);
                }
                f[i][j] += grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }

    public static String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder depth = new StringBuilder();
        boolean[] condition = new boolean[s.length()];
        dfsss(res, depth, 0, s, s.length(), condition);

        String[] re1 = new String[res.size()];
        int i = 0;
        for (String re : res) {
            re1[i++] = re;
        }
        return re1;
    }

    public static void dfsss(List<String> res, StringBuilder depth, int start, String s, int len, boolean[] condition) {
        if (start == len) {
            res.add(depth.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (condition[i]) {
                continue;
            }
            condition[i] = true;
            depth.append(s.charAt(i));
            dfsss(res, depth, start + 1, s, len, condition);
            depth.deleteCharAt(depth.length() - 1);
            condition[i] = false;
        }
    }

    public int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            return new int[0];
        }

        int[] res = new int[nums.length];
        int l = 1;
        int r = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = l;
            l *= nums[i];
        }

        for (int i = nums.length - 1; i >= 1; i--) {
            r *= nums[i];
            res[i - 1] *= r;
        }
        return res;
    }

    public static int pathSums1(TreeNode root, int sum) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0L, 1);
        return dfs(root, preSumMap, sum, 0);
    }

    public static int dfs(TreeNode root, Map<Long, Integer> preSumMap, int target, long curSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;

        curSum += root.val;

        res += preSumMap.getOrDefault(curSum - target, 0);

        preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) + 1);

        res += dfs(root.left, preSumMap, target, curSum);
        res += dfs(root.right, preSumMap, target, curSum);

        preSumMap.put(curSum, preSumMap.getOrDefault(curSum, 0) - 1);

        return res;
    }

    public static int pathSums(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0L, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0L);
    }

    /**
     * 前缀和的递归回溯思路 从当前节点反推到根节点(反推比较好理解，正向其实也只有一条)，有且仅有一条路径，因为这是一棵树
     * 如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时去除，保证其不影响其他分支的结果
     * 
     * @param node
     *            树节点
     * @param prefixSumCount
     *            前缀和Map
     * @param target
     *            目标值
     * @param currSum
     *            当前路径和
     * @return 满足题意的解
     */
    private static int recursionPathSum(TreeNode node, Map<Long, Integer> prefixSumCount, int target, long currSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        // ---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        res += prefixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        // ---核心代码

        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, currSum);
        res += recursionPathSum(node.right, prefixSumCount, target, currSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[coins.length + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (set.contains(n)) {
                return true;
            }
            set.add(n);
        }
        return false;
    }

    public static int reverse(int x) {
        int res = 0;

        while (x != 0) {
            int number = x % 10;
            res = res * 10 + number;
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            x = x / 10;
        }
        return res;
    }

    // public static void dfsw(List<List<Integer>> lists, List<Integer> path, int
    // amount, int start, int[] coins) {
    // if (amount < 0) {
    // return;
    // }
    // if (amount == 0) {
    // lists.add(new ArrayList<>(path));
    // return;
    // }
    //
    // for (int i = start; i < coins.length; i++) {
    // path.add(coins[i]);
    // dfsw(lists, path, amount - coins[i], start, coins);
    // path.remove(path.size() - 1);
    // }
    // }

    public static List<List<Integer>> subSet(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        subDfs(res, path, 0, nums);
        return res;
    }

    public static void subDfs(List<List<Integer>> res, Deque<Integer> path, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        path.addLast(nums[index]);
        subDfs(res, path, index + 1, nums);
        path.removeLast();
        subDfs(res, path, index + 1, nums);
    }

    // 最长连续递增数组长度
    public static int longConsencutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            }
            int current = num;
            int count = 1;
            while (set.contains(current + 1)) {
                current = current + 1;
                count = count + 1;
            }
            res = Math.max(res, count);
        }

        return res;

    }

    public static int findLengthOfLCIS(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int l = i;
            int count = 1;
            while (l < n - 1 && nums[l] < nums[l + 1]) {
                count = count + 1;
                l++;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    // 最长公共子序列 经典二维动态规划
    public static int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    // bab 最长回文子序列
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            int a = s.charAt(i);
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                int b = s.charAt(j);
                if (a == b) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // 最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String one = strs[0];
        String res = "";
        for (int i = 1; i < strs.length; i++) {
            res = pre(one, strs[i]);
            if (res.length() == 0) {
                return "";
            }
            one = res;
        }
        return res;
    }

    public static String pre(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int l = 0;
        while (l < len && s1.charAt(l) == s2.charAt(l)) {
            l++;
        }
        return s1.substring(0, l);
    }

    public static boolean isHw(char[] c, int l, int r) {
        while (l < r) {
            if (l >= 0 && r <= c.length - 1) {
                if (c[l] != c[r]) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    // 当前字符串组合的最长回文串长度
    public static int longestPalindrome(String s) {
        int[] count = new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            final char c = s.charAt(i);
            count[c]++;
        }

        int res = 0;
        for (int num : count) {
            if (num == 0) {
                continue;
            }
            res = res + num / 2 * 2;
            if (num % 2 == 1 && res % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    // babad 最长回文子串 动态规划其实相当于redis缓存，减少不必要的搜索
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 1;
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxStart = l;
                        maxEnd = r;
                        maxLen = r - l + 1;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallTmp = small;

        ListNode large = new ListNode(0);
        ListNode largetTmp = large;

        ListNode tmp = head;

        while (tmp != null) {
            if (tmp.val < x) {
                smallTmp.next = tmp;
                smallTmp = smallTmp.next;
            } else {
                largetTmp.next = tmp;
                largetTmp = largetTmp.next;
            }

            tmp = tmp.next;
        }

        smallTmp.next = large.next;
        largetTmp.next = null;
        return small.next;
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            tmp = tmp.next;
            len++;
        }

        ListNode cur = head;

        int mod = len % k;
        int avg = len / k;

        ListNode[] result = new ListNode[k];

        for (int i = 0; i < k && cur != null; i++) {

            result[i] = cur;
            int size = avg + (i < mod ? 1 : 0);
            for (int j = 1; j < size; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }

        return result;
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int m = g.length;
        int n = s.length;

        int count = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            while (j < n && g[i] > s[j]) {
                j++;
            }

            if (j < n) {
                count++;
            }
        }
        return count;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return validPalindromeHelper(s, left + 1, right) || validPalindromeHelper(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean validPalindromeHelper(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        int res = 0;
        for (int i = 0; i < len; i += 2) {
            res += Math.min(nums[i], nums[i + 1]);
        }
        return res;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0, len = flowerbed.length; i < len && n > 0;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    public static int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) {
            return -1;
        }
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String str : operations) {
            switch (str) {
                case "+":
                    int two = stack.pop();
                    int one = stack.pop();
                    int three = one + two;
                    stack.push(one);
                    stack.push(two);
                    stack.push(three);
                    break;
                case "D":
                    int four = stack.peek();
                    stack.push(four * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;

    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode l1 = middle;
        ListNode l2 = middle.next;
        middle.next = null;

        megeListNode(l1, l2);
    }

    /**
     * 返回链表第一个中间节点
     * 
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void megeListNode(ListNode l1, ListNode l2) {
        ListNode l1Tmp = l1;
        ListNode l2Tmp = l2;

        while (l1Tmp != null && l2Tmp != null) {

            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1Tmp;
            l2 = l2Tmp;
        }
    }

    // 先序遍历 根左右
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {

            TreeNode node = deque.pop();
            result.add(node.val);
            if (node.right != null) {
                deque.push(node.right);
            }
            if (node.left != null) {
                deque.push(node.left);
            }
        }
        return result;
    }

    // 中序遍历 左根右
    public static List<Integer> midorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.push(root);
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while (!deque.isEmpty() || cur != null) {
            while (cur != null) {
                deque.push(cur.left);
                cur = cur.left;
            }

            final TreeNode treeNode = deque.pop();
            result.add(treeNode.val);
            if (treeNode.right != null) {
                cur = treeNode.right;
            }
        }
        return result;
    }

    // 后序遍历 左右根
    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        deque.push(root);
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            final TreeNode node = deque.pop();
            deque1.push(node);
            if (node.left != null) {
                deque.push(node.left);
            }

            if (node.right != null) {
                deque.push(node.right);
            }
        }
        while (!deque1.isEmpty()) {
            result.add(deque1.pop().val);
        }
        return result;
    }

    public static List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.push(root);

        List<Integer> result = new ArrayList<>();

        while (!deque.isEmpty()) {
            final Node pop = deque.pop();
            result.add(pop.val);

            final List<Node> childrens = pop.children;
            if (childrens != null && childrens.size() != 0) {
                for (int i = childrens.size() - 1; i >= 0; i--) {
                    deque.push(childrens.get(i));
                }
            }
        }
        return result;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 每个右括号都有一个对应的相同类型的左括号。
     * 
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        final char[] chars = s.toCharArray();

        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : chars) {
            switch (ch) {
                case '(':
                    deque.push(')');
                    break;
                case '[':
                    deque.push(']');
                    break;
                case '{':
                    deque.push('}');
                    break;
                default:
                    if (deque.isEmpty()) {
                        return false;
                    }
                    char tmp = deque.pop();
                    if (ch != tmp) {
                        return false;
                    }
                    break;
            }
        }
        return deque.isEmpty();
    }

    public static List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();

        Deque<Node> deque = new ArrayDeque<>();
        Deque<Node> deque1 = new ArrayDeque<>();
        deque.push(root);

        while (!deque.isEmpty()) {
            final Node node = deque.pop();
            deque1.push(node);

            final List<Node> children = node.children;
            if (children != null && children.size() != 0) {
                for (Node child : children) {
                    deque.push(child);
                }
            }
        }

        while (!deque1.isEmpty()) {
            result.add(deque1.pop().val);
        }

        return result;
    }

    public static void reverse(ListNode head) {
        ListNode tmp = head;
        ListNode pre = null;
        while (tmp != null) {
            ListNode next = tmp.next;
            tmp.next = pre;
            pre = tmp;
            tmp = next;
        }
    }

    public static int test() {
        int[] a = new int[] { 1, 2, 3 };
        int[] b = new int[] { 1, 2, 3 };
        int[] c = new int[] { 1, 2, 3 };

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    result = a[i] + b[j] * c[k];
                }
            }
        }
        return result;
    }

}

class Stu {
    int val;
    String name;

    public Stu(int val, String name) {
        this.val = val;
        this.name = name;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ", next=" + next + '}';
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
