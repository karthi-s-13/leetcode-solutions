class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int courseEnrolled = 0;
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[numCourses];
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indeg[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int edge : adj.get(u)){
                if( --indeg[edge]  == 0) queue.add(edge);
            }
            courseEnrolled++;
        }
        return courseEnrolled == numCourses;

    }
}