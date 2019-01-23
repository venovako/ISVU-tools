/* Pravi unos za hr.fsb.venovako.isvurez.ISVURez.
   STDIN: tab-separated linije oblika
   JMBAG BODOVI_KOLOKVIJ_1 ... BODOVI_KOLOKVIJ_N
   STDOUT: tab-separated linije oblika
   JMBAG OCJENA
   OCJENA je pozitivna (2..5) i formira se na temelju:
   min_one - minimalni broj bodova na svakom pojedinom kolokviju
   min_all - minimalni zbroj bodova na svim kolokvijima (za 2)
   min_oc3 - mimimalni zbroj bodova za ocjenu 3
   min_oc4 - minimalni zbroj bodova za ocjenu 4
   min_oc5 - minimalni zbroj bodova za ocjenu 5
*/
#include <stdlib.h>
#include <stdio.h>

typedef unsigned long long JMBAG;
typedef unsigned int Number;

int main(int argc, char *argv[]) {
  JMBAG jmbag;
  Number N, min_one, min_all, min_oc3, min_oc4, min_oc5, i, sum, ocjena, *kol;

  if (argc != 7) {
    fprintf(stderr, "%s N min_one min_all min_oc3 min_oc4 min_oc5\n", argv[0]);
    return EXIT_FAILURE;
  }

  sscanf(argv[1], "%u", &N);
  sscanf(argv[2], "%u", &min_one);
  sscanf(argv[3], "%u", &min_all);
  sscanf(argv[4], "%u", &min_oc3);
  sscanf(argv[5], "%u", &min_oc4);
  sscanf(argv[6], "%u", &min_oc5);
  if ((N == 0) || (min_all < min_one) || (min_oc3 <= min_all) || (min_oc4 <= min_oc3) || (min_oc5 <= min_oc4)) {
    fprintf(stderr, "Neispravni argumenti!\n");
    return EXIT_FAILURE;
  }

  if ((kol = (Number*)malloc(N * sizeof(Number))) == NULL)
    return EXIT_FAILURE;

  while (scanf("%llu", &jmbag) != EOF) {
    sum = 0;
    ocjena = 0;

    for (i = 0; i < N; ++i) {
      if (scanf("%u", kol + i) == EOF) {
	fprintf(stderr, "Neispravan unos!\n");
	free(kol);
	return EXIT_FAILURE;
      }
      if (kol[i] < min_one)
	ocjena = 1;
      if (ocjena == 0)
	sum += kol[i];
    }

    if (ocjena == 0) {
      if (sum < min_all)
	ocjena = 1;
      else if (sum < min_oc3)
	ocjena = 2;
      else if (sum < min_oc4)
	ocjena = 3;
      else if (sum < min_oc5)
	ocjena = 4;
      else
	ocjena = 5;
    }

    if (ocjena >= 2)
      printf("%010llu\t%u\n", jmbag, ocjena);
  }

  free(kol);
  return EXIT_SUCCESS;
}
