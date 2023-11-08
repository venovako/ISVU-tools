// MatKol <venovako@venovako.eu>

package eu.venovako.matkol;

import java.util.Scanner;

class Kolokvij {

    final int zadaci;
    final int[] bodovi;

    Kolokvij(String kolLn) {
        if (!Utils.isNonEmptyString(kolLn))
            throw new IllegalArgumentException();
        final Scanner s = new Scanner(kolLn);
        if (!s.hasNextInt())
            throw new IllegalArgumentException();
        if ((zadaci = s.nextInt()) < 0)
            throw new IllegalArgumentException();
        bodovi = new int[zadaci];
        for (int i = 0; i < zadaci; ++i) {
            if (!s.hasNextInt())
                throw new IllegalArgumentException();
            if ((bodovi[i] = s.nextInt()) < 0)
                throw new IllegalArgumentException();
        }
    }

    static Kolokvij kolokvij;

}
