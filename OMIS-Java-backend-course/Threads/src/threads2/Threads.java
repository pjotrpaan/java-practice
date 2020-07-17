package threads2;

public class Threads extends Thread {
    public static void main(String[] args) {
        Thread thread1 = new Threads(1);
        Thread thread2 = new Threads(2);
        Thread thread3 = new Threads(3);
        Thread thread4 = new Threads(4);
        Thread thread5 = new Threads(5);
    }

    int numberOfThread;

    Threads(int number) {
        this.numberOfThread = number;
        start();
    }

    public void run() {
        if (this.numberOfThread == 1) {
            functionSmallCyrillicLettersUp();
        }
        if (this.numberOfThread == 2) {
            functionSmallLatinLettersDown();
        }
        if (this.numberOfThread == 3) {
            functionCountUp();
        }
//        if (this.numberOfThread == 4) {
//            functionCountDown();
//        }
//        if (this.numberOfThread == 5) {
//            functionSpacerElement();
//        }
    }
    private void functionCountUp() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void functionCountDown() {
        for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private void functionSmallCyrillicLettersUp() {
        int a = 1072;
        for (int i = 0; i < 32; i++) {
            String charact = Character.toString((char)a);
            System.out.println(charact);
            a++;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void functionSmallLatinLettersDown() {
        int z = 122;

        for (int i = 0; i < 26; i++) {
            String charact = Character.toString((char)z);
            System.out.println(charact);
            z--;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void functionSpacerElement() {
        int sym = 42;
        try {
            Thread.sleep(2000);
            for (int i = 0; i < 4; i++) {
                String charact = Character.toString((char)sym);
                System.out.println(charact + charact + charact);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}


