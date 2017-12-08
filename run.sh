#!/bin/bash

docker build -t zikolach/amm .
docker run -it --rm \
  -p 127.0.0.1:8080:8080 \
  -v $(pwd):/run \
  zikolach/amm /run/index.scala
