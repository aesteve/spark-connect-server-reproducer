## Broken spark-connect-server

Start spark-connect-server from Spark install dir: 
```
./sbin/start-connect-server.sh --packages org.apache.spark:spark-connect_2.12:3.5.1
```

Then run `Main` with spark 3.5.1: 

```
Exception in thread "main" java.lang.NoSuchMethodError: 'void com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, java.lang.Object)'
```

Change build.sbt to use version 3.4.1, it works



## Attempt with docker: does not work

```
docker run -p 15002:15002 -td apache/spark:3.5.1 /bin/bash -c "/opt/spark/sbin/start-connect-server.sh --packages org.apache.spark:spark-connect_2.12:3.5.1; tail -f /dev/null"
```

Shows: 

```
UNAVAILABLE: Network closed for unknown reason
```

Stop docker, make sure no connect server is running, the error is actually different:
```
Caused by: org.sparkproject.connect.client.io.netty.channel.AbstractChannel$AnnotatedConnectException: Connection refused: localhost/[0:0:0:0:0:0:0:1]:15002

```

Meaning there's a different network issue most likely