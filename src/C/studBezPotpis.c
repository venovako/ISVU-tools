/* Pravi XML za ISVU "zabrane" iz niza JMBAGova.
   STDIN: JMBAG*
   STDOUT: XML
*/
#include <stdlib.h>
#include <stdio.h>

typedef unsigned long JMBAG;

int main(int argc, char *argv[]) {
  JMBAG jmbag;
  if ((argc < 5) || (argc > 7)) {
    fprintf(stderr, "%s sifVU sifPred akGodina rbrSemUAkGod [rbrIzvedba] [rbrKompIzvPred]\n", argv[0]);
    return EXIT_FAILURE;
  }
  /* PROLOG */
  printf("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
  printf("<!DOCTYPE studBezPotpis SYSTEM \"https://www.isvu.hr/dtds/studBezPotpis.dtd\">\n");
  printf("<studBezPotpis>\n");
  printf("     <sifVU>%s</sifVU>\n", argv[1]);
  printf("     <sifPred>%s</sifPred>\n", argv[2]);
  printf("     <rbrIzvedba>%s</rbrIzvedba>\n", ((argc > 5) ? argv[5] : "1"));
  printf("     <rbrKompIzvPred>%s</rbrKompIzvPred>\n", ((argc > 6) ? argv[6] : "1"));
  printf("     <akGodina>%s</akGodina>\n", argv[3]);
  printf("     <rbrSemUAkGod>%s</rbrSemUAkGod>\n", argv[4]);
  printf("     <studenti>\n");
  while (scanf("%lu", &jmbag) != EOF)
    printf("       <JMBAG>%010lu</JMBAG>\n", jmbag);
  /* EPILOG */
  printf("     </studenti>\n");
  printf("</studBezPotpis>\n");
  return EXIT_SUCCESS;
}
