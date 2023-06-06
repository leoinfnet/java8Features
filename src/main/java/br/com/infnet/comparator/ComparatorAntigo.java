package br.com.infnet.comparator;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAntigo {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);

        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);
        Comparator<Usuario> comparator = new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNome().compareTo(u2.getNome());
            }
        };
        Comparator<Usuario> comparatorLambda = (u1, u2) -> {
            return u1.getNome().compareTo(u2.getNome());
        };
        Collections.sort(usuarios,comparator);
        Collections.sort(usuarios,comparatorLambda);
        Collections.sort(usuarios, (u1, u2) -> {
            return u1.getNome().compareTo(u2.getNome());
        });

    }
}
