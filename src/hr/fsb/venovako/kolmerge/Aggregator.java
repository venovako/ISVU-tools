package hr.fsb.venovako.kolmerge;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

class Aggregator {
    
    static Kolokvij aggregate(Collection<? extends Kolokvij> kolokviji) {
        if (kolokviji == null)
            return null;
        final TreeMap<PrezimeIme, Vector<Integer>> bodovi =
                new TreeMap<PrezimeIme, Vector<Integer>>();
        for (Kolokvij kolokvij : kolokviji) {
            if (kolokvij == null)
                continue;
            for (Student student : kolokvij.studenti) {
                if ((student == null) || bodovi.containsKey(student.prezimeIme))
                    continue;
                bodovi.put(student.prezimeIme, new Vector<Integer>());
            }
        }
        int totKolone = 0;
        final Vector<Student> studenti = new Vector<Student>(bodovi.size());
        final Set<Entry<PrezimeIme, Vector<Integer>>> all = bodovi.entrySet();
        for (Entry<PrezimeIme, Vector<Integer>> one : all) {
            for (Kolokvij kolokvij : kolokviji) {
                final int kolone = kolokvij.kolone;
                totKolone += kolone;
                final Vector<Student> studs = kolokvij.studenti;
                int[] bods = null;
                for (Student stud : studs) {
                    if (one.getKey().equals(stud.prezimeIme)) {
                        bods = stud.bodovi;
                        break;
                    }
                }
                final Vector<Integer> agg = one.getValue();
                if (bods == null)
                    for (int i = 0; i < kolone; ++i)
                        agg.add(0);
                else
                    for (int i = 0; i < kolone; ++i)
                        agg.add(bods[i]);
            }
            studenti.add(new Student(one.getKey(), one.getValue()));
        }
        return new Kolokvij(totKolone, studenti);
    }

}
