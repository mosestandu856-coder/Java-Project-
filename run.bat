@echo off
cd /d "%~dp0"
javac Main.java
if %errorlevel% neq 0 (
    echo.
    echo [ERROR] Compilation failed. Make sure Java JDK is installed.
    echo Download from: https://www.oracle.com/java/technologies/downloads/
    pause
    exit /b 1
)
java Main
pause
