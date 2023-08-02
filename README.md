#!/bin/bash

# Define the paths to your Java 8 and Java 17 installations
JAVA_8_HOME="/path/to/your/java8/home"
JAVA_17_HOME="/path/to/your/java17/home"

# Function to set Java home to Java 8
set_java_8() {
    export JAVA_HOME="$JAVA_8_HOME"
    export PATH="$JAVA_HOME/bin:$PATH"
}

# Function to set Java home to Java 17
set_java_17() {
    export JAVA_HOME="$JAVA_17_HOME"
    export PATH="$JAVA_HOME/bin:$PATH"
}

# Usage message
usage() {
    echo "Usage: $0 {java8|java17}"
}

# Check the number of arguments
if [ $# -ne 1 ]; then
    usage
    exit 1
fi

# Check the argument and set the appropriate Java version
case "$1" in
    java8)
        set_java_8
        ;;
    java17)
        set_java_17
        ;;
    *)
        usage
        exit 1
        ;;
esac

