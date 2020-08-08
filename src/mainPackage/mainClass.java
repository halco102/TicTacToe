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

    public static void main(String[] args){
        char ch = 'Y';
        Scanner inChar = new Scanner(System.in);
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

            /*if(temp<9) {
                inGamePlayer1(p1, logic);
                temp++;
                if(temp<8) {
                    inGamePlayer2(p2, logic);
                }
                temp++;
            */
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

    }
}
