@echo off
SET anonimize=N
::path van dit script
cd /d %~dp0
del  ..\output.txt
del  ..\jar
if "%anonimize%"=="Y" (SET configFileWorkspace=config_anonimized\config.xml)

if "%anonimize%"=="N" (SET configFileWorkspace=C:\mijn documenten\Maakboekingen\config\configuratie\config.xml)

SET configXsdWorkspace=C:\mijn documenten\Maakboekingen\jibx\jibxcodegen\xsd\config.xsd
xcopy /y "%configFileWorkspace%" ..\config\config.xml
xcopy /y "%configXsdWorkspace%" ..\config\config.xsd
SET configGnuCashFileWorkspace=C:\mijn documenten\Maakboekingen\maakboekingen\plugins\config\configGnuCash.xml
SET configGnuCashXsdWorkspace=C:\mijn documenten\Maakboekingen\jibxGnuCashConfig\jibxcodegen\xsd\configGnuCash.xsd
xcopy /y "%configGnuCashFileWorkspace%" ..\plugins\config\configGnuCash.xml
xcopy /y "%configGnuCashXsdWorkspace%" ..\plugins\config\configGnuCash.xsd
SET mavenrepo=C:\Users\zwijze2\.m2\repository
xcopy /y "%mavenrepo%\nl\fzit\maakboekingen\config\0.0.1-SNAPSHOT\Config-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\maakboekinggnucash\configgnucash\0.0.1-SNAPSHOT\configGnuCash-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\files\0.0.1-SNAPSHOT\files-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\maakboekingen\maakboekingen\0.0.1-SNAPSHOT\maakboekingen-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\maakboekinggnucash\0.0.1-SNAPSHOT\MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar" ..\plugins
xcopy /y "%mavenrepo%\nl\fzit\maakboekingen\makebooking.api\0.0.1-SNAPSHOT\makebooking.api-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\sql\0.0.1-SNAPSHOT\sql-0.0.1-SNAPSHOT.jar" ..\jar
xcopy /y "%mavenrepo%\org\xerial\sqlite-jdbc\3.7.2\sqlite-jdbc-3.7.2.jar" ..\jar
xcopy /y "%mavenrepo%\org\jibx\maven-jibx-plugin\1.3.1\maven-jibx-plugin-1.3.1.jar" ..\jar
xcopy /y "%mavenrepo%\org\jibx\jibx-extras\1.3.0\jibx-extras-1.3.0.jar" ..\jar
xcopy /y "%mavenrepo%\org\jibx\jibx-run\1.3.0\jibx-run-1.3.0.jar" ..\jar
xcopy /y "%mavenrepo%\nl\fzit\maakboekingen\maakboekingen\0.0.1-SNAPSHOT\maakboekingen-0.0.1-SNAPSHOT.jar" ..\jar
del makebookings.zip
jar -cMf makeBookings.zip ..\makeBookings.cmd ..\jar ..\config ..\plugins ..\help
pause 100000