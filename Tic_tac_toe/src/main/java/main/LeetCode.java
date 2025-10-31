package main;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class LeetCode {
    public int minimumArea(int[][] grid) {
        return getWidth(grid);
    }
    public int getWidth(int[][] grid){
        int start = Integer.MAX_VALUE;
        int end  = -1;
        int start1 = Integer.MAX_VALUE;
        int end1  = -1;
        for(int i = 0;i<grid.length;i++)
        {
            for(int j = 0;j<grid.length;j++)
            {
                if(grid[i][j] == 1)
                {
                    start = Math.min(start, j);
                    end  = Math.max(end, j);
                    start1 = Math.min(start1, i);
                    end1 = Math.max(end1, i);
                }
            }
        }
        return (end- start)* (end1 - start1);
    }

    public static void main(String[] args) {

    }
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Tries t = new Tries();
        t.insertFolders(paths);
        return t.getPath(paths);
    }

    private static int k;
    private static int[] val;
    private static List<List<Integer>> adj;

    public static long getMaximumEfficiency(int connectNodes, List<Integer> connectFrom, List<Integer> connectTo, List<Integer> computer_val, int k_input)
    {
        k = k_input;
        val = new int[connectNodes + 1];
        adj = new ArrayList<>();

        for (int i = 0; i <= connectNodes; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connectNodes; i++)
        {
            val[i + 1] = computer_val.get(i);
        }

        for (int i = 0; i < connectFrom.size(); i++)
        {
            int u = connectFrom.get(i);
            int v = connectTo.get(i);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        long[] result = dfs(1, 0);
        return  result[0] - (long) k * result[1];
    }
    public int numberOfWays(int n, int x) {
        return (int) getRes(n, x, 1,new Long[n+1][n+1]);

    }
    private static final int MOD = 1_000_000_007;
    public long getRes(int n, int x,int currVal, Long[][]dp)
    {
        if(n<0)
            return 0;
        if(n == 0)
            return 1;
        if(getVal(currVal, x) > n)
            return 0;
       long res =  getRes(n-getVal(currVal, x) ,x,currVal+1, dp);
       res += getRes(n ,x,currVal+1, dp);
       res %= MOD;
       return res;
    }
    public int getVal(int n, int x){
        int res = 1;
        while(x>0)
        {
            res*=n;
            x--;
        }
        return res;
    }

    private static long[] dfs(int node, int parent)
    {
        int totalVal = val[node];
        int totalOps = 0;

        for (int child : adj.get(node))
        {
            if (child == parent)
                continue;

            long[] childRes = dfs(child, node);
            totalVal += childRes[0];
            totalOps += childRes[1];
        }

        int keepScore = totalVal - k * totalOps;
        int deleteScore = -k;

        if (keepScore >= deleteScore)
        {
            return new long[]{totalVal, totalOps};
        }
        else
        {
            return new long[]{0, 1};  // cut this subtree
        }
    }

    class Tries{
        Node root = new Node();
        HashMap<String, Integer> subFolderPathCount = new HashMap<>();
        public void insertFolder(List<String> path, int index,Node root)
        {
            if(index>= path.size())
                return ;
            String currFolderName = path.get(index);
            root.createDirectory(currFolderName, new Node());
            root.folderName = currFolderName;
            insertFolder(path, index+1, root.getDirectory(currFolderName));
            return;

        }
        public List<String> getPath(List<String> path, int index,Node root){
            if(index>= path.size() || ( subFolderPathCount.containsKey(root.subFolderPath) && subFolderPathCount.get(root.subFolderPath)>1))
                return new ArrayList<>();
            List<String> result = getPath(path, index+1, root.getDirectory(path.get(index)));
            result.add(path.get(index));
            return result;

        }
        public List<String> getSubFolderPath(Node node){
            List<String> result = new ArrayList<>();
            List<String> SubFolderPath = new ArrayList<>();
            for(String currFolder: node.map.keySet())
            {
                result.add(currFolder);
                System.out.println("currFolder -->>"+currFolder);
                SubFolderPath.addAll( getSubFolderPath(node.map.get(currFolder)));

            }
            result.addAll(SubFolderPath);
            System.out.println("result -->>"+result);
            Collections.sort(result);
            return result;

        }


        public List<List<String>> getPath(List<List<String>> paths){
            System.out.println("subFolderPathCount-->>"+subFolderPathCount);
            List<List<String>> result = new ArrayList<>();
            for(List<String> path: paths){
                List<String> currRes = getPath(path, 0, root);
                System.out.println("currRes-->>"+currRes);
                if(currRes.size()>1){
                    Collections.reverse(currRes);
                    result.add(currRes);
                }
            }

            return result;

        }
        public void insertFolders(List<List<String>> paths){
            for(List<String> path: paths){
                insertFolder(path, 0, root);
            }

        }
    }
    class Node{
        HashMap<String, Node> map = new HashMap<>();
        String folderName = "";
        String subFolderPath = "";

        public void createDirectory(String folderName, Node node){
            map.put(folderName, node);
        }
        public Node getDirectory(String str){
            return map.get(str);
        }
        public boolean containsDirectory( String str)
        {
            return map.containsKey(str);
        }



    }
}
