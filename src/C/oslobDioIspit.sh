#!/bin/bash
if [ `uname` = "Darwin" ]
then
	clang -DNDEBUG -Ofast -march=native -integrated-as oslobDioIspit.c -o oslobDioIspit.osx
else
	gcc -DNDEBUG -Ofast -march=native oslobDioIspit.c -o oslobDioIspit.lnx
fi
