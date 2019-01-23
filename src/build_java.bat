@echo off
pushd hr\fsb\venovako\kolmerge
del /f /q *.class
javac -g *.java
popd
del /f /q KolMerge.jar
jar cvfe KolMerge.jar hr.fsb.venovako.kolmerge.KolMerge hr/fsb/venovako/kolmerge/*.class
jar i KolMerge.jar
pushd hr\fsb\venovako\matkol
del /f /q *.class
javac -g *.java
popd
del /f /q MatKol.jar
jar cvfe MatKol.jar hr.fsb.venovako.matkol.MatKol hr/fsb/venovako/matkol/*.class
jar i MatKol.jar
pushd hr\fsb\venovako\isvurez
del /f /q *.class
javac -g *.java
popd
del /f /q ISVURez.jar
jar cvfe ISVURez.jar hr.fsb.venovako.isvurez.ISVURez hr/fsb/venovako/isvurez/*.class
jar i ISVURez.jar
pushd hr\fsb\venovako\sorter
del /f /q *.class
javac -g *.java
popd
del /f /q Sorter.jar
jar cvfe Sorter.jar hr.fsb.venovako.sorter.Sorter hr/fsb/venovako/sorter/*.class
jar i Sorter.jar
