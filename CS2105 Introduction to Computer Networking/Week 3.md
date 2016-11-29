# Week 3: Socket Programming

## Internet Transport Protocols

### Addressing Processes
IP address is used to identify a host device, but not sufficient to identify process running inside that host.

Hence port number is also needed. 1-1023 are reserved for standard use.

## Sockets
Socket is the software interface between app processes and transport layer protocols.

Process sends/receives messages to/from its socket.

Multiplexing / de-multiplexing
Use IP address + port number to locate a process.

#### Stream socket (aka TCP socket)
Uses TCP as its transport layer protocol, it is connection-oriented, reliable.

When contacted by client, server TCP creates a new socket for server process to communicate with client.

#### Datagram socket (aka UDP socket)
Uses UDP, it is connection-less, unreliable (transmitted data may be lost, corrupted or received out-of-order)

Sender (client) explicitly attaches destination IP address and port number to every packet. Receiver (server) extracts sender IP address and port number from the received packet.

Hence, UDP sockets can use one socket to serve all clients, and do not need establishment of connection.

# Glossary of Terms

Term | Meaning
---------|---------
**Byte** | 8 bits
**Packet** | data of some bits
**Transmission rate** | rate of bits/sec
**End-to-end delay** | `2 * bits/transmission rate` (assuming no other delay)
**Packet delay** | time to check bit errors and determine output link
**Queuing delay** | time waiting in the buffer queue for transmission.
**Transmission delay** | number of **bits** / transmission rate (bits/sec)
**Propagation delay** | length of the link / propagation speed in medium.
**RTT** | time for a packet to travel from client to server and go back
**Stream socket** | TCP Socket
**Datagram socket** | UDP Socket


Term | Meaning
---------|---------
**HTTP** | **H**yper**t**ext **t**ransfer **p**rotocol
**RR** | resource records as used in DNS servers
**Root Servers** | Root DNS servers
**Sockets** | software interface between app processes and transport layer protocols