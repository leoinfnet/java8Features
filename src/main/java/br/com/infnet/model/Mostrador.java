package br.com.infnet.model;

import java.util.function.Consumer;

public class Mostrador implements Consumer<Usuario> {
    @Override
    public void accept(Usuario usuario) {
        System.out.println(usuario.getNome());
        //usuario.tornaModerador();
    }
}
