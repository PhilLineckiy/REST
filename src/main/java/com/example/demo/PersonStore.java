package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PersonStore {
    private Map<Integer,Person> personMap = new HashMap<Integer, Person>() {{
        put(2, new Person("Lilith", 5000, 2));
        put(3, new Person("Adam", 5000, 3));
        put(4, new Person("Eve", 5000, 4));
        put(5, new Person("Kain", 4950, 5));
        put(6, new Person("Abel", 4950, 6));
    }};

    private static PersonStore instance = new PersonStore();
    public static PersonStore getInstance(){
        return instance;
    }

    public Person getPerson(Integer id) {
        return personMap.get(id);
    }

    public void putPerson(int id, Person person) {
        personMap.put(person.getId(), person);
    }

    public void getAll() {
        Set<Integer> ids = personMap.keySet();
        Person[] p = new Person[ids.size()];
        int i=0;
        for(Integer id : ids){
            p[i] = personMap.get(id);
            i++;
            System.out.println(p[i]);
        }
    }


}
