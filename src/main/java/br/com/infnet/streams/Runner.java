package br.com.infnet.streams;

import br.com.infnet.model.Usuario;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toSet;

public class Runner {
    public static void main(String[] args) {
        Usuario leonardo = new Usuario("Leonardo", 150);
        Usuario pedro = new Usuario("Pedro", 250);
        Usuario jose = new Usuario("Jose", 1000);
        Usuario joaquim = new Usuario("Joaquim", 1200);
        Usuario joao = new Usuario("Joao", 1100);
        List<Usuario> usuarios = Arrays.asList(leonardo, pedro, jose,joaquim,joao);
        List<Usuario> usuarios2 = Arrays.asList(leonardo, pedro, jose,joaquim,joao);
        List<Usuario> usuariosComStream = Arrays.asList(leonardo, pedro, jose,joaquim,joao);



        usuarios.sort(Comparator.comparingInt(Usuario::getPontos).reversed());
        usuarios.subList(0,2).forEach(Usuario::tornaModerador);
        usuarios.forEach(u-> System.out.println(u.getNome() + " : " + u.isModerador() ));

        Collections.sort(usuarios2, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario o1, Usuario o2) {
                return o1.getPontos() - o2.getPontos();
            }
        });
        Collections.reverse(usuarios2);
        List<Usuario> top2 = usuarios2.subList(0, 2);
        for(Usuario u: top2){
            u.tornaModerador();
        }
        //Tornando moderador quem tem 100 ou mais pontos
        for(Usuario u : usuarios){
            if(u.getPontos() >= 1000){
                u.tornaModerador();
            }
        }
        System.out.println("=====================");
        usuariosComStream.stream().filter(u -> u.getPontos() >= 1000);
        usuarios.forEach(System.out::println);

        System.out.println("=====================");
        Stream<Usuario> usuarioStream = usuariosComStream.stream().filter(u -> u.getPontos() >= 1000);
        usuarioStream.forEach(System.out::println);

        System.out.println("=====================");
        usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .forEach(Usuario::tornaModerador);
        System.out.println("=====================");
        usuariosComStream.stream().filter(Usuario::isModerador);

        System.out.println("=====================");
        ArrayList<Usuario> maisQue1000 = new ArrayList<>();
        usuariosComStream.stream()
                .filter(u -> u.getPontos() >= 1000)
                .forEach(maisQue1000::add);

        /*
         <R> R collect(Supplier<R> supplier,
                BiConsumer<R, ? super T> accumulator,
                BiConsumer<R, R> combiner);
  */


        Supplier<ArrayList<Usuario>> supplier = ArrayList::new;
        BiConsumer<ArrayList<Usuario>, Usuario> accumulator = ArrayList::add;
        BiConsumer<ArrayList<Usuario>, ArrayList<Usuario>> combiner=  ArrayList::addAll;

        ArrayList<Usuario> collect = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(supplier, accumulator, combiner);

        ArrayList<Object> collect1 = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        //<R, A> R collect(Collector<? super T, A, R> collector);

        List<Usuario> collect2 = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(Collectors.toList());


        Set<Usuario> collect3 = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(Collectors.toSet());

        Set<Usuario> collect4 = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(toSet());

        HashSet<Usuario> collect5 = usuariosComStream.stream()
                .filter(usuario -> usuario.getPontos() >= 1000)
                .collect(Collectors.toCollection(HashSet::new));


        ArrayList<Integer> pontos = new ArrayList<>();
        usuarios.forEach(u -> pontos.add(u.getPontos()));

        //Function<Usuario,Integer> function =  Usuario::getPontos


        List<Integer> list = usuarios.stream()
                .map(Usuario::getPontos)
                .toList();
        System.out.println("=====================");
        int sum = usuarios.stream().mapToInt(Usuario::getPontos).sum();
        System.out.println(sum);
        OptionalDouble average = usuarios.stream().mapToInt(Usuario::getPontos).average();
        System.out.println(average.getAsDouble());

        int reduce = usuarios.stream().mapToInt(Usuario::getPontos)
                .reduce(1, (a, b) -> a * b);
        System.out.println(reduce);


    }
}
