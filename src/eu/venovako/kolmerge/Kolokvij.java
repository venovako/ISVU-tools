package eu.venovako.kolmerge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

class Kolokvij {

    final int kolone;
    final Vector<Student> studenti;

    Kolokvij(String fileName, int kolone) throws IOException {
        if (kolone < 0)
            throw new IllegalArgumentException(Integer.toString(kolone));
        this.kolone = kolone;
        final BufferedReader bis = new BufferedReader(new FileReader(fileName));
        this.studenti = new Vector<Student>();
        for (String inp; (inp = bis.readLine()) != null; studenti.add(new Student(inp, kolone)))
            if ((inp = inp.trim()).isEmpty())
                break;
        bis.close();
    }

    Kolokvij(int kolone, Vector<Student> studenti) {
        if (kolone < 0)
            throw new IllegalArgumentException(Integer.toString(kolone));
        this.kolone = kolone;
        this.studenti = (studenti == null) ? new Vector<Student>(0) : studenti;
    }

    void print() {
        for (Student student : studenti)
            System.out.println(student);
    }

}
