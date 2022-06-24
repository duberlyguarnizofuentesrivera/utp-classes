package week_thirtheen;

import java.util.HashMap;
import java.util.Map.Entry;


public class HashMapStudent {
    static final String SEPARATOR = "-------------------------------------------";
    HashMap<String, Double> students = new HashMap<>();

    public static void main(String[] args) {
        HashMapStudent hashMapStudent = new HashMapStudent();
        hashMapStudent.fillHashMap();
        hashMapStudent.showName();
        hashMapStudent.showApproved();
        hashMapStudent.studentIsApproved("manuel lopez");

    }

    void showName() {
        System.out.println("\n   LISTADO DE ESTUDIANTES");
        System.out.println(SEPARATOR);
        for (Entry<String, Double> student : students.entrySet()) {
            System.out.println("- " + student.getKey());
        }

    }

    void showApproved() {
        System.out.println("\n   LISTADO DE ESTUDIANTES APROBADOS");
        System.out.println(SEPARATOR);
        for (Entry<String, Double> student : students.entrySet()) {
            int keyLen = student.getKey().length();
            String spaces = new String(new char[18 - keyLen]).replace("\0", " ");
            if (student.getValue() >= 11) {
                System.out.println("Alumno: " + student.getKey() + spaces + "Nota: " + student.getValue());
            }
        }
    }

    void studentIsApproved(String name) {
        System.out.println("\n   CONSULTA DE APROBADOS POR NOMBRE");
        System.out.println(SEPARATOR);
        for (Entry<String, Double> student : students.entrySet()) {
            if (student.getKey().equalsIgnoreCase(name)) {
                if (student.getValue() >= 11) {
                    System.out.println("El alumno " + student.getKey() + " está aprobado (Promedio: " + student.getValue() + ")");
                } else {
                    System.out.println("El alumno " + student.getKey() + " NO está aprobado (Promedio: " + student.getValue() + ")");
                }
            }
        }
    }

    void fillHashMap() {
        students.put("Juan Perez", 14.0);
        students.put("Ollanta Humana", 10.0);
        students.put("Maria García", 18.0);
        students.put("Pepe Mujíca", 12.0);
        students.put("Pedro Castillo", 6.1);
        students.put("Manuel Lopez", 14.3);
        students.put("Christina Kirchner", 7.5);
        students.put("Evo Morales", 10.2);
        students.put("John Biden", 10.7);
        students.put("Il Kim", 14.0);
        students.put("Jean Lozano", 19.2);
    }

}
