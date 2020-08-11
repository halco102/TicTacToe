package mainPackage;

import java.util.Scanner;


public class mainClass {


public static void inGamePlayer1(Player p1,Logic logic){
    do{
        System.out.println(p1.getName());
        int input;
        Scanner in = new Scanner(System.in);
        System.out.print("Input position : ");
        input=in.nextInt();
        p1.setPosition(input);
        logic.setPosition(p1.getPosition(),p1);
        logic.display();

    }while(logic.getIsOpen()!=true);


}

    public static void inGamePlayer2(Player p2,Logic logic){
        do{
            System.out.println(p2.getName());
            int input;
            Scanner in = new Scanner(System.in);
            System.out.print("Input position : ");
            input=in.nextInt();
            p2.setPosition(input);
            logic.setPosition(p2.getPosition(),p2);

            logic.display();


        }while(logic.getIsOpen()!=true);

    }


    public static void inGameAi(AiPlayer aiPlayer,Logic logic,Player p1){
    //do{
        System.out.println(aiPlayer.getName());
        if(aiPlayer.getIsFirstTime()==true && logic.getIsOpen()==true ){
            aiPlayer.setPosition(aiPlayer.setPositionFirstTime());
            logic.setPosition(aiPlayer.getPosition(), aiPlayer);
            logic.display();
        }
            logic.blockWinForPlayer(p1,aiPlayer);
            logic.display();


    System.out.println("The computer is playing ....");

   // }while (l.getIsOpen()!=true);

    }


    public static void main(String[] args){
        char ch = 'Y';
        int gameMode;
        Scanner in = new Scanner(System.in);


        do {

            System.out.println("TicTacToe");
            System.out.println("Select Game mode 1:vs Computer \t 2:vs Player");
            System.out.print("Input : ");
            gameMode=in.nextInt();

            switch (gameMode) {
                case 1: {
                    System.out.println("Vs Computer");

                    AiPlayer aiPlayer = new AiPlayer();
                    TicTacToe tic = new TicTacToe();
                    Logic logic = new Logic();
                    Player1 p1 = new Player1();
                    int temp = 0;
                    p1.setCharacter(p1.getPlayerCharacter());
                    aiPlayer.setCharacter(aiPlayer.getPlayerCharacter());
                    tic.display();
                    do {
                        if (logic.getPosition().length < 3) {
                            inGamePlayer1(p1, logic);
                            inGameAi(aiPlayer, logic, p1);
                        } else {
                            if (logic.checkWinner(p1) != true || logic.checkWinner(aiPlayer) != true) {


                                if (temp < 9) {
                                    inGamePlayer1(p1, logic);
                                    temp++;
                                    if (logic.checkWinner(p1) == true) {
                                        break;
                                    }
                                }
                                if (temp < 8) {
                                    inGameAi(aiPlayer, logic, p1);
                                    temp++;
                                    if (logic.checkWinner(aiPlayer) == true) {
                                        break;
                                    }

                                }
                                if (temp == 9 && logic.checkWinner(p1) != true && logic.checkWinner(aiPlayer) != true) {
                                    System.out.println("No winner");
                                    break;
                                }
                            }
                        }
                    } while (logic.getCloseGame() != true || temp < 8);
                    System.out.println("Do you want to start a new game ? Y or y for Yes, n or N for No");
                    ch=in.next().charAt(0);
                    break;
                }
                case 2: {
                    System.out.println("Vs Player");

                    Player1 p1 = new Player1();
                    Player2 p2 = new Player2();
                    TicTacToe tic = new TicTacToe();
                    Logic logic = new Logic(); //cuva sve na ovom referetnom tipu
                    int temp = 0;

                    p1.setCharacter(p1.getPlayerCharacter());
                    p2.setCharacter(p2.getPlayerCharacter());
                    tic.display();
                    System.out.println("The first one to play is " + p1.getName());

                    do {
                        if (logic.getPosition().length < 3) {
                            inGamePlayer1(p1, logic);
                            inGamePlayer2(p2, logic);
                        } else {
                            if (logic.checkWinner(p1) != true || logic.checkWinner(p2) != true) {
                                if (temp < 9) {
                                    inGamePlayer1(p1, logic);
                                    temp++;
                                    if (logic.checkWinner(p1) == true) {
                                        break;
                                    }
                                }
                                if (temp < 8) {
                                    inGamePlayer2(p2, logic);
                                    temp++;
                                    if (logic.checkWinner(p2) == true) {
                                        break;
                                    }

                                }
                                if (temp == 9 && logic.checkWinner(p1) != true && logic.checkWinner(p2) != true) {
                                    System.out.println("No winner");
                                    break;
                                }
                            }
                        }
                    } while (logic.getCloseGame() != true || temp < 8);
                    System.out.println("Do you want to start a new game ? Y or y for Yes, n or N for No");
                    ch=in.next().charAt(0);
                    break;
                }

                default: {
                    System.out.println("Game mode is only 1 or 2");
                    break;
                }
            }//end case
        }while(ch=='y' || ch=='Y');

            System.out.println("Thank you for playing Tic Tac Toe");

        /*

        do{
            Player1 p1 = new Player1();
            Player2 p2 = new Player2();
            TicTacToe tic = new TicTacToe();
            Logic logic = new Logic(); //cuva sve na ovom referetnom tipu
            int temp=0;

            p1.setCharacter(p1.getPlayerCharacter());
            p2.setCharacter(p2.getPlayerCharacter());
            tic.display();
            System.out.println("The first one to play is " + p1.getName());

            do{
                if(logic.getPosition().length<3){
                    inGamePlayer1(p1,logic);
                    inGamePlayer2(p2,logic);
                }else{
                    if(logic.checkWinner(p1)!=true||logic.checkWinner(p2)!=true){
                        if(temp<9){
                            inGamePlayer1(p1,logic);
                            temp++;
                            if(logic.checkWinner(p1)==true){
                                break;
                            }
                        }
                        if(temp<8){
                            inGamePlayer2(p2,logic);
                            temp++;
                            if(logic.checkWinner(p2)==true){
                                break;
                            }

                        }
                        if(temp==9 && logic.checkWinner(p1)!=true && logic.checkWinner(p2)!=true){
                            System.out.println("No winner");
                            break;
                        }
                    }
                }
            }while(logic.getCloseGame()!=true || temp<8);
            System.out.println("Do you want to start a new game ? Y or y for Yes, n or N for No");
            ch=inChar.next().charAt(0);
        }while(ch=='y' || ch=='Y');

        System.out.println("Thank you for playing Tic Tac Toe");
*/
    }
}
