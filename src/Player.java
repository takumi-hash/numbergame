public class Player {
    private int hp = 50;
    private String name;
    public Player(String name){
        this.name = name;
    }

    public int getHp(){
        return this.hp;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public String getName() {
        return this.name;
    }
    public void attack(Monster m){
        m.setHp(m.getHp()-5);
    }
    public void kick(Monster m){
        m.setHp(m.getHp()-10);
    }
}
