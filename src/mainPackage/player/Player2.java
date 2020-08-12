package mainPackage.player;

import mainPackage.player.Player;

public class Player2 extends Player {
    private final String name="Player2";
    private final String player2Character = "O";

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
        return this.player2Character;
    }

}
