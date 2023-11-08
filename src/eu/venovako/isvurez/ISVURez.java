package eu.venovako.isvurez;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

class ISVURez {

    static final Charset UTF_8 = Charset.forName("UTF-8");
    static BufferedReader in;
    static BufferedWriter out;

    static String sifPred;
    static String akGodina;
    static String oznVrOslob;
    static String datumAktiviranja;
    static String datumDeaktiviranja;

    public static void main(String[] args) {
        if ((args.length < 6) || (args.length > 7))
            System.err.println("ISVURez.jar IN OUT sifPred akGodina oznVrOslob datumAktiviranja [ datumDeaktiviranja ]");
        else {
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), UTF_8));
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), UTF_8));

                sifPred = "\t\t<sifPred>" + args[2] + "</sifPred>";
                akGodina = "\t\t<akGodina>" + args[3] + "</akGodina>";
                oznVrOslob = "\t\t<oznVrOslob>" + args[4] + "</oznVrOslob>";
                datumAktiviranja = "\t\t<datumAktiviranja>" + args[5] + "</datumAktiviranja>";
                datumDeaktiviranja = "\t\t<datumDeaktiviranja>" + ((args.length == 7) ? args[6] : "") + "</datumDeaktiviranja>";
            
                out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"); out.newLine();
                out.write("<!DOCTYPE podatci SYSTEM \"https://www.isvu.hr/dtds/oslobDioIspit.dtd\">"); out.newLine();
                out.write("<podatci>"); out.newLine();
                
                for (String ln; (ln = in.readLine()) != null; ) {
                    final String[] toks = ln.trim().split("\\t");
                    if (toks.length < 2)
                        throw new RuntimeException("Invalid input line: " + ln);
                    final String JMBAG = "\t\t<JMBAG>" + toks[0] + "</JMBAG>";
                    final String kratOcjenaZaVU = "\t\t<kratOcjenaZaVU>" + toks[1] + "</kratOcjenaZaVU>";
                    out.write("\t<oslobDioIspit>"); out.newLine();
                    out.write(sifPred); out.newLine();
                    out.write(JMBAG); out.newLine();
                    out.write(akGodina); out.newLine();
                    out.write(oznVrOslob); out.newLine();
                    out.write(kratOcjenaZaVU); out.newLine();
                    out.write(datumAktiviranja); out.newLine();
                    out.write(datumDeaktiviranja); out.newLine();
                    out.write("\t</oslobDioIspit>"); out.newLine();
                }
                
                out.write("</podatci>"); out.newLine();
                
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
