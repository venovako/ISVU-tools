#!/bin/bash
pushd eu/venovako/kolmerge
rm -f *.class
javac -g *.java
popd
rm -f KolMerge.jar
jar cvfe KolMerge.jar hr.fsb.venovako.kolmerge.KolMerge eu/venovako/kolmerge/*.class
jar i KolMerge.jar
pushd eu/venovako/matkol
rm -f *.class
javac -g *.java
popd
rm -f MatKol.jar
jar cvfe MatKol.jar hr.fsb.venovako.matkol.MatKol eu/venovako/matkol/*.class
jar i MatKol.jar
pushd eu/venovako/isvurez
rm -f *.class
javac -g *.java
popd
rm -f ISVURez.jar
jar cvfe ISVURez.jar hr.fsb.venovako.isvurez.ISVURez eu/venovako/isvurez/*.class
jar i ISVURez.jar
pushd eu/venovako/sorter
rm -f *.class
javac -g *.java
popd
rm -f Sorter.jar
jar cvfe Sorter.jar hr.fsb.venovako.sorter.Sorter eu/venovako/sorter/*.class
jar i Sorter.jar
