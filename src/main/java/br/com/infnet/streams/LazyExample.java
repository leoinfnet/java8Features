package br.com.infnet.streams;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LazyExample {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);
        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);

        List<Usuario> list = usuarios.stream().filter(usuario -> usuario.getPontos() > 200).toList();

        Usuario usuario = list.get(0);

        Optional<Usuario> any = usuarios.stream().filter(u -> u.getPontos() > 200).findAny();



    }
}
