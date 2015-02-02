REM set JAVA_HOME=C:\Prog\java\jdk\jdk1.6
REM "%JAVA_HOME%/bin/wsimport" [- ....] http://localhost:8080/...../serviceXY?wsdl

set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_67

set WSDL_STOCK = http://localhost:9090/WSGestionStock/GestionStockImpl?wsdl

set WSDL_CB = http://localhost:9090/WSAntivolCB/AntivolCBImpl?wsdl

set WSDL_POLICE = http://localhost:9090/WSPolice/VerifCasierImpl?wsdl


cd /d "%~dp0"
REM

REM wsimport GestionStock
"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xnocompile -s ejbModule  src\main\resources\GestionStockImpl.wsdl

REM wsimport AntivolCB
"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xnocompile -s ejbModule  src\main\resources\AntivolCBImpl.wsdl

REM wsimport Police
"C:\Program Files\Java\jdk1.7.0_67\bin\wsimport" -Xnocompile -s ejbModule  src\main\resources\VerifCasierImpl.wsdl

pause
REM LE WS doit être accessible.