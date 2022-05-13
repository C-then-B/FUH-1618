public class ArrayAddressBook {
    Person[] persons;
    int cnt;

    ArrayAddressBook(int pSize) {
        persons = new Person[pSize > 0 ? pSize : 1];
    }

    void addPerson(Person p) {
        if (persons.length == cnt)
            growArray();

        persons[cnt] = p;
        cnt++;
    }

    private void growArray() {
        persons = java.util.Arrays.copyOf(persons, persons.length * 2);
    }

    public void print() {
        System.out.println("Eintraege: " + cnt);
        System.out.println("Kapazitaet: " + persons.length);
        for (int i = 0; i < cnt; i++) {
            persons[i].print();
        }
    }
}