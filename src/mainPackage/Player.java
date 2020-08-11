package mainPackage;

public class Player {
        protected int position;
        private String name="";
        protected String character="";

        public Player(){}

        public void setPosition(int position){
            this.position=position;
        }
        public int getPosition(){
            return this.position;
        }

        public String getName(){
          return this.name;
        }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
