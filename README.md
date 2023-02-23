# Example Hilla Spring AOT project

## Requirements

- GraalVM JDK (install manually or through https://sdkman.io/)
- Node 18+

## Developing the application

Run the application by running `Application.java` or with maven `mvn`.

## Compiling to native

Build a native image with:
```
mvn -Pproduction -Pnative clean package native:compile
```

Then run it with:
```
 ./target/hilla-aot-demo
```