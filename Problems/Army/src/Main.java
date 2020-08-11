class Army {

    public static void createArmy() {
        Unit unit1 = new Unit("Bob");
        Unit unit2 = new Unit("Sam");
        Unit unit3 = new Unit("Tom");
        Unit unit4 = new Unit("Tim");
        Unit uint5 = new Unit("Rob");

        Knight knight1 = new Knight("Galahad");
        Knight knight2 = new Knight("Jaime");
        Knight knight3 = new Knight("Brynn");

        General general1 = new General("Patton");

        Doctor doctor1 = new Doctor("Bones");
    }


    // Don't change the code below
    static class Unit {
        static String nameUnit;
        static int countUnit;

        public Unit(String name) {
            countUnit++;
            nameUnit = name;

        }
    }

    static class Knight {
        static String nameKnight;
        static int countKnight;

        public Knight(String name) {
            countKnight++;
            nameKnight = name;

        }
    }

    static class General {
        static String nameGeneral;
        static int countGeneral;

        public General(String name) {
            countGeneral++;
            nameGeneral = name;

        }
    }

    static class Doctor {
        static String nameDoctor;
        static int countDoctor;

        public Doctor(String name) {
            countDoctor++;
            nameDoctor = name;

        }
    }

    public static void main(String[] args) {
        createArmy();
        System.out.println(Unit.countUnit);
        System.out.println(Knight.countKnight);
        System.out.println(General.countGeneral);
        System.out.println(Doctor.countDoctor);
    }

}