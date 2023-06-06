package br.com.infnet.funcionalInt;

import br.com.infnet.model.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethodsTest {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);

        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose);
        Consumer<Usuario> imprimeBarra = usuario -> System.out.println("=============");
        Consumer<Usuario> imprimeNome = usuario -> System.out.println(usuario.getNome());
        usuarios.forEach(imprimeBarra.andThen(imprimeNome));

        usuarios.forEach(u -> {
                    System.out.println("========");
                    System.out.println(u.getNome());});

    }
}
