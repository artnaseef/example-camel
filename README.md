# Example Camel Projects

Examples of simple Camel projects are included here to demonstrate camel basics
as well as wiring together working examples
which can be used as a starting point, or template, for more complex projects.


# To Build

    $ mvn clean package
    
    
# To Use

    $ PROJECT_VERSION="$(mvn -Dexec.executable="echo" -Dexec.args='${project.version}' --non-recursive -q org.codehaus.mojo:exec-maven-plugin:1.6.0:exec)"
    
**Simple Main**

    $ java -jar "example-camel-simple-main/target/example-camel-simple-main-${PROJECT_VERSION}.jar"
    