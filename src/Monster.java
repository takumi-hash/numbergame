public class Monster {
    private int hp = 100;
    private final String name = "Monster";

    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public String getName(){
        return this.name;
    }
    public void attack(Player p){
        p.setHp(p.getHp()-5);
    }
}
