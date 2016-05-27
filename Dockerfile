FROM java
RUN curl -L -o /bin/amm https://git.io/vro0u && chmod +x /bin/amm
CMD ["amm"]
