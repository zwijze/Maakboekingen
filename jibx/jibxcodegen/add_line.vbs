'This will add a line into a file 
add_line.vbs "C:\mijn documenten\aant_stater2\testautomatisering\conversion\hdn\src\main\jibxcodegen\generatedjavaandbindingfiles\com\stater\testautomatisering\conversions\hdn\ag\ax\OfferteAanvraagType.java" "package" "import com.stater.testautomatisering.conversions.hdn.ag.ax;"
set objWS = CreateObject("Wscript.Shell")
Set fsob=CreateObject("Scripting.FileSystemObject")

strFileName = Wscript.Arguments(0)
strNewLine = Wscript.Arguments(2)
strNewLine= Replace(strNewLine, "chr(34)", """")

Const FOR_READING = 1
Const FOR_WRITING = 2
strCheckForString = LCase(Wscript.Arguments(1))
strCheckForString= Replace(strCheckForString, "chr(34)", """")
Set objFS = CreateObject("Scripting.FileSystemObject")
Set objTS = objFS.OpenTextFile(strFileName, FOR_READING)
strContents = objTS.ReadAll
objTS.Close
arrLines = Split(strContents, vbNewLine)
Set objTS = objFS.OpenTextFile(strFileName, FOR_WRITING)
For Each strLine In arrLines
If (InStr(strLine,strCheckForString)>0) Then
objTS.WriteLine strNewLine
objTS.WriteLine strLine
else
objTS.WriteLine strLine
End If