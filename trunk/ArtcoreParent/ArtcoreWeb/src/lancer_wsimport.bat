
cd /d "%~dp0"

"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xnocompile -s . http://localhost:9090/WSOrchestrator/VerifCommandeImpl?wsdl
REM "C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xno-addressing-databinding -Xnocompile -s .  main\resources\wsdlOrchestrator.wsdl

pause
REM LE WS doit être accessible.