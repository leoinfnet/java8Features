package br.com.infnet.comparator;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;


public class OrdenandoListaJeitoNovo {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);

        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);
        usuarios.sort((u1, u2) ->
                String.CASE_INSENSITIVE_ORDER.compare(u1.getNome(),u2.getNome()));
        Comparator<Usuario> comparator = Comparator.comparing(u -> u.getNome());
        usuarios.sort(comparator);
        usuarios.sort(comparing(u -> u.getNome()));

        List<String> palavras = Arrays.asList("Luke Skywalker", "Han Solo", "Darh Vader");
        Collections.sort(palavras);
        palavras.sort(Comparator.naturalOrder());
        palavras.sort(naturalOrder());
        palavras.sort(reverseOrder());







    }
}
