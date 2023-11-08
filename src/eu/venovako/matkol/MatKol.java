// MatKol by <venovako@venovako.eu>

package eu.venovako.matkol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

final class MatKol {

    private static String readln(BufferedReader br) {
        String ln = null;
        try {
            ln = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ln;
    }

    public static void main(String[] args) {
        final BufferedReader ulaz =
            new BufferedReader(new InputStreamReader(System.in));
        String ln = readln(ulaz);
        if (ln == null)
            System.err.println("Prazan ulaz!");
        else {
            Kolokvij.kolokvij = new Kolokvij(ln);
            while ((ln = readln(ulaz)) != null) {
                final UlazLn ulazLn = new UlazLn(ln, Kolokvij.kolokvij);
                final IzlazLn izlazLn = new IzlazLn(ulazLn);
                System.out.println(izlazLn.toString());
            }
        }
    }

}
