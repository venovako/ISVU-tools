#!/bin/bash
if [ `uname` = "Darwin" ]
then
	clang -DNDEBUG -Ofast -march=native -integrated-as studBezPotpis.c -o studBezPotpis.osx
else
	gcc -DNDEBUG -Ofast -march=native studBezPotpis.c -o studBezPotpis.lnx
fi
