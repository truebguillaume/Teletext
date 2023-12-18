# Protocol d'application TeleText

## 1 - Overview
- The Teletext protocol is designed to enable the transmission, reception, and display of information like a teletext
- The server listens to news emitters and stores the news to allow clients to access and view them.
- The client connects to the teletext server and requests information about different categories (UDP unicast).
- The emitters are independent of the server or clients (UDP multicast).


## 2 - Transport protocol
- The Teletetx protocol uses the `UDP protocol`. The server runs on the `port 5001`.  
- The client has to know the IP address of the server to connect to. The client establishes the connection with the server **(unicast)**.
- The emitters send news across the network and the server store them  **(multicast)**.
- The connection between the client and the server stops either when the client enters the command to disconnect or if an error occurs.


## 3 - Messages

### 3.1 - Servers
#### Start the server 
Command : ` server`
|Response|Detail|
| ---- | ---- |
|_no response_|The teltext server will wait for new client connections and retrieve the news emitted by the emitters.|


### 3.2 - Emitters
#### Start the news emitter 
Command : `emitter <type> [weather, heig, politic, sport]`
|Response|Detail|
| ---- | ---- |
|_no response_|The news emitter will start multicasting news on the network.|


### 3.3 - Clients
#### Connect the client to the teletext server
Command: `client`
|Response|Detail|
| ---- | ---- |
|`_no response_`|Try to connect to the teletext server|

#### When the connection with the server is established (auto send)
Command: `welcome`
|Response|Detail|
| ---- | ---- |
|`TXT <message>`|Display a welcome message|

#### Get help to know what you can do
Command: `help`
|Response|Detail|
| ---- | ---- |
|`TXT <message>`|Print a menu with all available commands|

#### Display news categories
Command: `menu`
|Response|Detail|
| ---- | ---- |
|`TXT <message>`|List all existing categories|

#### Display the news about a selected category
Command: `list <category> [weather, heig, politic, sport]`
|Response|Detail|
| ---- | ---- |
|`TXT <message>`|List the news for the selected category|
|`ERR 200`|Actually, there is no news in this category|
|`ERR 201`|Actually, this category does not exist|

#### Display number of news for a selected category
Command: `count <category> [weather, heig, politic, sport]`
|Response|Detail|
| ---- | ---- |
|`TXT <message>`|Print the number of the news for the selected category|
|`ERR 201`|Actually, this category does not exist|


#### Disconnect the client from the teletext server
Command: `exit`
|Response|Detail|
| ---- | ---- |
|`_no response_`|Disconnect the client from the teletext server|

#### If you try an unkown command
Command: `???`
|Response|Detail|
| ---- | ---- |
|`ERR 100`|Unknown command|



## 4 - Examples
