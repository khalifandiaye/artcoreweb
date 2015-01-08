
cd /d "%~dp0"

"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -keep -s ws\src  -d ws http://localhost:9090/WSOrchestrator/VerifCommandeImpl?wsdl


pause
REM LE WS doit être accessible.