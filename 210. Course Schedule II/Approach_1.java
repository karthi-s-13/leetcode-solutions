class Solution {
    public int[] findOrder(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg  = new int[n];
        for(int[] edge : pre){
            adj.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i] == 0) queue.add(i);
        }
        int[] order = new int[n];
        int k=0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            order[k++] = u;
            for(int edge : adj.get(u)){
                if(--indeg[edge] == 0) queue.add(edge);
            }
        }
        return k == n ? order : new int[0];
    }
}