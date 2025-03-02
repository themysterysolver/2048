## JAR CMD

```declarative
javac -d out Game2048.java GameLogic.java GUI2048.java Tile.java
jar cfm 2048Game.jar MANIFEST.MF -C out .
java -jar 2048Game.jar
```