package eu.venovako.kolmerge;

import java.util.Scanner;
import java.util.Vector;

class Student {

    final PrezimeIme prezimeIme;
    final int bodovi[];
    final int suma;

    Student(String inputLine, int kolone) {
        inputLine = inputLine.replace(',', ' ').trim();
        final Scanner sc = new Scanner(inputLine);
        final String prezime = sc.next();
        final String ime = sc.next();
        this.prezimeIme = new PrezimeIme(prezime, ime);
        this.bodovi = new int[kolone];
        int s = 0;
        for (int i = 0; (i < kolone) && sc.hasNextInt(); ++i)
            s += this.bodovi[i] = sc.nextInt();
        this.suma = s;
    }

    Student(PrezimeIme prezimeIme, Vector<Integer> bodovi) {
        this.prezimeIme = (prezimeIme == null) ? new PrezimeIme() : prezimeIme;
        this.bodovi = new int[(bodovi == null) ? 0 : bodovi.size()];
        int i = 0, s = 0;
        for (Integer bod : bodovi)
            s += this.bodovi[i++] = bod.intValue();
        this.suma = s;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.prezimeIme);
        for (int bod : this.bodovi) {
            sb.append(", ");
            sb.append(bod);
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return this.prezimeIme.hashCode() ^ this.bodovi.hashCode() ^ this.suma;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Student other = (Student) obj;
        if (this.prezimeIme != other.prezimeIme && (this.prezimeIme == null || !this.prezimeIme.equals(other.prezimeIme)))
            return false;
        if (this.bodovi != other.bodovi && (this.bodovi == null || !this.bodovi.equals(other.bodovi)))
            return false;
        if (this.suma != other.suma)
            return false;
        return true;
    }

}
