// MatKol by <venovako@fsb.hr>

package hr.fsb.venovako.matkol;

import java.util.Scanner;

class UlazLn {

    final String prezime;
    final String ime;
    final int[] bodovi;
    final int suma;

    UlazLn(String ulazLn, Kolokvij kol) {
        if (!Utils.isNonEmptyString(ulazLn))
            throw new IllegalArgumentException();
        if (kol == null)
            throw new IllegalArgumentException();
        final Scanner s = new Scanner(ulazLn);
        if (!s.hasNext())
            throw new IllegalArgumentException();
        if (!Utils.isAlpha(prezime = s.next()))
            throw new IllegalArgumentException();
        if (!s.hasNext())
            throw new IllegalArgumentException();
        if (!Utils.isAlpha(ime = s.next()))
            throw new IllegalArgumentException();
        if (!s.hasNext())
            throw new IllegalArgumentException();
        bodovi = new int[kol.zadaci];
        int zbroj = 0;
        for (int i = 0; i < kol.zadaci; ++i) {
            if (!s.hasNextInt())
                throw new IllegalArgumentException();
            zbroj += (bodovi[i] = s.nextInt());
            if ((bodovi[i] < 0) || (bodovi[i] > kol.bodovi[i]))
                throw new IllegalArgumentException();
        }
        suma = zbroj;
    }

}
