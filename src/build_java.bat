@echo off
pushd eu\venovako\kolmerge
del /f /q *.class
javac -g *.java
popd
del /f /q KolMerge.jar
jar cvfe KolMerge.jar hr.fsb.venovako.kolmerge.KolMerge eu/venovako/kolmerge/*.class
jar i KolMerge.jar
pushd eu\venovako\matkol
del /f /q *.class
javac -g *.java
popd
del /f /q MatKol.jar
jar cvfe MatKol.jar hr.fsb.venovako.matkol.MatKol eu/venovako/matkol/*.class
jar i MatKol.jar
pushd eu\venovako\isvurez
del /f /q *.class
javac -g *.java
popd
del /f /q ISVURez.jar
jar cvfe ISVURez.jar hr.fsb.venovako.isvurez.ISVURez eu/venovako/isvurez/*.class
jar i ISVURez.jar
pushd eu\venovako\sorter
del /f /q *.class
javac -g *.java
popd
del /f /q Sorter.jar
jar cvfe Sorter.jar hr.fsb.venovako.sorter.Sorter eu/venovako/sorter/*.class
jar i Sorter.jar
