package mainPackage.tictactoe;

import mainPackage.player.AiPlayer;
import mainPackage.player.Player;

public class Logic extends TicTacToe { //In sake of testing Inheritance i didnt follow IS-A relationship




    private boolean isOpen;
    private boolean closeGame;
    private int temp=0;

    @Override
    public void display() {
        System.out.print(this.position[0]+"\t|"+"\t"+this.position[1] + "\t|" + "\t"+this.position[2]+"\n");
        System.out.print("------------------\n");
        System.out.print(this.position[3]+"\t|"+"\t"+this.position[4] + "\t|" + "\t"+this.position[5]+"\n");
        System.out.print("------------------\n");
        System.out.print(this.position[6]+"\t|"+"\t"+this.position[7] + "\t|" + "\t"+this.position[8]+"\n");
    }



    @Override
    public void setPosition(int position, Player player) {
          if(position<0 || position>8){
              System.out.println("Position has to be between 0 and 8");
          }else {
              isOpen(position);
              if (getIsOpen() == true) {
                  this.position[position] = player.getCharacter();

              }else {
                  System.out.println("Its filled already position : " + position);
                    }
                }

          }

    public boolean checkWinner(Player player){
        if((this.position[0]== player.getCharacter() && this.position[1]== player.getCharacter() &&
                this.position[2]== player.getCharacter())
        ||(this.position[3]== player.getCharacter() && this.position[4]== player.getCharacter() &&
                this.position[5]== player.getCharacter())
        ||(this.position[6]== player.getCharacter() && this.position[7]== player.getCharacter() &&
                this.position[8]==player.getCharacter())
        ||(this.position[0]== player.getCharacter() && this.position[4]== player.getCharacter() &&
                this.position[8]== player.getCharacter())
        ||(this.position[2]== player.getCharacter() && this.position[4]== player.getCharacter() &&
                this.position[6]== player.getCharacter())
        ||(this.position[0]== player.getCharacter() && this.position[3]== player.getCharacter() &&
                this.position[6]== player.getCharacter())
        ||(this.position[1]== player.getCharacter() && this.position[4]== player.getCharacter() &&
                this.position[7]== player.getCharacter())
        ||(this.position[2]== player.getCharacter() && this.position[5]== player.getCharacter() &&
                this.position[8]== player.getCharacter()))
        {
            System.out.println("The winner is " + player.getName());
            this.closeGame=true;
        }
        return this.closeGame;
    }

    public int getTemp(){
        return this.temp;
    }

    public void setTemp(int temp){
        this.temp=temp;
    }

    private boolean isOpen(int position) {

            if(this.position[position]=="X" || this.position[position]=="O"){
                this.isOpen=false;
            }else{
                this.isOpen=true;
            }

            return isOpen;
    }

    @Override
    public String[] getPosition(){
        return this.position;
    }


    public boolean getIsOpen(){
        return this.isOpen;
    }

    public void setCloseGame(boolean closeGame){
        this.closeGame=closeGame;
    }
    public boolean getCloseGame(){
        return this.closeGame;
    }

