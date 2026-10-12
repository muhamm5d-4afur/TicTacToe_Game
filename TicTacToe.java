import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] arr = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        char currentp = 'X';
        int m = 0;
        boolean won = false;
        Scanner scanner = new Scanner(System.in);

        while (!won && m < 9){
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    System.out.print(arr[i][j] + "  ");
                }
                System.out.println();
            }
            System.out.print("player " + currentp + " choose a number between 1 and 9: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= 9){
                int row = (choice-1)/3;
                int col = (choice-1)%3;
                
                if (arr[row][col] != 'X' && arr[row][col] != 'O'){
                    arr[row][col] = currentp; 
                    m++;

                    if (
                        (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2]) ||
                        (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2]) ||
                        (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2]) ||
                        (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0]) ||
                        (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1]) ||
                        (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2]) ||
                        (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2]) ||
                        (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0])
                    ){
                        won = true; 
                        System.out.println("congratulations ! " + currentp + " won ");
                    } else if (m == 9) {
                        break;
                    } else {
                        currentp = (currentp == 'X') ? 'O' : 'X';
                    }

                } else {
                    System.out.println("this cell is already full");
                }
            } else {
                System.out.println("u can only choose num between 1 and 9");
            }
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        
        if (!won) {
            System.out.println("draw ");
        }
    }
}