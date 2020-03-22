cd /opt/IBM/BPM/WebSphere/AppServer/profiles/AppSrv01/bin
./wsadmin.sh -lang jython -user waspadmin -password WebS-8d3 -conntype SOAP -port 14513 -c "AdminTask.BPMProcessInstancesPurge('[-instanceStatus COMPLETED]')"
./wsadmin.sh -lang jython -user waspadmin -password WebS-8d3 -conntype SOAP -port 14513 -c "AdminTask.BPMProcessInstancesPurge('[-instanceStatus TERMINATED]')"
echo "Purging of COMPLETED and TERMINATED BPM Processes complete."
