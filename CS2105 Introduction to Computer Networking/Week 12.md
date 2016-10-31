Physical layer moves data in form of electro magnetic signals.

0 & 1s transmitted by analog or digital signals.

### Digital transmission
- Different voltages

##### NRZ (Non-Return-to-Zero)
- NRZ-L absolute voltage determines value of a bit
- NRZ-I inverts voltage if bit 1 is encountered (swap voltage)

##### RZ (Return-to-Zero)
- Drops to 0 voltage during a 0 bit

##### Manchester
- A +ve to -ve represents 0 bit and 1 otherwise.

### Analog transmission
- Sine wave

#### Channel Bandwidth
Only allows signal in a certain frequency range to pass through; this is called the bandwidth.

#### Signal to Noise Ratio (SNR)
Measures the strength of signal noise

##### Shannon Channel Capacity
Theoretical maximum bit rate is given by:
```
C = B * lg(1 + SNR)
```
where B is the bandwidth

> Modem = Modulator + Demodulator

##### Amplitude Shifting Keys (ASK)
- 1 bit has varying amplitude whereas 0 has none
- subsceptible to noise

##### Frequency Shifting Keys (FSK)
- 1 bit has higher frequency whereas 0 has lower
- limited by bandwidth f the channel

##### Phase Shifting Keys (PSK)
- Phase 0 degree is bit 1, phase of 180 degree is bit 0
- limited by bandwidth f the channel

###### QPSK Constellation Diagram
- More varying degrees to fit in more bits

###### 8-PSK Constellation Diagram
- More varying degrees to fit in more bits 
- 3 bits in this case with 8 varying phase
- increasing phases may be affected by noise

##### Quadrature Amplitude Modulation (QAM)
- Combines ASK and PSK
- 2^k - QAM scheme can represent k bits
- Baud rate is the nuber of signal units per second
- Bit rate is the number of bits received per second
- 16-QAM, 64-QAM exists

## How the Internet works
- Start-up
    + Asks for IP from DHCP server
    + DHCP negotiates and sends IP
- DHCP sends IP addresses of first-hop router and local DNS server
    + Type "facebook.com"
    + PC broadscase ARP query for MAC address of local DNS server
    + DNS query encapsulated in UDP segment, then in IP datagram, then in Ethernet frame sent to local DNS
    + Local DNS replies with IP of facebook
- PC sends HTTP request to facebook
    + TCP socket openeed with 3 way handshake with facebook's server
    + http messages exchanged after TCP setup
        * Frames sent to first hop router
        * IP datgrams forwarded from network to ISP
        * Private IP is translated by school router
- Facebook is contacted
    + Negotiate for secure connection
    + SSL/TLS connection if HTTPS
