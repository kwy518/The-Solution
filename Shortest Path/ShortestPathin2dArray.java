import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathin2dArray {
    // Use array
    public int shortestPathWithoutNode(char[][] matrix){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 'S') {
                    q.offer(new int[]{i,j,0}); //The source's position and the distance from itself.
                    break;
                }
            }
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                int[] pos = q.poll();  // pos = [ row, column, distance]
                if(matrix[pos[0]][pos[1]] == 'D') {
                    return pos[2];
                }else {
                    matrix[pos[0]][pos[1]] = '0';
                    for(int[] dir: dirs) {
                        int x = pos[0] + dir[0];
                        int y = pos[1] + dir[1];
                        int dis = pos[2];
                        if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] != '0') {
                            q.offer(new int[]{x,y, dis+1});
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    
//  ----------------------------------------------------------------------------------------------------------
//  Nodes Version:
    
    
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
    
    public int shortestPath(char[][] matrix) {
        int sRow = 0, sCol = 0;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                if(matrix[i][j] == 'S') {
                    sRow = i;
                    sCol = j;
                    break;
                }
            }
        }

        Node source = new Node(sRow, sCol, 0);
        Queue<Node> q = new LinkedList<>();
        q.offer(source);
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
        return -1;
    }

    
    public static void main(String[] args) {
        ShortestPathin2dArray test = new ShortestPathin2dArray();
        char[][] test1 = {
                {'S', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };
        char[][] test2 = {
                {'0', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'S', '1', '1', '1'},
                {'1', '0', 'D', '1'}
        };
        char[][] test3 = {
                {'S', '0', '1', '1'},
                {'1', '1', '0', '1'},
                {'0', '1', '0', '1'},
                {'1', '0', 'D', '1'}
        };

        System.out.println(test.shortestPathWithoutNode(test1)); // answer is 5
        System.out.println(test.shortestPathWithoutNode(test2)); // answer is 3
        System.out.println(test.shortestPathWithoutNode(test3)); // answer is -1
    }
}
