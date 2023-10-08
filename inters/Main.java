package inters;

public class Main {
    public static void main(String args[])
    {
        Hero hero = new Hero(100, 40, 30, 10, 60);
        Monster monster = new Monster(100, 40, 20, 10, 30);

        System.out.println("Hero health: " + hero.getHealth());
        System.out.println("Monster health: " + monster.getHealth());
        int turns = 100;

        // Пример взаимодействия
        for (int i = 0; i < turns; i++){
            System.out.println("Hero attacks monster:");
            hero.attack(monster);
            if (monster.isDead){
                System.out.println("Monster is dead, you win!");
                break;
            }

            System.out.println("Monster health: " + monster.getHealth());
            
            System.out.println("Monster attacks hero:");
            monster.attack(hero);
            System.out.println("Hero health: " + hero.getHealth());
            if (hero.isDead){
                System.out.println("You are dead, you loose!");
                break;
            }
            if (hero.getHealth() < 70) {
                System.out.println("Hero heals");
                hero.heal();
                System.out.println("Hero health: " + hero.getHealth());
            }
        }
    }
}
