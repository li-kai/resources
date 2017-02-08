# Week 2: Application Layer

## Internet Transport Protocols

### TCP
Reliable transport between sending and
receiving process.

Flow control: sender won’t overwhelm receiver

Congestion control: throttle sender when network is overloaded

However, it does not provide: timing, minimum throughput guarantee, security


### UDP
Unreliable data transfer between sending and receiving process, but faster.

However, it does not provide: reliability, flow control, congestion control, timing, throughput guarantee or security

### HTTP
Web’s application layer protocol, where the _client_ is usually a browser, and _server_, a web server. It uses TCP.

#### HTTP 1.0 (Non-persistent HTTP)

Client | Server
---------|---------
initiates TCP connection to server on port 80 |
 | waiting for TCP connection at port 80, "accepts" connection and reply client
sends HTTP request message (containing URL) into TCP connection socket |
 | receives request message, forms and sends response message containing requested object
 | closes TCP connection
receives response message |

Repeats for every new request needed.

RTT: time for a packet to travel from client to server and go back

one RTT to establish TCP connection + one RTT for HTTP request and the first few bytes of HTTP response to return

HTTP 1.0 response time = `2 * RTT + file transmission time`

#### HTTP Request Message
```
GET /~cs2105/demo.html HTTP/1.0
Host: www.comp.nus.edu.sg
User-Agent: Mozilla/5.0
Connection: close
\r\n
```
Last line indicates end of header.

200 OK
- request succeeded, requested object later in this msg

301 Moved Permanently
- requested object moved, new location specified later in this msg (Location:)

403 Forbidden
- server declines to show the requested webpage

404 Not Found
- requested document not found on this server

## Domain Name System
DNS translates between Hostname (e.g. www.comp.nus.edu.sg) and IP address (e.g. 137.132.80.57)

Stored as resource records (RR) in the following format: `(name, value, type, ttl)`

type = NS
- name is domain (e.g.,
nus.edu.sg)
- value is hostname of
authoritative name
server for this domain

type = A
- name is hostname
- value is IP address

type = CNAME
- name is alias name for some
“canonical” (the real) name
- value is canonical name
- e.g. www.comp.nus.edu.sg is really www0.comp.nus.edu.sg

type = MX
- value is name of mail server
associated with name

### Root Servers
13 root name servers worldwide serves by returning a list of the authoritative name servers for the appropriate top-level domain (TLD).

###  Top-level domain (TLD) servers
Responsible for com, org, net, edu, … and all top level country domains, e.g., uk, sg, jp

### Authoritative servers:
- Organization’s own DNS server(s), providing
authoritative hostname to IP mappings for
organization’s named hosts (e.g. Web, mail)
- can be maintained by organization or service
provider

### Local DNS Server
Retrieves name-to-address translation from local cache

Local DNS server acts as proxy and forwards query into hierarchy if answer is not found locally

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

Term | Meaning
---------|---------
**HTTP** | **H**yper**t**ext **t**ransfer **p**rotocol
**RR** | resource records as used in DNS servers
**Root Servers** | Root DNS servers