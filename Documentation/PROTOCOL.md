> **TODO**   
> - Add more commands for the client   
> - Add examples   

# Protocol d'application TeleText

## 1 - Overview
- The Teletext protocol is designed to enable the transmission, reception, and display of information like a teletext
- The server listens to news emitters and stores the news to allow clients to access and view them.
- The client connects to the teletext server and requests information about different categories.

## 2 - Transport protocol
- The Teletetx protocol uses the `UDP protocol`. The server runs on the `port 11111`.  
- The client has to know the IP address of the server to connect to. The client establishes the connection with the server **(unicast)**.
- The emitters send news across the network and the server store them  **(broadcast)**.
- The connection between the client and the server stops either when the client enters the command to disconnect or if an error occurs.


## 3 - Messages

### 3.1 - Servers
#### Start the server 
Command : `teletext -i <ip (default -> 127.0.0.1)> -p <port (default -> 11111)>`
|Response|Detail|
| ---- | ---- |
|_no response_|The teltext server will wait for new client connections and retrieve the news emitted by the emitters.|

#### Shutdown the server 
Command : `shutdown`
|Response|Detail|
| ---- | ---- |
|_no response_|It will shut the teletext server down.|


### 3.2 - Emitters
#### Start the news emitter 
Command : `emitter -i <ip (default -> 127.0.0.1)> -p <port (default -> 11111)>`
|Response|Detail|
| ---- | ---- |
|_no response_|The news emitter will start broadcasting news on the network.|

#### Shutdown the news emitter 
Command : `shutdown`
|Response|Detail|
| ---- | ---- |
|_no response_|It will shut the news emitter down.|

### 3.3 - Clients
#### Connect the client to the teletext server
Command: `client -i <ip> -p <port (default -> 11111)>`
|Response|Detail|
| ---- | ---- |
|`welcome`|A welcome message and a description of what you can do here|
|`err`|Possible error|

#### Display news categories
Command: `news`
|Response|Detail|
| ---- | ---- |
|`news`|Display the news categories|
|`err`|Possible error|

#### Disconnect the client from the teletext server
Command: `disconnect`
|Response|Detail|
| ---- | ---- |
|`_no response_`|Disconnect the client from the teletext server|


## 4 - Examples
