# Teletext

![teletext](/teletext.jpg)

---

## Description
Teletext is a multi users UDP application who looks like the ancien teletext.    
You can connect to the teletext server and check news on various subjects.   
The app use the Teletext protocol, you can find the information about it [here.](/Documentation/PROTOCOL.md)

---

## Building the app
The app use maven  so in order to build and package the app use this command.

```sh
# Download the dependencies
./mvnw dependency:resolve

# Package the application
./mvnw package
```
---

## Running the app
Download the .jar file into the lastest [release]() and run the command explained under this text. 
You can also download the source code and build the code with Maven but make sure to have included all dependencies.

### Launch the teletext server

The port's value is by default `5000`

```sh
java -jar <path-to-jar> server -a <address> -p <port>

# Example
java -jar Teletext-v1.0.jar server --address 127.0.0.1
```
### Launch a news emiter 

The port's value is by default `5000`

```sh
java -jar <path-to-jar> emitter <type> [weather, heig, politic, sport]

# Example
java -jar Teletext-v1.0.jar emitter sport
```

### Launch a client

```sh
java -jar <path-to-jar> client -a <address> -p <port>

# Example
java -jar Teletext-v1.0.jar client --address 127.0.0.1 --port 11111
```

### Description

- `-a, --address <IP address>`: IP address to connect.
- `-p, --port <port>`: Port to connect.

---

## Docker and Docker compose
You can also use this app with Docker by using the project's [Dockerfile]().   
This will allow you to launch an instance of an emitter, a server, or a client.

### Build the Docker image
```sh
docker build <path_to_the_Dockerfile>
```

### Run the Docker image
```sh
docker run <path_to_the_Dockerfile> <type> [server, emitter, client]
```
if it's an emitter dont forget to add the type of emitter you want. [weather, heig, politic, sport]

There is also a [docke-compose.yaml]() file. You can compose it up, it will start a server and 4 news emitters.   
After that, you are free to start by yourself the number of client you want by unsing the [Dockerfile]() or the [.jar]() file.

### Compose the docker-compose.yaml file up
```sh
docker compose up <path_to_the_Dockerfile>
```

---
