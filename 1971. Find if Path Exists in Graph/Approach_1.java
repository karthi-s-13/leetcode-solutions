class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adj = new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            if(current == destination) return true;
            for(int neighbour : adj[current]){
                if(!visited[neighbour]){
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
            
        }
        return false;
    }
}