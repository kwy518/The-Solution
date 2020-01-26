Given a 2D array with values as `S`, `D`, `1` and `0`.
  - S is the Source.
  - D is the Destination.
  - 1 marks the valid path.
  - 0 marks the obstacle.
  
Find the shortest distance from S to D avoiding all the obstacles.

----------
For example:

|S|0|1|1|
|-|-|-|-|
|1|1|0|1|
|0|1|1|1|
|1|0|D|1|


In the above matrix, the minimum distances from S to D is 5.

-----------

  - __Solution 1:__ 
    - Using Nodes:
      - Create a Node class, recoring every node's row, column and its distance from the source
      
      ```java
      public class Node {
        int row;
        int col;
        int distanceFromSource;

        Node(int r, int c, int dis) {
            this.row = r;
            this.col = c;
            this.distanceFromSource = dis;
        }
      }
      ```
      - Traverse the whole matrix, finding the position of the source.
      
      ```Java
      for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 'S') {
                    q.offer(new int[]{i,j,0}); //The source's position and the distance from itself.
                    break;
                }
            }
      }
      ```
      - Use BFS to traverse all the allowed nodes **(Not obstacles)** and record its distance to the source. Each searhing plus 1 to the distance.
      - When we meet `D`, stop the searching and return the value of the distance.
      
      ```java
      int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            for(int i = 0 ; i < q.size() ; i++) {
                Node node = q.poll();
                if(matrix[node.row][node.col] == 'D') {
                    return node.distanceFromSource;
                } else {
                    matrix[node.row][node.col] = '0';
                    for(int[]dir : dirs) {
                        int r = node.row + dir[1];
                        int c = node.col + dir[0];
                        if(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] != '0' )
                            q.offer(new Node(r , c, node.distanceFromSource + 1));
                    }
                }
            }
       }
       ```
    
  - __Solution 2__
