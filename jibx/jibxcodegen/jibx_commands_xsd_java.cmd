@echo on
::Run the script: "C:\mijn documenten\aant_stater2\testautomatisering\conversion\hdn\src\main\jibxcodegen\jibx_commands_xsd_java.cmd"
SET maatschappij=dflt
SET maindir=C:\mijn documenten\aant_stater2\testautomatisering\conversion
SET codegendir=%maindir%\hdn\src\main\jibxcodegen
SET jibxlib=%maindir%\jibx\lib
SET xsddir=%maindir%\hdn\src\main\config\%maatschappij%\ax
::SET xsddir=%maindir%\hdn\src\main\config\
SET gendir=%codegendir%\generatedjavaandbindingfiles
SET srcdir=%maindir%\hdn\src\main\java\com\stater\testautomatisering\conversion\hdn\%maatschappij%\ax
SET mappingdir=%maindir%\hdn\src\main\mapping
SET packagedir=%gendir%\com\stater\testautomatisering\conversion\hdn\%maatschappij%\ax
::Als alternatief van onderstaande verwijderen van bin directory met gecompileerde class file is de een Ant taak: ant clean (zie ook ant help voor allerlei opties, dus niet ant -help. In de build.xml staan de defities van de Ant build)
rmdir %gendir% /s /q

mkdir %gendir%

::Update schema tag met namespace zodat de gegenereerde java soucede juistepakage naam hebben
::Neem voor een " chr(34) anders werkt het script niet.
cscript "%codegendir%\replace_string.vbs" "C:\mijn documenten\aant_stater2\testautomatisering\conversion\hdn\src\main\config\%maatschappij%\ax\ax.xsd" "chr(34)http://www.w3.org/2001/XMLSchemachr(34)>" "chr(34)http://www.w3.org/2001/XMLSchemachr(34) elementFormDefault=chr(34)qualifiedchr(34) targetNamespace=chr(34)http://stater.com/testautomatisering/conversion/hdn/%maatschappij%/axchr(34)>"


::Run codegen voor genereren binding.xml file en java files o.b.v. XSD file.
::Alternatief van onderstaande commando is een Ant taak: ant codegen
echo "Run codegen"
java -cp "%jibxlib%\jibx-tools.jar" org.jibx.schema.codegen.CodeGen -t "%gendir%" -w "%xsddir%\ax.xsd"

::Vervang <namespace uri="http://stater.com/testautomatisering/conversion/hdn/dflt/ax" default="elements"/> door:
::  <namespace uri="http://www.w3.org/2001/XMLSchema-instance" prefix="xsi" default="none"/>
::  <namespace uri="http://www.w3.org/2001/XMLSchema" prefix="xsd" default="none"/>
:: Zodoende krijgt de offerteaanvraag tag deze 2 namespaces gedefinieerden dat is nodig anders slikt de HDN bericht processor ze niet
cscript "%codegendir%\replace_string.vbs" "%gendir%\binding.xml" "<namespace uri=chr(34)http://stater.com/testautomatisering/conversion/hdn/dflt/axchr(34) default=chr(34)elementschr(34)/>" "<namespace uri=chr(34)http://www.w3.org/2001/XMLSchema-instancechr(34) prefix=chr(34)xsichr(34) default=chr(34)nonechr(34)/><namespace uri=chr(34)http://www.w3.org/2001/XMLSchemachr(34) prefix=chr(34)xsdchr(34) default=chr(34)nonechr(34)/>"


::Add implements statement to class line of each file generated.
::echo running loop test 
::FOR %%X in ("%packagedir%\*.java") DO cscript "%codegendir%\replace_string.vbs" "%%~dpnX.java" "public class %%~nX" "public class %%~nX implements I%%~nX"
::echo Done
::pause

::echo "Copying generated java files to package location"->Kopieer zelf de bestanden de 1e keer anders zegt eclipse bij importen in het project dat e bestanden al bestaan.
::xcopy /y "%packagedir%\*.java" "%srcdir%"

echo "Copying generated binding.xml file to mapping location"
copy /y "%gendir%\binding.xml" "%mappingdir%\binding_%maatschappij%_ax.xml"