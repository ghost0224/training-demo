#!/bin/bash

IMAGE=`cat IMAGE_NAME`
DEPLOYMENT=$1
MODULE=$2

echo "update image to:${IMAGE}"
RESULT=`sudo kubectl get deployment/${DEPLOYMENT}`
RESULT=${RESULT:0:4}
if [ $RESULT = "NAME" ]
then
    echo "reset image"
    sudo kubectl set image deployment/${DEPLOYMENT} ${MODULE}=${IMAGE}
else
    echo "create container... TODO"
fi

