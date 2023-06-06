package br.com.infnet.methodRef;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Runner {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);
        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);

        usuarios.forEach(u -> u.tornaModerador());


        Consumer<Usuario> tornaModerador = Usuario::tornaModerador;
        usuarios.forEach(tornaModerador);
        usuarios.forEach(Usuario::tornaModerador);
        /*
        Usuario::getNome ----> u -> u.getNome()
         */
        usuarios.sort(Comparator.comparing(Usuario::getNome));
        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        Comparator<Usuario> comparatorComposto = Comparator
                .comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome);
        usuarios.sort(comparatorComposto);
        usuarios.sort(Comparator
                .comparingInt(Usuario::getPontos)
                .thenComparing(Usuario::getNome));


    }
}
