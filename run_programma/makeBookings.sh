#!/bin/bash
#config file pad opgeven
configFile="config/config.xml"

configJar="jar/config-0.0.1-SNAPSHOT.jar"
configGnuCashJar="jar/configGnuCash-0.0.1-SNAPSHOT.jar"
filesJar="jar/files-0.0.1-SNAPSHOT.jar"
sqlJar="jar/sql-0.0.1-SNAPSHOT.jar"
sqlSqliteJdbcJar="jar/sqlite-jdbc-3.7.2.jar"
makebookingApiJar="jar/makebooking.api-0.0.1-SNAPSHOT.jar"
jibxJar="jar/maven-jibx-plugin-1.3.1.jar"
jibxextraJar="jar/jibx-extras-1.3.0.jar"
jibxruntimeJar="jar/jibx-run-1.3.0.jar"
pluginsJar="plugins/MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar"
#maakBoekingGnuCashJar="plugins/MaakBoekingGnuCash-0.0.1-SNAPSHOT.jar"
maakboekingenJar="jar/maakboekingen-0.0.1-SNAPSHOT.jar"

echo $configFile
echo $jibxJar
java -classpath $pluginsJar:$maakboekingenJar:$configJar:$configGnuCashJar:$filesJar:$sqlJar:$sqlSqliteJdbcJar:$makebookingApiJar:$jibxJar:$jibxextraJar:$jibxruntimeJar nl.fzit.maakboekingen.maakboekingen.Maakboekingen $configFile>output.txt
sleep 5s
