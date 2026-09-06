#!/bin/bash
cd "$(dirname "$0")"
javac Main.java
if [ $? -ne 0 ]; then
    echo ""
    echo "[ERROR] Compilation failed. Make sure Java JDK is installed."
    echo "Download from: https://www.oracle.com/java/technologies/downloads/"
    exit 1
fi
java Main
