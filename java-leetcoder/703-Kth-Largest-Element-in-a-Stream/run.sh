#!/bin/bash
JAR="../junit-platform-console-standalone-1.9.3.jar"

echo "Compiling..."
javac -cp $JAR *.java

if [ $? -eq 0 ]; then
    echo "Running tests..."
    java -jar $JAR --class-path . --scan-class-path
else
    echo "Compilation failed!"
fi
