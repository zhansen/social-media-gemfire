connect --locator=gemhost1[41111]

start server --name=server7 --server-port=0 --classpath=../../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start server --name=server8 --server-port=0 --classpath=../../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
