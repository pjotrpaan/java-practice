package com.company;

import com.company.character.*;
import com.company.item.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static int counter = 0;
    static List<Item> playerWeapons;

    public static void main(String[] args) throws InterruptedException {
        World world = new World(25, 10);

        Enemy enemy = new Enemy("Enemy", CharacterType.WIZARD);
        Friend friend = new Friend("Friend", CharacterType.HERO);
        Player player = new Player("Mihkel", CharacterType.WARRIOR);
        Healer healer = new Healer();
        Hammer hammer = new Hammer();
        Boot boot = new Boot();
        Sword sword = new Sword();
        Teleporter teleporter = new Teleporter();

        startTimer(timer, enemy);

        player.getInventory().addItem(new Hammer());
        player.getInventory().addItem(new Sword());
        player.getInventory().addItem(new Teleporter());
        player.getInventory().showInventory();
        // Player always last as it overwrites on the map
        world.setCharacters(Arrays.asList(enemy, friend, healer, player));
        world.setItems(Arrays.asList(hammer, sword, boot, teleporter));
        interactWithWorld(world, enemy, friend, player, healer, hammer, boot, sword, teleporter);
    }

    private static void startTimer(Timer timer, Enemy enemy) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(setInterval(enemy));
            }
        }, 1000, 1000);
    }

    static int interval = 0;
    static Timer timer = new Timer();

    private static int setInterval(Enemy enemy) {
        if (!enemy.isVisible()) {
            interval = 0;
        }
        return interval++;
    }

    private static void interactWithWorld(
            World world,
            Enemy enemy,
            Friend friend,
            Player player,
            Healer healer,
            Hammer hammer,
            Boot boot,
            Sword sword,
            Teleporter teleporter) throws InterruptedException
    {
        String input = "";
        world.render();
        while(!input.equals("end")){
            input = scanner.nextLine();
            switch (input) {
                case "w":
                    Direction playerDirection = Direction.UP;
                    player.changeDirection(playerDirection);
                    player.move();
                    break;
                case "s":
                    player.changeDirection(Direction.DOWN);
                    player.move();
                    break;
                case "a":
                    player.changeDirection(Direction.LEFT);
                    player.move();
                    break;
                case "d":
                    player.changeDirection(Direction.RIGHT);
                    player.move();
                    break;
                case "":
                    player.move();
                    break;
            }
            findItem(player, hammer, sword, boot, teleporter);
            meetCharacter(world, enemy, friend, player, healer);
        }
    }

    private static void findItem(Player player, Hammer hammer, Sword sword, Boot boot, Teleporter teleporter) {
        if (player.getxCoord() == hammer.getxCoord() && player.getyCoord() == hammer.getyCoord()) {
            player.getInventory().addItem(hammer);
        }
        if (player.getxCoord() == sword.getxCoord() && player.getyCoord() == sword.getyCoord()) {
            player.getInventory().addItem(sword);
        }
        if (player.getxCoord() == boot.getxCoord() && player.getyCoord() == boot.getyCoord()) {
            player.getInventory().addItem(boot);
        }
        if (player.getxCoord() == teleporter.getxCoord() && player.getyCoord() == teleporter.getyCoord()) {
            player.getInventory().addItem(teleporter);
        }
    }

    private static void meetCharacter(World world, Enemy enemy, Friend friend, Player player, Healer healer) throws InterruptedException {
        boolean enemyCatched = false;
        if (player.getxCoord() == enemy.getxCoord() && player.getyCoord() == enemy.getyCoord()) {
            enemy.setVisible(false);
            enemyCatched = true;
        }
        if (player.getxCoord() == friend.getxCoord() && player.getyCoord() == friend.getyCoord()) {
            enemy.setVisible(true);
            enemy.randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
        }
        if (player.getxCoord() == healer.getxCoord() && player.getyCoord() == healer.getyCoord()) {
            System.out.println("Healer fixed you up! Your lives are full!");
            Player.setFullHealth();
            healer.randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
        }

//        if (player.getxCoord() ==  && player.getyCoord() == ) {
//            System.out.println("Ravitseja ravis sind! Su elud on nüüd täis!");
//            Player.setFullHealth();
//            healer.randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
//        }
        world.render();
        if(enemyCatched){
            enemySeen(player, enemy);
        }
    }

    private static void enemySeen(Player player, Enemy enemy) throws InterruptedException {
        playerWeapons = player.getInventory().getInventory();
        if(Player.getHealth() > 0 && playerWeapons.size() > 0) {
            System.out.println("You bumped into an enemy! Do you wish to fight? Y/N: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                startBattle(player, enemy);
            } else {
                System.out.println("Your fleeing from the enemy!");
                System.out.println("Move forward.");
            }
        } else if (Player.getHealth() <= 0) {
            System.out.println("Out of lives! Find a healer from the playing field.");
        } else if (playerWeapons.size() <= 0) {
            System.out.println("You're out of weapons! Catch them from the playing field.");
        }

    }

    private static void startBattle(Player player, Enemy enemy) throws InterruptedException {
        System.out.println("Prepare for battle!");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Choose a weapon");
        TimeUnit.MILLISECONDS.sleep(100);
        player.getInventory().showInventory();
        System.out.println("What weapon will you be using?");
        Item chosenWeapon = getFightWeapon();
        TimeUnit.MILLISECONDS.sleep(100);
        if (chosenWeapon.getClass().getName().equals("com.company.item.Teleporter")) {
            useTeleporter(player, enemy, chosenWeapon);
            return;
        } else {
            System.out.println("Fight has begun!");
            while (Player.getHealth()>0 || Enemy.getHealth()>0) {
                if (Player.getHealth() <= 0) {
                    System.out.println("You died!");
                    break;
                }
                if (Enemy.getHealth() <= 0) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    counter++;
                    System.out.println("Enemy caught! Your caught and killed count: " + counter);
                    break;
                }
                fightEnemy(chosenWeapon, player, enemy);
            }
        }
        Enemy.reboost();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Press Enter to move forward.");
    }

    private static void useTeleporter(Player player, Enemy enemy, Item chosenWeapon) {
        ((Teleporter) (chosenWeapon)).teleport();
        player.randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
        double newPlayerHealth = player.getHealth() - chosenWeapon.getStrength();
        player.setHealth(newPlayerHealth);
        enemy.setVisible(true);
        System.out.println("Player health: "+player.getHealth());
        System.out.println("Enemy health: "+enemy.getHealth());
        return;
    }

    private static Item getFightWeapon() {
        String input;
        input = scanner.nextLine();
        Item chosenWeapon = null;
        while(chosenWeapon == null){
            try {
                chosenWeapon = playerWeapons.get(Integer.parseInt(input)-1);
                Item finalChosenWeapon = chosenWeapon;
                playerWeapons.stream()
                        .filter(e -> e == finalChosenWeapon)
//                        .peek(System.out::println)
                        .findFirst()
                        .ifPresent(e -> e.setEndurance(e.getEndurance()-1));
            } catch (NumberFormatException e) {
                System.out.println("You entered a character. A number is needed to choose!");
                input = scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Entered number weapon does not exist. Please enter an existing weapon number!");
                input = scanner.nextLine();
            }
        }
        System.out.println("Weapon chosen: " + chosenWeapon.getName());
        return chosenWeapon;
    }

    private static void fightEnemy(Item chosenWeapon, Player player, Enemy enemy) {
        System.out.println("Player health: "+player.getHealth());
        System.out.println("Enemy health: "+enemy.getHealth());
        String input;
        System.out.println("Choose a random number between 1-4.");
        input = scanner.nextLine();
        String enemyNumber = String.valueOf(enemyFightRandomNumber());
        if(input.equals(String.valueOf(enemyFightRandomNumber()))){
            switch (chosenWeapon.getClass().getName()) {
                case "com.company.item.Sword":
                    ((Sword) (chosenWeapon)).hit();
                    break;
                case "com.company.item.Hammer":
                    ((Hammer) (chosenWeapon)).hit();
                    break;
                case "com.company.item.Boot":
                    ((Boot) (chosenWeapon)).hit();
                    break;
            }
        } else {
            System.out.println("Missed hit! Enemy caught you off-guard and you lost a life!");
            Player.takeHealth();
        }
    }

    private static int enemyFightRandomNumber() {
        return (int) ((Math.random() * ((4 - 1) + 1)) + 1);
    }
}
