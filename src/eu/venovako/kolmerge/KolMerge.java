package eu.venovako.kolmerge;

import java.util.Vector;

class KolMerge {

    public static void main(String[] args) {
        final int len = args.length;
        if ((len < 2) || (len % 2 == 1)) {
            System.err.println("KolMerge.jar (Rezultati BrojKolona)+");
            return;
        }
        final Vector<Kolokvij> kolokviji = new Vector<Kolokvij>(len);
        try {
            for (int i = 0; i < args.length; i += 2)
                kolokviji.add(new Kolokvij(args[i], Integer.parseInt(args[i + 1])));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aggregator.aggregate(kolokviji).print();
    }

}
