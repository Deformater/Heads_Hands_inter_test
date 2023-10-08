package inters;


public class Entity {
    protected int attack;
    protected int defence;
    protected int maxHealth;
    protected int health;
    protected int maxDamage;
    protected int minDamage;
    public boolean isDead = false;

    protected Entity (int maxHealth, int attack, int defence, int minDamage, int maxDamage) {
        try {
            if (maxHealth > 0) {
                this.maxHealth = maxHealth;
            } else {
                throw new Exception("Wrong max health input");
            }
            if ((minDamage > 0) && (maxDamage > minDamage)) {
                this.minDamage = minDamage;
                this.maxDamage = maxDamage;
            } else {
                throw new Exception("Wrong damage range input");
            }
            this.setAttack(attack);
            this.setDefence(defence);
            this.setHealth(maxHealth);   
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
    }

    public void attack (Entity enemy) {
        int attack_mod = (this.attack - enemy.getDefence()) + 1;
        for (int i = 0; i < attack_mod;i++){
            int dice = (int) (Math.random() * 6 + 1);
            if (dice >= 5) {
                int damage = this.getDamage();
                enemy.takeDamage(damage);
                System.out.println("Attack was successful. Damage: " + damage);
                break;
            } else {
                System.out.println("Missed");
            }
        }
    }

    public int getDamage(){
        return (int) (Math.random() * this.maxDamage + this.minDamage);
    }

    public void takeDamage(int damage){
        this.setHealth(this.getHealth() - damage);
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            this.health = 0;
            this.death();
        } else {
            if ((health <= this.maxHealth) && (health > 0)){
                this.health = health;
            } else {
                System.out.println("Wrong health input");
            }
        }
    }

    private void death(){
        if (!this.isDead){
            this.isDead = true;
            System.out.println("Я умер");
        }
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack) {
        if (attack <= 30 && attack > 0){
            this.attack = attack;
        } else {
            System.out.println("Wrong attack input");
        }
    }

    public int getDefence() {
        return this.attack;
    }

    public void setDefence(int defence) {
        if (defence <= 30 && defence > 0){
            this.defence = defence;
        } else {
            System.out.println("Wrong defence input");
        }
    }
}
