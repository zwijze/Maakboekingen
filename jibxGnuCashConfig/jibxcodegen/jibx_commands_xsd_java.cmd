@echo off
::Run the script: "C:\mijn documenten\aant_stater2\testautomatisering\conversion\config\src\main\jibxcodegen\jibx_commands_xsd_java.cmd"
SET maindir=C:\mijn documenten\maakboekingen
SET codegendir=%maindir%\jibxGnuCashConfig\jibxcodegen
SET jibxlib=%maindir%\jibxGnuCashConfig\jibxcodegen\lib
SET xsddir=%maindir%\jibxGnuCashConfig\jibxcodegen\xsd
SET gendir=%codegendir%\generatedjavaandbindingfiles
SET srcdir=%maindir%\configGnuCash\src\main\java\nl\fzit\maakboekingGnuCash\configGnuCash
SET mappingdir=%maindir%\configGnuCash\src\main\mapping
SET packagedir=%gendir%\nl\fzit\maakboekingGnuCash\configGnuCash
::Als alternatief van onderstaande verwijderen van bin directory met gecompileerde class file is de een Ant taak: ant clean (zie ook ant help voor allerlei opties, dus niet ant -help. In de build.xml staan de defities van de Ant build)
rmdir %gendir% /s /q

mkdir %gendir%
::Run codegen voor genereren binding.xml file en java files o.b.v. XSD file.
::Alternatief van onderstaande commando is een Ant taak: ant codegen
echo "Run codegen"
java -cp "%jibxlib%\jibx-tools.jar" org.jibx.schema.codegen.CodeGen -t "%gendir%" -w "%xsddir%\configGnuCash.xsd"

::echo "Copying generated java files to package location"->Kopieer zelf de bestanden de 1e keer anders zegt eclipse bij importen in het project dat e bestanden al bestaan.
::echo "Copying generated java files to package location"
::xcopy /y "%packagedir%\*.java" "%srcdir%"

echo "Copying generated binding.xml file to mapping location"
xcopy /y "%gendir%\*.xml" "%mappingdir%"
pause 10000