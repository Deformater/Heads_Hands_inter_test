package inters;

public class Hero extends Entity{
    int healCount = 0;

    public Hero(int maxHealth, int attack, int defence, int minDamage, int maxDamage) {
        super(maxHealth, attack, defence, minDamage, maxDamage);
    }

    public void heal (){
        if (this.healCount < 4){
            this.healCount += 1;
            int health = super.health + (int)(super.maxHealth * 0.33);
            if (health > super.maxHealth){
                health = super.maxHealth;
            }
            super.setHealth(health);
        } else {
            System.out.println("You can't heal any more");
        }
    }
}
