package inters;

public class Hero extends Entity{
    int healCount = 0;

    protected Hero(int maxHealth, int attack, int defence, int minDamage, int maxDamage) {
        super(maxHealth, attack, defence, minDamage, maxDamage);
    }

    protected void heal (){
        if (this.healCount < 4){
            this.healCount += 1;
            int health = (int) (super.health * 1.3);
            if (health > super.maxHealth){
                health = super.maxHealth;
            }
            super.setHealth(health);
        } else {
            System.out.println("You can't heal any more");
        }
    }
}
