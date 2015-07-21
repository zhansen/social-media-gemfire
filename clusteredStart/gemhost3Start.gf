connect --locator=gemhost1[41111]

start server --name=server5 --server-port=0 --classpath=../../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
start server --name=server6 --server-port=0 --classpath=../../target/classes/ --properties-file=gemfire.properties --initial-heap=50m --max-heap=50m
