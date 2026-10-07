class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        List<Integer>[] graph = new List[numCourses];
        Arrays.setAll(graph, index -> new ArrayList<>());
      
        int[] inDegree = new int[numCourses];
      
        for (int[] prerequisite : prerequisites) 
        {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            graph[prerequisiteCourse].add(course);
            inDegree[course]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) 
        {
            if (inDegree[course] == 0) 
            {
                queue.offer(course);
            }
        }
        while (!queue.isEmpty()) 
        {
            int currentCourse = queue.poll();
            numCourses--;
          
            for (int dependentCourse : graph[currentCourse]) 
            {
                inDegree[dependentCourse]--;
             
                if (inDegree[dependentCourse] == 0) 
                {
                    queue.offer(dependentCourse);
                }
            }
        }
      
        return numCourses == 0;
    }
}
