# Replace these paths with the actual paths to your Java 8 and Java 17 installations
export JAVA8_HOME="/path/to/your/java8"
export JAVA17_HOME="/path/to/your/java17"

# Add Java 8 and Java 17 to your PATH
export PATH="$JAVA8_HOME/bin:$JAVA17_HOME/bin:$PATH"

# Set JAVA_HOME to Java 8 initially
export JAVA_HOME="$JAVA8_HOME"

# Function to switch between Java versions
function switch_java() {
  if [ "$1" == "8" ]; then
    export JAVA_HOME="$JAVA8_HOME"
    echo "Switched to Java 8"
  elif [ "$1" == "17" ]; then
    export JAVA_HOME="$JAVA17_HOME"
    echo "Switched to Java 17"
  else
    echo "Invalid argument. Usage: switch_java [8|17]"
  fi
}
