#!/bin/bash
cpuSeting="50"
cpuUsed=$(top -n 1 | awk -F '[ %]+' 'NR==3 {print $2}'|awk -F '.' '{print $1}')
if [ $cpuUsed -gt $cpuSetting ];then
  java -jar /root/robot.jar
fi
