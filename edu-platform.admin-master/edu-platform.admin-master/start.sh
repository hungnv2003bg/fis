#!/bin/bash
deployDir="/opt/edu-platform.admin"
cd $deployDir

test=`ps aux | grep serve | grep 4001 | grep -v grep -c`
if [ $test == 0 ]; then
        /usr/bin/nohup serve -s build -l 4001 >> /opt/edu-platform.admin/nohup.out &
        echo "[INFO] Service is starting"
        exit
else
        echo "[WARN] Service is already running"
        exit
fi
