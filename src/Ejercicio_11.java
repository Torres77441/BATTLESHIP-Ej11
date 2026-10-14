import java.util.Scanner;
public class Ejercicio_11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean gameOver = false;
        char[][] tablero;
        tablero = new char[8][8];
        int disparos = 0,hundidos = 0, numShips = 10;

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = ' ';
            }
        }

        addShips(tablero);

        while (!gameOver) {
            printTablero(tablero, false, disparos, hundidos);
            int row = getRow(input);
            int col = getCol(input);
            if (tablero[row][col] == 'S'){
                tablero[row][col] = 'X';
                hundidos++;
                numShips--;
            }else {
                tablero[row][col] = 'O';
            }
            disparos++;
        }

    }
    //EL TABLERO
    static void printTablero(char [][] tablero, boolean debug, int disparos, int hundidos) {
        System.out.println("Has hundido "+ hundidos + " barcos");
        System.out.println("has disparado "+ disparos + " veces");
        System.out.print("◯ ");
        for (int i = 1; i <= 8; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(((char) (65 + i)) + " ");
            for (int j = 0; j < tablero[0].length; j++) {
                if (debug) {
                    System.out.print(tablero[i][j] + " ");
                } else {
                    if (tablero[i][j] == 'S') {
                        System.out.print("  ");
                    }else{
                        System.out.print(tablero[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }
    //CREANDO LOS BARCOS
    static void addShips(char[][] tablero) {
        int numShips = 0;
        while (numShips < 10) {
            int row = (int) (Math.random() * tablero.length);
            int col = (int) (Math.random() * tablero[0].length);
            if (tablero[row][col] != 'S') {
                tablero[row][col] = 'S';
                numShips++;
            }
        }
    }
    //CONSIGUIENDO LOS VALORES
    static int getRow(Scanner input) {
        System.out.print("Dame la letra de la fila: ");
        char letter = input.next().charAt(0);
        int row = letter - 65;
        return row;
    }
    static int getCol(Scanner input) {
        System.out.print("Dame el número de la columna: ");
        int col = input.nextInt() - 1;
        return col;
    }
}