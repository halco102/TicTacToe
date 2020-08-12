package mainPackage.player;

import mainPackage.player.Player;

import java.util.Random;

public class AiPlayer extends Player {
    private final String name = "Computer";
    private final String Computer = "O";
    private boolean isFirstTime=true;

    public AiPlayer(){}


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
        return this.Computer;
    }


    public int setPositionFirstTime(){
        Random random = new Random();
        int rand;
        int upper=9;
        rand=random.nextInt(upper-1);
        this.isFirstTime=false;
        return rand;
    }



    public boolean getIsFirstTime(){
        return this.isFirstTime;
    }



}
