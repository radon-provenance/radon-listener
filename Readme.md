# Install radon-listener

## Get Code

git clone https://github.com/radon-provenance/radon-listener.git


## Configure variables for the different hosts

export DSE_HOST="`docker exec dse hostname -i`"
export MQTT_HOST="`docker exec mqtt hostname -i`"

## Configure ./pom.xml

Set the hostname for mqtt host in <mqttHost> (This is temporary)
  

## Create Docker image for the listener

docker build -t radon-listener-image --build-arg DSE_HOST --build-arg MQTT_HOST  -f radon-listener/Dockerfile .

  
## Run the rule engine

docker run -it --rm radon-listener-image:latest mvn exec:java -Dexec.mainClass="org.radon.listener.RadonApp"

If installed correctly it should display notifications when an action fires a rule in Radon.
