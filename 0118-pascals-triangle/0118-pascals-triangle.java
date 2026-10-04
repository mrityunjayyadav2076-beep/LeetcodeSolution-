class Solution 
{
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(List.of(1));
      
        for (int i = 0; i < numRows - 1; i++) 
        {
            List<Integer> cr = new ArrayList<>();
            cr.add(1);
          
            List<Integer> pr = pascalTriangle.get(i);
            for (int j = 1; j < pr.size(); j++) 
            {
                int sum = pr.get(j - 1) + pr.get(j);
                cr.add(sum);
            }
          
            cr.add(1);
          
            pascalTriangle.add(cr);
        }
      
        return pascalTriangle;
    }
}
