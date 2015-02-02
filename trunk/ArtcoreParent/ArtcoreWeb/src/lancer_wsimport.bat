
cd /d "%~dp0"

REM "C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -keep -s ws\src  -d ws http://192.168.100.129:9090/WSOrchestrator/VerifCommandeImpl?wsdl
"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xnocompile -s .  main\resources\wsdlOrchestrator.wsdl

pause
REM LE WS doit être accessible.