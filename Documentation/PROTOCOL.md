# Protocol d'application TeleText

## 1 - Overview
- The Teletext protocol is meant to  
- The client connects to a server and request informations about a topic   
- The server manage 

## 2 - Transport protocol
- The Teletetx protocol uses the `UDP protocol`. The server runs on the `port 11111`.  
- The client has to know the IP address of the server to connect to. **The client establishes the connection with the server.**   
- The connection ends when 

## 3 - Messages



### 3.1 - Servers

Start the server : `server -i <ip (default -> 127.0.0.1)> -p <port (default -> 11111)>`
|Response|Detail|
| ---- | ---- |
|||

Shutdown the server : `shutdown`
|Detail|
| ---- |
|It will shut the server down.|

### 3.2 - Emitters

### 3.3 - Client Handler
#### Connection
Command: `client -i <ip> -p <port (default -> 11111)>`
|Response|Detail|
| ---- | ---- |
|`welcome`|A welcome message and you what you have to do.|
|`err`||
