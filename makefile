randmst: CustomComparator.java Edge.java MST.java Subset.java randmst.java 
%.class: %.java
    javac -d . -classpath . $<
clean:
    rm -f *.class