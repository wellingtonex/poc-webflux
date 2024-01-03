package br.com.webflux.poc.webfluxnoblocking;

public record Person(Integer id, String name) {


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
