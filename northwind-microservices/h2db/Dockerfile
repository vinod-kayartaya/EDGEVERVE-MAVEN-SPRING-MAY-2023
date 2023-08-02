from openjdk:17-alpine

workdir /vinod/workspace
# run mkdir -p /vinod/workspace
# run cd /vinod/workspace

copy ./h2-1.4.197.jar ./h2.jar
copy ./northwind.mv.db /root

expose 8082

cmd [ "java", "-jar", "h2.jar", "-webAllowOthers", "-tcpAllowOthers" ]

