'cscript replace.vbs “C:\Scripts\Text.txt” “Jim ” “James ”
'replace_string.vbs "C:\mijn documenten\aant_stater2\testautomatisering\conversion\hdn\src\main\config\ag\ax\ax.xsd" "chr(34)http://www.w3.org/2001/XMLSchemachr(34)" "chr(34)http://www.w3.org/2001/XMLSchemachr(34) elementFormDefault=chr(34)qualifiedchr(34) targetNamespace=chr(34)http://stater.com/testautomatisering/conversions/hdn/ag/axchr(34)"
'Een string in de strings moet gepresenteerddoor chr(34).
Const ForReading = 1

Const ForWriting = 2


strFileName = Wscript.Arguments(0)

strOldText = Wscript.Arguments(1)
strOldText= Replace(strOldText, "chr(34)", """")

strNewText = Wscript.Arguments(2)
strNewText= Replace(strNewText, "chr(34)", """")

Set objFSO = CreateObject("Scripting.FileSystemObject")

Set objFile = objFSO.OpenTextFile(strFileName, ForReading)

strText = objFile.ReadAll

objFile.Close

strNewText = Replace(strText, strOldText, strNewText)

Set objFile = objFSO.OpenTextFile(strFileName, ForWriting)

objFile.WriteLine strNewText

objFile.Close