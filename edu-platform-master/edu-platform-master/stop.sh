#!/bin/bash
cd /opt/edu-platform
test=`ps aux | grep /opt/edu-platform | grep edu-platform | grep jar | grep -v grep -c`
if [ $test -eq 0 ]; then
        echo "[INFO] Service is already stop"
        exit
else
        ps aux | grep /opt/edu-platform | grep edu-platform | grep jar | grep -v grep | awk '{print $2}' |  /usr/bin/xargs /bin/kill -9
        echo "[WARN] Service is stoping"
        exit
fi
