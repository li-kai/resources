# CS2105 Week 10
## Link Layer
The link layer sends datagram between adjacent nodes (hosts or routers) over a single link.

- Different link-layer protocols may be used on different links.

### Framing
Encapsulate datagram into frame, adding head and trailer.
[Header | Payload | Trailer]

At every hop, old header and trailers will be removed and new ones will be added.

Link access control
When multiple nodes share a single link, we need to coordinate which nodes can send frames at a certain point of time.
> I.E. Traffic control for frames

##### Reliable delivery
Seldomly used in fibre networks but used extensively in wireless networks (Loss)

##### Error detection
Caused by signal attenuation or noise.

##### Error correction
May correct bit errors without resorting to retransmission

### Link Layer Implementation
Implemented in "adapter" (NIC) or on a chip.

> Ethernet card

Adapters are semi autonomous

#### Error Detection and Corruption
- Checksum
- Parity Checking
- CRC

> CRC is used in link layer as it is slower in software but hardware is specialised.

#### Parity Checking
Detect single bit errors in data.
- Single Bit Parity reliable only for odd bit flipping
- Two dimensional bit parity prevents all scenarios

#### Cyclic Redundancy Check (CRC)
Success rate is very high and thus widely used in practice.

D: data bits, viewed as binary
G: generator of r+1 bits, agreed by sender and receiver beforehand.
R: will generate CRC of r bits

Steps:

1. Add `r` 0 bits to end of `D`
2. Divide the new `D` with `G`
    - If the two bits are identical, return 0
    - If they are different, return 1
    - Remove leading zeros, and get more to divide by `r` bits
3. Repeat until remainder is obtained. This is the CRC value.

In actual implementation, calculation is done in bit-wise XOR without carry or borrow.
Sender sends `(D, R)`
Receiver knows `G` and divides `(D, R)` by `G`.

### Network Links
##### Point-to-point link
Sender and receiver are connected by a dedicated link.
> E.g. Point-to-Point Protocol (PPP), Serial Linked Internet Protocol (SLIP)

#### Broadcast link (shared medium)
Multiple nodes connected to a shared channel.
When node transmits a frame, the channel broadcasts the channel.

If two or more nodes transmit, collisions may occur.

#### Mutiple Access Protocols
- Channel partitioning
    + Divide channel into smaller pieces
    + Allocate piece to node
- Taking turns
- Random Access
    + Channel is not divided and collisions are possible
    + Recovery methods needed in case of collisions

##### Channel Partitioning Protocols
###### Time Division Multiple Access (TDMA)

- Access to channel in rounds.
- Each node gets a fixed length slots and unused slots go idle.

###### Frequency Division Multiple Access (FDMA)

- Channel specturm divided into frequency range
- Each node assigned a frequency band and unused bands go idle.
- Frequently used by radios

##### "Taking Turns" Protocol
###### Polling

- Master node "invites" slave nodes to transmit in turn
- However there is an overhead (rtt) involved
- Master node is the single point of failure

###### Token Passing

- Control token is passed from one node to the next
- However, there is an overhead
- Failure point is now with the token

##### Random Access Protocol
###### Slotted ALOHA

- Assumption
    + All frames are of equal size
    + Time is divided into slots of equal length
    + Nodes start to transmit only at start of a slot

- Operations
    + Listens to the channel while trasmitting (collision detection)
    + If collision happens, node reransmits a frame in the next time slot with a  probability until success.

###### Pure ALOHA

- No slot, no synchronization
- Whenever there is a fresh frame, transmit immediately
- Chance of collision increases

###### Carrier Sense Multiple Access

- Sense channel is idle, transmit frame
- If busy, hold on
> Analogy: We wait for others to finish speaking before doing so.
- Collisions may still happen due to propagation delay (Nodes may not know busy status until its too late)

###### CSMA/CD (Collision Detection)
- When collision is detected, transmission is aborted.

- What if the frame size is too small?
> Impose minimum frame size.

- Collision detection easy in wired LANs but difficult in wireless LANs as the clients might be too far apart from each other (only router knows)

###### CSMA/CD (Collision Avoidance)
- Receiver needs to return ACK if a frame is received OK.