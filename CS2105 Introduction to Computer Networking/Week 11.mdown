# CS2105 Week 11

## MAC Address
Every adapter (NIC) has a mac address
- Used to send 

Typically 48 bits, burned in NIC ROM.
MAC Address

## IP Address vs MAC Address
IP Address

- 32 bits in length
- move datagram from source to destination
- dynamically assigned
- analogy: postal address

MAC Address

- 48 bits in length
- link-layer address used to move frame over every single link
- permanant
- NRIC number

### Address Resolution Protocol (ARP)
Each IP node (host or router) has an ARP table which stores mappings of IP address and MAC address of other nodes in the same subnet.

1. If `B`'s MAC address is not in `A`'s ARP table, `A` broadcasts an **ARP query packet**, containing `B`'s IP address.
2. Only `B` will reply to `A` with its MAC address.
3. `A` caches `B`'s reply in its ARP table.

### Sending Frame to another subnet
`A` sends datagram to `B` by using router to move datagram to outgoing link and construct a new frame with `B`'s MAC address. Difference being, `A` will have to set source MAC to the router's MAC, and destination MAC to `B`'s.

## Local Area Network (LAN)
Ethernet and Wi-Fi are the two most popular LAN technologies

### Ethernet (802.3 Standards)
Different standards are developed over the years for different speeds and different physical layer media. The MAC protocol and frame format remain the same despite the different standards.

### Bus topology
Popular in mid 90s. All the nodes can collide with each other

#### Collisions
E.g.
- `A` sends a frame at time `t`.
- `A`'s frame reaches D at time `t + d`
- `D` begins transition at time `t + d - 1` and causes collision

### Star topology
Superior as nodes to not collide with each other, by having the switch in the center. This topology prevails today (reduced cost of switches).

### Ethernet Frame Structure
Sending NIC (adapter) encapsulates IP datagram in Ethernet frame. 
> 46 <= IP datagram <= 1500 bytes.

Syncronise bit rates by sending a preamble of 7 bytes with pattern 101010 to establish how to read the bits.

CRC: corrupted frame will be dropped

### Ethernet Data Delivery Service
Connectionless: no handshake
Unreliable: No ACK or NACK
Access protocol: CSMA/CD with binary backoff

#### Ethernet CSMA/CD Algorithm
1. NIC receives datagram from network layer and creates frame
2. If NIC sense channel is idle, starts frame transimission or waits until so.
3. If NIC transmits entire frame without collision, we are done.
4. If collision, it aborts and sends jam signal.
5. After aborting, NIC enters binary back-off with 2^m - 1 time by choose K at random from 0 - 2^m - 1 during the mth collision.

## Link-layer switch
### Ethernet switch

##### Link layer device
Stores and forwards Ethernet frames
Examine incoming frame's MAC address and selectively forward frame to outgoing links.

##### Transparent to hosts
No IP address
Hosts are unaware of presense of switches

Switch buffers frames and is full duplex
> A and D can send frames to each other simultaneously

CSMA/CD protocol is used although no collisions can happen.

##### Switch Forwarding table
The switch-table of a switch maps the MAC address of a host to an interface (port). As a host sends data, the switch will know the MAC address of the host, and recognise it as the owner of the interface. If the destination is unknown, the switch will broadcast the frame to all unknown interfaces, to get an answer.

Switches can be connected and chained in hierachy.

Normal to go Host > Switch > Router > Host.

