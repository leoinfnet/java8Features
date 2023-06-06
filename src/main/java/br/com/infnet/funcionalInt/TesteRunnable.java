package br.com.infnet.funcionalInt;

public class TesteRunnable {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 1000; i ++){
                    System.out.println(i);
                }
            }
        };
        new Thread(r).start();
        Runnable runableComLambda =  () -> {
            for(int i = 0 ; i < 1000; i ++){
            System.out.println(i);
        }};
        new Thread(runableComLambda).start();
        new Thread(() -> {
            for(int i = 0 ; i < 1000; i ++){
                System.out.println(i);
            }}).start();
    }
}
