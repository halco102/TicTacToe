package mainPackage;

public class Logic extends TicTacToe {

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

              }else
                System.out.println("Its filled already");
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
}
