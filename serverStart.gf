start locator --name=locator1 --port=41111 --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start locator --name=locator2 --port=41112 --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m

start server --name=server1 --server-port=0 --classpath=../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start server --name=server2 --server-port=0 --classpath=../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start server --name=server3 --server-port=0 --classpath=../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
