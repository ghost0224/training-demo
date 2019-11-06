#!/bin/bash

MODULE=$1
BASE_NAME=10.1.20.13:5000/${MODULE}
TIME=`date "+%Y%m%d%H%M"`
GIT_VERSION=`git log -1 --pretty=format:"%h"`
IMAGE_NAME=${BASE_NAME}:${TIME}_${GIT_VERSION}

docker rmi $(docker images | grep ${BASE_NAME})
docker build -t ${IMAGE_NAME} .

docker push ${IMAGE_NAME}
echo "${IMAGE_NAME}" > IMAGE_NAME

