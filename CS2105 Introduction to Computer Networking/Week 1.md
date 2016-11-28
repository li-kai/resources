## Circuit Switching
A process where bandwidth is divided into pieces and each link is reserved for the client and the server. A call setup is required before setting up the link.

## Packet Switching
A process of breaking the application message into smaller chunks, known as packets, of _length_ `L` bits.

The link transmits packets at _transmission rate_ `R` bits/sec. Also known as _link capacity_ or _link bandwidth_.

Packets are passed from one router to the next,
across links on path from source to destination. Entire packet must arrive at a
router before it can be transmitted on the next link.

**End-to-end delay** = `2 * L/R` (assuming no other delay)

### Routing
Routers determine source-destination route taken by packets.

Packets queue in router buffers, and so arriving in a full queue will be dropped (aka
lost).

### Addressing
Each packet needs to carry source and destination information.

## Packet delay
### Processing delay
To check bit errors and determine output link.

### Queuing delay
Time waiting in the buffer queue for transmission.

### Transmission delay
Equivalent to `L/R` where L is number of **bits** and R is the link bandwidth.

### Propagation delay
Equivalent to `d/s` where d is length of the link and s is the propagation speed in medium.

### Throughput
How many bits can be transmitted per unit time. This is measured end-to-end (entire path).

#### Link capacity (bandwidth)
Bandwidth for a specific link.

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
