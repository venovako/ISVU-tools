// MatKol by <venovako@fsb.hr>

package hr.fsb.venovako.matkol;

class IzlazLn {

    final String prezime;
    final String ime;
    final int suma;

    IzlazLn(UlazLn ulazLn) {
        if (ulazLn == null)
            throw new IllegalArgumentException();
        prezime = ulazLn.prezime;
        ime = ulazLn.ime;
        suma = ulazLn.suma;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(prezime);
        sb.append(' ');
        sb.append(ime);
        sb.append(", ");
        sb.append(suma);
        return sb.toString();
    }

}
