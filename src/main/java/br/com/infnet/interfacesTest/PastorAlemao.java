package br.com.infnet.interfacesTest;

public class PastorAlemao implements Cachorro{
    @Override
    public void latir() {
        System.out.println("Latindo como um pastor");
    }

    @Override
    public void correr() {
        System.out.println("Correndo como um pastor");

    }

    @Override
    public void fazerXixi() {

    }
}
