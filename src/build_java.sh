#!/bin/bash
pushd hr/fsb/venovako/kolmerge
rm -f *.class
javac -g *.java
popd
rm -f KolMerge.jar
jar cvfe KolMerge.jar hr.fsb.venovako.kolmerge.KolMerge hr/fsb/venovako/kolmerge/*.class
jar i KolMerge.jar
pushd hr/fsb/venovako/matkol
rm -f *.class
javac -g *.java
popd
rm -f MatKol.jar
jar cvfe MatKol.jar hr.fsb.venovako.matkol.MatKol hr/fsb/venovako/matkol/*.class
jar i MatKol.jar
pushd hr/fsb/venovako/isvurez
rm -f *.class
javac -g *.java
popd
rm -f ISVURez.jar
jar cvfe ISVURez.jar hr.fsb.venovako.isvurez.ISVURez hr/fsb/venovako/isvurez/*.class
jar i ISVURez.jar
pushd hr/fsb/venovako/sorter
rm -f *.class
javac -g *.java
popd
rm -f Sorter.jar
jar cvfe Sorter.jar hr.fsb.venovako.sorter.Sorter hr/fsb/venovako/sorter/*.class
jar i Sorter.jar
