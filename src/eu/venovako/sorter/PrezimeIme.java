package eu.venovako.sorter;

class PrezimeIme implements Comparable<PrezimeIme> {

    final String prezime;
    final String ime;

    PrezimeIme() {
        this(null, null);
    }

    PrezimeIme(String prezime, String ime) {
        this.prezime = (prezime == null) ? "" : prezime;
        this.ime = (ime == null) ? "" : ime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(
                this.prezime.length() + this.ime.length() + 1);
        sb.append(this.prezime);
        sb.append(' ');
        sb.append(this.ime);
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return this.prezime.hashCode() ^ this.ime.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final PrezimeIme other = (PrezimeIme) obj;
        if (this.prezime != other.prezime && (this.prezime == null || !this.prezime.equals(other.prezime)))
            return false;
        if (this.ime != other.ime && (this.ime == null || !this.ime.equals(other.ime)))
            return false;
        return true;
    }

    static String stupify(String s) {
        return (s == null) ? null :
            s.toUpperCase().replace("LJ", "\u01C7").replace("NJ", "\u01CA");
    }

    static int abeceda(char c) {
        switch (c) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case '\u010C': return 3;
            case '\u0106': return 4;
            case 'D': return 5;
            case '\u0110': return 6;
            case 'E': return 7;
            case 'F': return 8;
            case 'G': return 9;
            case 'H': return 10;
            case 'I': return 11;
            case 'J': return 12;
            case 'K': return 13;
            case 'L': return 14;
            case '\u01C7': return 15;
            case 'M': return 16;
            case 'N': return 17;
            case '\u01CA': return 18;
            case 'O': return 19;
            case 'P': return 20;
            case 'Q': return 21;
            case 'R': return 22;
            case 'S': return 23;
            case '\u0160': return 24;
            case 'T': return 25;
            case 'U': return 26;
            case 'V': return 27;
            case 'W': return 28;
            case 'X': return 29;
            case 'Y': return 30;
            case 'Z': return 31;
            case '\u017D': return 32;
            default: return -1;
        }
    }

    static int chrcmp(char a, char b) {
        final int aa = abeceda(a);
        final int ab = abeceda(b);
        if (aa == -1)
            return (ab == -1) ? (a - b) : 1;
        if (ab == -1)
            return -1;
        return aa - ab;
    }

    static int strcmp(String a, String b) {
        if (a == null)
            return (b == null) ? 0 : 1;
        if (b == null)
            return -1;
        if (a.isEmpty())
            return b.isEmpty() ? 0 : -1;
        if (b.isEmpty())
            return 1;
        a = stupify(a);
        b = stupify(b);
        final int la = a.length();
        final int lb = b.length();
        final int lm = (la <= lb) ? la : lb;
        for (int i = 0; i < lm; ++i) {
            final int c = chrcmp(a.charAt(i), b.charAt(i));
            if (c != 0)
                return c;
        }
        return la - lb;
    }

    public int compareTo(PrezimeIme o) {
        if (this == o)
            return 0;
        if (o == null)
            return 1;
        final int c = strcmp(this.prezime, o.prezime);
        return (c == 0) ? strcmp(this.ime, o.ime) : c;
    }

}
