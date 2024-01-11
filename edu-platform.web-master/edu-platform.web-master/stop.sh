#!/bin/bash
deployDir="/opt/edu-platform.web"
cd $deployDir
test=`ps aux | grep serve | grep 4000 | grep -v grep -c`
if [ $test == 0 ]; then
        echo "[INFO] Service is already stop"
        exit
else
        ps aux | grep serve | grep 4000 | grep -v grep | awk '{print $2}' |  /usr/bin/xargs /bin/kill -9
        echo "[WARN] Service is stoping"
        exit
fi
