# Teletext

![teletext](/teletext.jpg)

## Description
Teletext is a multi users UDP application who looks like the ancien teletext.       
The app use the Teletext protocol, you can find the information about it [here.](/PROTOCOL.md)

## Building the app
The app use maven  so in order to build and package the app use this command.

```sh
# Download the dependencies
./mvnw dependency:resolve

# Package the application
./mvnw package
```

## Running the app
Download the .jar file into the lastest [release]() and run the command explained under this text. 
You can also download the source code and build the code with Maven but make sure to have included all dependencies.

### Launch the teletext server

The port's value is by default `11111`

```sh
java -jar <path-to-jar> server -a <address> -p <port>

# Example
java -jar SheepMaBoat-v1.0.jar server --address 127.0.0.1
```
### Launch a news emiter

The port's value is by default `11111`

```sh
java -jar <path-to-jar> server -a <address> -p <port>

# Example
java -jar SheepMaBoat-v1.0.jar server --address 127.0.0.1
```

### Launch a client

```sh
java -jar <path-to-jar> client -a <address> -p <port>

# Example
java -jar SheepMaBoat-v1.0.jar client --address 127.0.0.1 --port 11111
```

### Description

- `-a, --address <IP address>`: IP address to connect.
- `-p, --port <port>`: Port to connect.
