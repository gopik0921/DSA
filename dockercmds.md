docker run --name ubuntu_bash --rm -it ubuntu bash

docker run --name ubuntu_bash -it ubuntu bash

docker container ls -a

docker ps

docker rm f76bc5bacdae

docker exec -d ubuntu_bash touch /tmp/execWorks

docker exec -it ubuntu_bash bash

docker start 135df67d02c7


docker container prune   //WARNING! This will remove all stopped containers.

docker stop 135df67d02c7

docker images

docker cp foo.txt mycontainer:/foo.txt

docker cp mycontainer:/foo.txt foo.txt

Network types::

bridge: The default network driver. If you don’t specify a driver, this is the type of network you are creating. Bridge networks are usually used when your applications run in standalone containers that need to communicate. 

host: For standalone containers, remove network isolation between the container and the Docker host, and use the host’s networking directly

overlay: Overlay networks connect multiple Docker daemons together and enable swarm services to communicate with each other. You can also use overlay networks to facilitate communication between a swarm service and a standalone container, or between two standalone containers on different Docker daemons. This strategy removes the need to do OS-level routing between these containers.

macvlan: Macvlan networks allow you to assign a MAC address to a container, making it appear as a physical device on your network. The Docker daemon routes traffic to containers by their MAC addresses. Using the macvlan driver is sometimes the best choice when dealing with legacy applications that expect to be directly connected to the physical network, rather than routed through the Docker host’s network stack

none: For this container, disable all networking


User-defined bridge networks are best when you need multiple containers to communicate on the same Docker host.

Host networks are best when the network stack should not be isolated from the Docker host, but you want other aspects of the container to be isolated.

Overlay networks are best when you need containers running on different Docker hosts to communicate, or when multiple applications work together using swarm services.

Macvlan networks are best when you are migrating from a VM setup or need your containers to look like physical hosts on your network, each with a unique MAC address.

User-defined bridges provide automatic DNS resolution between containers::

Containers on the default bridge network can only access each other by IP addresses, unless you use the --link option, which is considered legacy. On a user-defined bridge network, containers can resolve each other by name or alias.


User-defined bridges provide better isolation::

All containers without a --network specified, are attached to the default bridge network. This can be a risk, as unrelated stacks/services/containers are then able to communicate.


Containers can be attached and detached from user-defined networks on the fly::

During a container’s lifetime, you can connect or disconnect it from user-defined networks on the fly. To remove a container from the default bridge network, you need to stop the container and recreate it with different network options.


docker network create --attachable -d overlay springbankNet

docker run -d --name axon-server \
-p 8024:8024 -p 8124:8124 \
--network springbankNet \
--restart always axoniq/axonserver:latest

docker commit eab4c70b66a2 gopi/ubuntu:01

 docker volume create jenkins      //TRA00244-01-01-IN-RTS1
 
 docker run -d -p 8080:8080 -p 50000:50000 -v jenkins:/var/jenkins_home jenkins/jenkins
 
 docker logs -f eab4c70b66a2
 
 docker inspect 28d81a817dfe
 
 




