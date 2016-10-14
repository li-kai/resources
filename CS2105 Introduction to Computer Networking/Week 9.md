# CS2105 Week 9

### Crpytography
#### Symmetric key
Involves the use of one key

Algorithms: Data Encryption Standard (DES) and Advanced Encription Standard (AES)
Example: Mono-alphabetic cipher
- Substituting one letter for another
- a -> m, m -> h, z -> q, etc.

Not safe as there is no safe channel to share the key.

#### Public key
Involves the use of a pair of keys; one for encryption and the other for decryption.
Sender and receiver do not need to share a key.
Sender will encrypt message with the sender's public key.
Receiver with the decrypt key will decrypt message received.

Question is: How to verify the sender is not malicious?

Algorithms: Rivest, Shamir, Adelson (RSA)
Example: RSA

- Public key is product of two very large primes
- Private key is derived from two large primes
- Complexity derived from difficulty of factoring a prime.

RSA to distribute session key. Use session key to encrypt and decrypt messages for performance reasons.

#### Message Integrity
Ensuring message through

- Ensure message integrity with Message Authentication Code (MAC)
- Verifying message source with digital signature
Uses cryptographic hash functions.

##### Hash Functions
Algorithms: Message Digest (MD5) and Secure Hash Algorithm (SHA)(SHA-1)
These are one-way functions, that are almost impossible to hash two different messages that result to the same hash.

E.g. Receiver will hash the result message, and check if the sender's hash is the same in the message. If they are the same, it is highly unlikely the message is tempered.

> Checksums are not secure, as it is not too hard to make another message with the same checksum

##### Message Authentication Code (MAC)
If a key is used as in the process of generation, it is a MAC.
- Can detect accidental and intentional changes to a message
- Can confirm message's origin
Algorithms: HmacMD5, HmacSHA1, HmacSHA256, etc.

##### Digital Signature
Verifiable: Recipient can verify sender, who has signed the document.
Non-repudiation: If recipient shows the digital signature to a third party, there is no ambiguity to who signed the document.

> This is different from MAC, as both sender and receiver can produce the same MAC as they share a key.

> There is also no way to prove to third party that MAC is produced by the parties involved.

##### Real world
Signing the original message may take too long, as its length may vary and be too long.

Thus, what we do is:

1. Hash the long message to get a hash that is shorter.
2. Use private key to sign the hash with Digital Signature.
3. Receiver receives the message, hashes it on his/her side.
4. The message digest will be decrypted, and compared with the computed hash in step 3.
5. If the two hashes are identical, receiver can then confirm the validity of the message and its sender.

>  This is to prove the creator of the message, and not to secure the transmission of the message content.

#### Secure Sockets Layer (SSL)
Applicable to TCP applications
Better version is Transport Layer Security (TLS)

Common SSL symmetric ciphers:

- DES – Data Encryption Standard: block
- 3DES – Triple strength: block
- RC2 – Rivest Cipher 2: block
- RC4 – Rivest Cipher 4: stream

#### Internet Protocol Security (IPsec)
Suite of protocols that secure communication by authenticating and encrypting each IP packet in a session. Both SSL and IPsec can be used to build VPN.
