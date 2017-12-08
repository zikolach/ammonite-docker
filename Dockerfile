FROM java:latest
RUN mkdir ~/.ammonite && curl -Ls -o ~/.ammonite/predef.scala https://git.io/vro0a
RUN curl -Ls -o /bin/amm https://git.io/vdNv2 && chmod +x /bin/amm
EXPOSE 8080
# ADD index.scala /bin/
# CMD ["index.scala"]
