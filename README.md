# Teletext

![teletext](/teletext.jpg)


## Description
Teletext is a multi users UDP application who looks like the ancien teletext.    
You can connect to the teletext server and check news on various subjects.   
The app use the Teletext protocol, you can find the information about it [here.](/Documentation/PROTOCOL.md)


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

```sh
java -jar <path-to-jar> server

# Example
java -jar Teletext-v1.0.jar server
```
### Launch a news emiter 

```sh
java -jar <path-to-jar> emitter <type> [weather, heig, politic, sport]

# Example
java -jar Teletext-v1.0.jar emitter sport
```

### Launch a client

```sh
java -jar <path-to-jar> client

# Example
java -jar Teletext-v1.0.jar client
```


## Docker and Docker compose
You can also use this app with Docker by using the project's [Dockerfile]().   
This will allow you to launch an instance of an emitter, a server, or a client.   

Please clone the projet and then enter this command in the directory where you can find the Dockerfile.

### Build the Docker image
```sh
mvn wrapper:wrapper

docker build -t ghcr.io/<your_github_account>/teletext .
```

### Run the Docker image
```sh
docker run ghcr.io/<your_github_account>/teletext <type> [server, emitter, client]
```
if it's an emitter dont forget to add the type of emitter you want. [weather, heig, politic, sport]

### Publish the Docker image

```sh
# Connect to the ghcr
export GITHUB_CR_PAT=MY_TOKEN
echo $GITHUB_CR_PAT | docker login ghcr.io -u <your_github_account> --password-stdin
docker tag java-udp-programming ghcr.io/<your_github_account>/teletext
docker push ghcr.io/<your_github_account>/teletext
```

There is also a [docke-compose.yaml]() file. You can compose it up, it will start a server and 4 news emitters.   
After that, you are free to start by yourself the number of client you want by unsing the [Dockerfile]() or the [.jar]() file.

### Compose the docker-compose.yaml file up int the directory where there is the .yaml file
```sh
docker compose up
```
