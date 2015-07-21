start locator --name=locator2 --port=41111 --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m

start server --name=server3 --server-port=0 --classpath=../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start server --name=server4 --server-port=0 --classpath=../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
