@echo off
SET anonimize=%1
::path van dit script
cd /d %~dp0
del ..\output.txt
del ..\jar
del ..\gnuCash
del ..\transacties

if "%anonimize%"=="Y" (xcopy /y  "C:\Users\zwijze\Google Drive\FZ-IT\administratie\template GnuCash voor start nieuw jaar (opslaan als kiezen en dan naam met jaar)\Company_xyz_year_xyz.gnucash" ..\gnuCash)
if "%anonimize%"=="N" (xcopy /y  "C:\Users\zwijze\Google Drive\FZ-IT\administratie\jaar 2017\GnuCash\fz-it jaar-2017.gnucash" ..\gnuCash)

xcopy /y "transacties\*" ..\transacties
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL50BUNQ2291623486" "NL50BUNQ7273627486")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL85SNSB0918663318" "NL85SNSB0267345318")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL82SNSB0957846037" "NL82SNSB0263718037")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL72SNSB0898519659" "NL72SNSB0917253659")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL92SNSB0908995105" "NL92SNSB0883473105")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\2017-10-28_18-55-23_bunq-transactieoverzicht.sta" "NL87BUNQ2291624857" "NL87BUNQ4543545857")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL50BUNQ2291623486" "NL50BUNQ7273627486")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL85SNSB0918663318" "NL85SNSB0267345318")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL82SNSB0957846037" "NL82SNSB0263718037")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL72SNSB0898519659" "NL72SNSB0917253659")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL92SNSB0908995105" "NL92SNSB0883473105")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\transacties\tr-info_14813624_20171022114137.940" "NL87BUNQ2291624857" "NL87BUNQ4543545857")

SET configFileWorkspace=C:\mijn documenten\Maakboekingen\config\configuratie\config.xml
xcopy /y "%configFileWorkspace%" ..\config\config.xml
SET configXsdWorkspace=C:\mijn documenten\Maakboekingen\jibx\jibxcodegen\xsd\config.xsd
xcopy /y "%configXsdWorkspace%" ..\config\config.xsd
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL50BUNQ2291623486" "NL50BUNQ7273627486")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL85SNSB0918663318" "NL85SNSB0267345318")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL82SNSB0957846037" "NL82SNSB0263718037")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL72SNSB0898519659" "NL72SNSB0917253659")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL92SNSB0908995105" "NL92SNSB0883473105")
if "%anonimize%"=="Y" (replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "NL87BUNQ2291624857" "NL87BUNQ4543545857")
replace_string.vbs "c:\mijn documenten\maakboekingen\run_programma\config\config.xml" "C:\mijn documenten\Maakboekingen\transacties" "transacties"


SET configGnuCashFileWorkspace=C:\mijn documenten\Maakboekingen\maakboekingen\plugins\config\configGnuCash.xml
xcopy /y "%configGnuCashFileWorkspace%" ..\plugins\config\configGnuCash.xml
if "%anonimize%"=="Y" (replace_string.vbs "..\plugins\config\configGnuCash.xml" "C:\mijn documenten\Maakboekingen\GnuCashSqlite\fz-it jaar-2017.gnucash" "gnuCash\Company_xyz_year_xyz.gnucash")
if "%anonimize%"=="N" (replace_string.vbs "..\plugins\config\configGnuCash.xml" "C:\mijn documenten\Maakboekingen\GnuCashSqlite\fz-it jaar-2017.gnucash" "gnuCash\fz-it jaar-2017.gnucash")
SET configGnuCashXsdWorkspace=C:\mijn documenten\Maakboekingen\jibxGnuCashConfig\jibxcodegen\xsd\configGnuCash.xsd
xcopy /y "%configGnuCashXsdWorkspace%" ..\plugins\config\configGnuCash.xsd

SET mavenrepo=C:\Users\zwijze\.m2\repository
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
set jarTool="C:\Program Files\Java\jdk1.8.0_151\bin\jar.exe"
%jarTool% -cMf makeBookings.zip ..\makeBookings.cmd ..\jar ..\config ..\plugins ..\help ..\gnuCash ..\transacties
pause 100000