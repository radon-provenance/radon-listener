
git clone https://github.com/radon-provenance/radon-listener.git

export DSE_HOST="`docker exec dse hostname -i`"
export MQTT_HOST="`docker exec mqtt hostname -i`"

docker build -t radon-listener-image --build-arg DSE_HOST --build-arg MQTT_HOST  -f radon-listener/Dockerfile .


docker run -it --rm radon-listener-image:latest mvn exec:java -Dexec.mainClass="org.radon.listener.RadonApp"
