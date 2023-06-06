package br.com.infnet.predicate;

import br.com.infnet.model.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Runner {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(leonardo);
        usuarios.add(pedro);
        usuarios.add(jose);

        Predicate<Usuario> maiorQue500 = new Predicate<Usuario>() {
            @Override
            public boolean test(Usuario usuario) {
                return usuario.getPontos() > 500;
            }
        };
        usuarios.removeIf(maiorQue500);
        usuarios.removeIf(u -> u.getPontos() > 500);

    }
}
