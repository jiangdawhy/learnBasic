package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Online3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        String  skip = sc.nextLine();

        char[][] arr = new char[rows][cols];
        for(int i = 0; i < rows; i++){
            String curRow = sc.nextLine();
            char[] curRowArr = curRow.toCharArray();
            for(int j = 0; j < cols; j++){
                arr[i][j] = curRowArr[j];
            }
        }

        int numOfOrders = sc.nextInt();

        sc.nextLine();
        List<String> orders = new ArrayList<>();

        for(int i = 0; i < numOfOrders; i++){
            orders.add(sc.nextLine());
        }

        int r = 0, c = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 'R') {
                    r = i;
                    c = j;
                    break;
                }
            }
        }
        int preRow = r, preCol = c;

        int[][] dirs = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1},

        };

        int[] curDir = {-1 ,0};
        int count = 0;

        for(int i = 0; i < orders.size(); i++){
            String order = orders.get(i);
            String[] split = order.split(" ");
            // turn order
            if(split[0].equals("Turn")){
                if(split[1].equals("left")){
                    count = (count + 3) % 4;
                    curDir = dirs[count];
                }else {
                    count = (count + 1) % 4;
                    curDir = dirs[count];
                }
            }
            // forward order
            else{
                int steps = Integer.parseInt(split[1]);
                for(int idx = 0; idx < steps; idx++){
                    int[] nextMove = {r + curDir[0], c + curDir[1]};
                    //判断是否越界
                    if(nextMove[0] < 0 || nextMove[0] == arr.length || nextMove[1] < 0 || nextMove[1] == arr[0].length) break;
                    //判断是否遇到障碍
                    if(arr[nextMove[0]][nextMove[1]] == 'O') break;
                    r = nextMove[0];
                    c = nextMove[1];
                }
            }
        }
        int diffRow = r - preRow;
        int diffCol = c - preCol;
        System.out.println(diffRow + " " + diffCol);

    }
}
