# Useful Bash Commands

## List SSL expiry time
```bash
echo | openssl s_client -connect <domain>:443 2>/dev/null | openssl x509 -noout -dates
```

## Show all processes
```bash
ps -aux | grep <insert filter>
```