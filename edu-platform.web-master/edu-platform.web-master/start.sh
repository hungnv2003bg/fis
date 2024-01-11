#!/bin/bash
deployDir="/opt/edu-platform.web"
cd $deployDir

test=`ps aux | grep serve | grep 4000 | grep -v grep -c`
if [ $test == 0 ]; then
        /usr/bin/nohup serve -s build -l 4000 >> /opt/edu-platform.web/nohup.out &
        echo "[INFO] Service is starting"
        exit
else
        echo "[WARN] Service is already running"
        exit
fi
