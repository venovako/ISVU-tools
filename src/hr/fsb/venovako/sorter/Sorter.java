package hr.fsb.venovako.sorter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.TreeSet;

class Sorter {

    static final Charset UTF_8 = Charset.forName("UTF-8");
    static BufferedReader in;
    static BufferedWriter out;

    public static void main(String[] args) {
        if (args.length != 2)
            System.err.println("Sorter.jar IN OUT");
        else try {
            in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), UTF_8));
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), UTF_8));
            final TreeSet<PrezimeIme> stud = new TreeSet<PrezimeIme>();
            for (String s; (s = in.readLine()) != null; ) {
                final String[] pi = s.trim().split("\\t");
                stud.add(new PrezimeIme(pi[0], pi[1]));
            }
            for (PrezimeIme pi : stud) {
                out.write(pi.prezime);
                out.write(' ');
                out.write(pi.ime);
                out.newLine();
            }
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
