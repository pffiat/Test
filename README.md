##JAVA PROJECT


[Install markdown if you don't have it (one among a lot)](https://github.com/Thiht/markdown-viewer)

###java 1.7

[Download the **JDK7**](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) (that should make the coffee) 

Now you need to **update the .bashrc** => add two lines to inquire the path, JRE is optional, for example mine:

```sh
export JAVA_HOME=/opt/jdk
export PATH=$JAVA_HOME/bin:$PATH

export JRE_HOME=/opt/jre
export PATH=$JRE_HOME/bin:$PATH
```

These folders are made with **symbolic links** : ```ln -s source destination```

It should be somethink like ```ln -s /opt/jdk1.7.0_60 /opt/jdk```

You can then switch easily from a version to another by editing this symbolic link

###tomcat 7

[Download tomcat](https://tomcat.apache.org/download-70.cgi) then 

[Follow this installation guide](http://www.eclipse.org/webtools/jst/components/ws/M4/tutorials/InstallTomcat.html)

In the bashrc also, i can't remember why i got two different paths??

```sh
export M2_HOME=/opt/apache-maven
export PATH=$M2_HOME/bin:$PATH

export MAVEN_HOME=/opt/apache-maven
export PATH=$MAVEN_HOME/bin:$PATH
```

###couchDB 1.6 Maven Git

Be a lil lazy linuxboy do **apt-get** and install couchdb, maven and git

###eclipse Luna

[Get eclipse **J2EE version**](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/R/eclipse-jee-luna-R-linux-gtk-x86_64.tar.gz&mirror_id=514) I installed it in /opt

Once on eclipse, import the project (*file/import...* then search and choose *Existing Maven Project*).

Then click on the right-click on the name of the project, left column -> *Build Path* -> Configure BuildPath. Search for *targeted runtime* click *New*, select *Apache Tomcat v7.0*, Next, *Browse...* and search for the current location of your Tomcat, *Finish*.



With some luck, it's all good.

###more...

ASK **me or duckduckgo** if you need any help!

On git don't push target (they are precomplied files so they are useless, u can't work on them they are already finished product)
*Possibility ot switch to Java8!* 
