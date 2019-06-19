import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LexicographicalNumbers {

    public static LinkedList<Integer> ret;

    public List<Integer> lexicalOrder(int n) {

        ret = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                ret.add(i);
                dfs(i, n);
            }
        }
        return ret;
    }

    public static void dfs(int num, int n) {
        if (num > n)
            return;
        for (int i = 0; i <= 9; i++) {
            int t = num * 10 + i;
            if (t <= n) {
                ret.add(t);
                dfs(t, n);
            } else
                break;
        }
    }

    public List<Integer> lexicalOrder1(int n) {
        LinkedList<Integer> ret = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = n <= 9 ? n : 9; i > 0; i--) {
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            ret.add(cur);

            for (int j = 9; j >= 0; j--) {
                int val = cur * 10 + j;
                if (val <= n)
                    stack.push(val);
            }
        }
        return ret;
    }

    public List<Integer> lexicalOrder2(int n)
    {
        LinkedList<Integer> list=new LinkedList<>();
        String[] vals=new String[n];
        for(int i=1;i<=n;i++)
            vals[i-1]=String.valueOf(i);
        Arrays.sort(vals);
        for(String val:vals)
            list.add(Integer.valueOf(val));
        return list;
    }
}
