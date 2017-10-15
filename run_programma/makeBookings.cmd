@echo off
::config file pad opgeven
SET configFile=config\config.xml

SET configJar=jar\Config-0.0.1-SNAPSHOT.jar
SET configGnuCashJar=jar\configGnuCash-0.0.1-SNAPSHOT.jar
SET filesJar=jar\files-0.0.1-SNAPSHOT.jar
SET sqlJar=jar\sql-0.0.1-SNAPSHOT.jar
SET sqlSqliteJdbcJar=jar\sqlite-jdbc-3.7.2.jar
SET makebookingApiJar=jar\makebooking.api-0.0.1-SNAPSHOT.jar
SET jibxJar=jar\maven-jibx-plugin-1.3.1.jar
SET jibxextraJar=jar\jibx-extras-1.3.0.jar
SET jibxruntimeJar=jar\jibx-run-1.3.0.jar
REM SET pluginsJar="C:\mijn documenten\Maakboekingen\run_programma\plugins\nl\fzit\MaakBoekingGnuCash"
REM SET pluginsJar=plugins
REM SET pluginsJar="C:\mijn documenten\Maakboekingen\run_programma\plugins"
REM SET pluginsJar="C:\mijn documenten\Maakboekingen\run_programma\plugins\MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar"
SET pluginsJar=plugins\MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar
SET maakBoekingGnuCashJar=plugins\MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar
SET maakboekingenJar=jar\maakboekingen-0.0.1-SNAPSHOT.jar
java -cp %maakboekingenJar%;%pluginsJar%;%configJar%;%configGnuCashJar%;%filesJar%;%sqlJar%;%sqlSqliteJdbcJar%;%makebookingApiJar%;%jibxJar%;%jibxextraJar%;%jibxruntimeJar% nl.fzit.maakboekingen.maakboekingen.Maakboekingen "%configFile%">output.txt
pause(10000)