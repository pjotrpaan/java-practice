package com.company;

import com.company.character.*;
import com.company.item.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static int counter = 0;
    static List<Item> playerWeapons;

    public static void main(String[] args) throws InterruptedException {
        World world = new World(10, 5);

// TODO: timer
        Enemy enemy = new Enemy("Enemy", CharacterType.WIZARD);
        Friend friend = new Friend("Friend", CharacterType.HERO);
        Player player = new Player("Mihkel", CharacterType.WARRIOR);
        Healer healer = new Healer();
        player.getInventory().addItem(new Hammer());
        player.getInventory().addItem(new Sword());
        player.getInventory().addItem(new Teleporter());
        player.getInventory().showInventory();
        // Player always last as it overwrites on the map
        world.setCharacters(Arrays.asList(enemy, friend, healer, player));
        world.setItems(Arrays.asList(new Hammer(), new Sword(), new Boot(), new Teleporter()));
        movePlayer(world, enemy, friend, player, healer);
    }

    private static void movePlayer(World world, Enemy enemy, Friend friend, Player player, Healer healer) throws InterruptedException {
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
            meetCharacter(world, enemy, friend, player, healer);
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
            System.out.println("Ravitseja ravis sind! Su elud on nüüd täis!");
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
            System.out.println("Kohtusid vaenlasega! Kas soovid temaga võidelda? Y/N: ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("y")) {
                startBattle(player, enemy);
            } else {
                System.out.println("Põgenesid vaenlase eest!");
                System.out.println("Liigu edasi: ");
            }
        } else if (Player.getHealth() <= 0) {
            System.out.println("Sul on elud otsas! Otsi üles ravitseja et end ravida");
        } else if (playerWeapons.size() <= 0) {
            System.out.println("Sul on relvad otsas! Püüa neid mänguväljakult");
        }

    }

    private static void startBattle(Player player, Enemy enemy) throws InterruptedException {
        System.out.println("Algas lahing");
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Sul on järgmine valik relvi: ");
        TimeUnit.MILLISECONDS.sleep(100);
        player.getInventory().showInventory();
        System.out.println("Vali number millist relva kasutad: ");
        Item chosenWeapon = getFightWeapon();
        TimeUnit.MILLISECONDS.sleep(100);
        if (chosenWeapon.getClass().getName().equals("com.company.item.Teleporter")) {
            useTeleporter(player, enemy, chosenWeapon);
            return;
        } else {
            System.out.println("Hakkasid võitlema!!");
            while (Player.getHealth()>0 || Enemy.getHealth()>0) {
                if (Player.getHealth() <= 0) {
                    System.out.println("Said surma!");
                    break;
                }
                if (Enemy.getHealth() <= 0) {
                    TimeUnit.MILLISECONDS.sleep(100);
                    counter++;
                    System.out.println("Vaenlane käes!! Oled püüdnud vaenlasi: " + counter);
                    break;
                }
                fightEnemy(chosenWeapon, player, enemy);
            }
        }
        Enemy.reboost();
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Liigu edasi: ");
    }

    private static void useTeleporter(Player player, Enemy enemy, Item chosenWeapon) {
        ((Teleporter) (chosenWeapon)).teleport();
        player.randomiseCoordinates(1, World.getWidth()-1, World.getHeight()-1);
        enemy.setVisible(true);
        System.out.println(player.getHealth());
        System.out.println(enemy.getHealth());
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
                System.out.println("Sisestasid numbri asemel tähe! Sisesta uuesti!");
                input = scanner.nextLine();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Sellise numbriga relva ei ole! Sisesta uuesti!");
                input = scanner.nextLine();
            }
        }
        System.out.println("Valisid relva: " + chosenWeapon.getName());
        return chosenWeapon;
    }

    private static void fightEnemy(Item chosenWeapon, Player player, Enemy enemy) {
        System.out.println(player.getHealth());
        System.out.println(enemy.getHealth());
        String input;
        System.out.println("Ütle number millega võitled vahemikus 1-3");
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
            System.out.println("Ei saanud pihta! Vaenlane võttis sult elu");
            Player.takeHealth();
        }
    }

    private static int enemyFightRandomNumber() {
        return (int) ((Math.random() * ((4 - 1) + 1)) + 1);
    }
}
