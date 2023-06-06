package br.com.infnet.comparator;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class ComparandoPorPontos {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);
        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);

        usuarios.sort(Comparator.comparing(usuario -> usuario.getPontos()));
        //Separando as coisas
        Function<Usuario, Integer> extraiPontos = usuario -> usuario.getPontos();
        Comparator<Usuario> comparator = Comparator.comparing(extraiPontos);
        usuarios.sort(comparator);


        ToIntFunction<Usuario> toIntFunction=  usuario -> usuario.getPontos();
        Comparator<Usuario> comparatorInt = Comparator.comparingInt(toIntFunction);
        usuarios.sort(comparatorInt);

        usuarios.sort(Comparator.comparingInt(usuario -> usuario.getPontos()));



    }
}
