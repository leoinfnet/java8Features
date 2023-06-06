package br.com.infnet.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Runner {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 260);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);

        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);
        //Teste
        ArrayList<Usuario> usuarios1 = new ArrayList<>();
        usuarios1.add(leonardo);
        usuarios1.add(pedro);
        usuarios1.add(jose);

        for(Usuario user: usuarios){
            System.out.println(user);
        }
        System.out.println("====================");
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);
        System.out.println("====================");

        Consumer<Usuario> consumer = new Consumer<>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome() + " :  " + usuario.getPontos());
            }
        };
        usuarios.forEach(consumer);
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome() + " :  " + usuario.getPontos());
            }
        });
        Consumer<Usuario> consumerLambda = (Usuario u) -> {System.out.println(u.getNome());};
        Consumer<Usuario> consumerLambda2 = u -> {System.out.println(u.getNome());};
        Consumer<Usuario> consumerLambda3 = u -> System.out.println(u.getNome());

        usuarios.forEach(consumerLambda3);
        usuarios.forEach(u -> System.out.println(u.getNome()));
        /*
        for(Usuario user : usuarios){
            user.tornaModerador();
        }

         */
        usuarios.forEach(usuario -> usuario.tornaModerador());
/*
        default void forEach(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            for (T t : this) {
                action.accept(t);
            }
        }

  */

    // Integer numero = 3
        //String nome = "leonardo"
        // var func = () => {print("Teste"}
        // imprime(func)

    }
}
