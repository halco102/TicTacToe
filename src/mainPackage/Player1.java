package mainPackage;

public class Player1 extends Player{
    private final String name = "Player1";
    private final String player1Character = "X";



    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void setCharacter(String character){
        this.character=character;
    }
    @Override
    public String getCharacter(){
        return this.character;
    }

    public String getPlayerCharacter(){
        return this.player1Character;
    }

}
