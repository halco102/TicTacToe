package mainPackage;




public class TicTacToe {
    protected String position[] = new String[9];
    private final String player1="X";
    private final String getPlayer2="O";
    protected boolean repeat=true;


    public TicTacToe(){
        for(int i = 0 ; i < this.position.length;i++){
            this.position[i]=" ";
        }
    }



    public void display(){
        System.out.print(" "+"\t|"+"\t" + "\t|" + "\t\n");
        System.out.print("------------------\n");
        System.out.print(" "+"\t|"+"\t" + "\t|" + "\t\n");
        System.out.print("------------------\n");
        System.out.print(" "+"\t|"+"\t" + "\t|" + "\t\n");

    }

    public void setPosition(int position, Player player) {
      this.position[position]=player.getCharacter();
    }

    public void testArray(){
        for(int i = 0 ; i < this.position.length;i++){
            System.out.println("Array population  " + this.position[i]);
        }
    }


    public String[] getPosition(){
        return this.position;
    }

}