    //AILogic
        public void blockWinForPlayer(Player player, AiPlayer ai){
        /*    if((this.position[0]=="X" && this.position[1]=="X" && this.position[2]==" ") ||
                    (this.position[0]=="X" && this.position[2]=="X" && this.position[1]==" ")||
                    (this.position[1]=="X" && this.position[2]=="X" && this.position[0]==" ") ||
                    (this.position[3]=="X" && this.position[4]=="X" && this.position[5]==" ")||
                    (this.position[4]=="X" && this.position[5]=="X" && this.position[3]==" ") ||
                    (this.position[3]=="X" && this.position[5]=="X" && this.position[4]==" ") || 6
                    (this.position[6]=="X" && this.position[7]=="X" && this.position[8]==" ") ||
                    (this.position[7]=="X" && this.position[8]=="X" && this.position[6]==" ") ||
                    (this.position[6]=="X" && this.position[8]=="X" && this.position[7]==" ") ) { //IF body
                System.out.println("No win for you");
            }
          */
            boolean closed=false;

            //ON X
            if(this.position[0]=="X" && this.position[1]=="X" && this.position[2]==" "&& closed==false){
                ai.setPosition(2);
                setPosition(ai.getPosition(),ai);
                closed=true;

            }else if(this.position[0]=="X" && this.position[2]=="X" && this.position[1]==" " && closed==false){
                ai.setPosition(1);
                setPosition(ai.getPosition(),ai);
                closed=true;
            }else if(this.position[1]=="X" && this.position[2]=="X" && this.position[0]==" "){
                ai.setPosition(0);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[3]=="X" && this.position[4]=="X" && this.position[5]==" "){
                ai.setPosition(5);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[4]=="X" && this.position[5]=="X" && this.position[3]==" "){
                ai.setPosition(3);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[3]=="X" && this.position[5]=="X" && this.position[4]==" "){
                ai.setPosition(4);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[6]=="X" && this.position[7]=="X" && this.position[8]==" "){
                ai.setPosition(8);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[7]=="X" && this.position[8]=="X" && this.position[6]==" "){
                ai.setPosition(6);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[6]=="X" && this.position[8]=="X" && this.position[7]==" "){
                ai.setPosition(7);
                setPosition(ai.getPosition(),ai);
            }
            //END
            //ON Y
            else if(this.position[0]=="X" && this.position[3]=="X" && this.position[6]==" "){
                ai.setPosition(6);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[3]=="X" && this.position[6]=="X" && this.position[0]==" "){
                ai.setPosition(0);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[0]=="X" && this.position[6]=="X" && this.position[3]==" "){
                ai.setPosition(3);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[1]=="X" && this.position[4]=="X" && this.position[7]==" "){
                ai.setPosition(7);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[4]=="X" && this.position[7]=="X" && this.position[1]==" "){
                ai.setPosition(1);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[1]=="X" && this.position[7]=="X" && this.position[4]==" "){
                ai.setPosition(4);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[0]=="X" && this.position[6]=="X" && this.position[3]==" "){
                ai.setPosition(3);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[1]=="X" && this.position[7]=="X" && this.position[4]==" "){
                ai.setPosition(4);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[2]=="X" && this.position[8]=="X" && this.position[5]==" "){
                ai.setPosition(5);
                setPosition(ai.getPosition(),ai);
            }
            //END
            //DIAGONAL
            else if(this.position[0]=="X" && this.position[4]=="X" && this.position[8]==" "){
                ai.setPosition(8);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[0]=="X" && this.position[8]=="X" && this.position[4]==" "){
                ai.setPosition(4);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[4]=="X" && this.position[8]=="X" && this.position[0]==" "){
                ai.setPosition(0);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[2]=="X" && this.position[4]=="X" && this.position[6]==" "){
                ai.setPosition(6);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[4]=="X" && this.position[6]=="X" && this.position[2]==" "){
                ai.setPosition(2);
                setPosition(ai.getPosition(),ai);
            }else if(this.position[2]=="X" && this.position[6]=="X" && this.position[4]==" "){
                ai.setPosition(4);
                setPosition(ai.getPosition(),ai);
            }//else if(fillEmptyLastSpace()!=0){
               // ai.setPosition(fillEmptyLastSpace());
                //setPosition(ai.getPosition(),ai);
                //}
            else if (fillEmptyLastSpace()==0){
                do{
                ai.setPosition(ai.setPositionFirstTime());
                setPosition(ai.getPosition(),ai);
               // System.out.println("No if statment was true");
            }while(isOpen!=true);

            }

        }
    //

    private int fillEmptyLastSpace(){
        int temp=0;
        int tempLastSpace=0;
        //int returnValue=0;
        for(int i = 0 ; i < this.position.length;i++){
            if(this.position[i]==""){
                temp++;
                tempLastSpace=i;
            }
        }
        if(temp==1){
             return tempLastSpace;
        }
        return 0;
    }
}
