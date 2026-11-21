import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;

        List<Integer>[] children = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        // Build original tree
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] newParent = parent.clone();
        int[] last = new int[26];
        Arrays.fill(last, -1);

        // Iterative DFS using enter/exit states
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{0, 0});

        while (!st.isEmpty()) {

            int[] curr = st.pop();
            int node = curr[0];
            int state = curr[1];

            int ch = s.charAt(node) - 'a';

            if (state == 0) {

                int prev = last[ch];

                if (node != 0 && prev != -1) {
                    newParent[node] = prev;
                }

                last[ch] = node;

                st.push(new int[]{node, 1});

                for (int i = children[node].size() - 1; i >= 0; i--) {
                    st.push(new int[]{children[node].get(i), 0});
                }

            } else {

                // Restore nearest ancestor for this character
                int prev = -1;

                for (int i = st.size() - 1; i >= 0; i--) {
                    int[] item = st.get(i);

                    if (item[1] == 0 &&
                        s.charAt(item[0]) == s.charAt(node)) {
                        prev = item[0];
                        break;
                    }
                }

                last[ch] = prev;
            }
        }

        // Build modified tree
        List<Integer>[] updated = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            updated[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            updated[newParent[i]].add(i);
        }

        // Get postorder traversal
        int[] order = new int[n];
        int idx = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            order[idx++] = node;

            for (int child : updated[node]) {
                stack.push(child);
            }
        }

        // Calculate subtree sizes
        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        for (int i = n - 1; i >= 0; i--) {
            int node = order[i];

            if (newParent[node] != -1) {
                ans[newParent[node]] += ans[node];
            }
        }

        return ans;
    }
}

