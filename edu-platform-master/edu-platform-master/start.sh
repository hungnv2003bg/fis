#!/bin/bash
cd /opt/edu-platform
test=`ps aux | grep /opt/edu-platform | grep edu-platform.jar | grep -v grep -c`
if [ $test -eq 0 ]; then
        /usr/bin/nohup /usr/bin/java -Xmx4096m -Xms512m -jar /opt/edu-platform/edu-platform.jar >> /opt/edu-platform/nohup.out &
        echo "[INFO] Service is starting"
        exit
else
        echo "[WARN] Service is already running"
        exit
fi
