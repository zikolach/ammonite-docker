FROM java
ADD hello.scala /
RUN mkdir ~/.ammonite && curl -L -o ~/.ammonite/predef.scala https://git.io/vro0a
RUN curl -L -o /bin/amm https://git.io/vro0u && chmod +x /bin/amm && amm hello.scala
CMD ["amm"]
