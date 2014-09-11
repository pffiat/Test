JAVA PROJECT
============

##java 1.7
##tomcat 7
##couchDB 1.6
##maven 3
##git

DL the JDK7 => http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html (that should make the coffee) 
you need to update the .bashrc => add two lines to inquire the path, JRE is optional, for example mine:

<export JAVA_HOME=/opt/jdk
export PATH=$JAVA_HOME/bin:$PATH

export JRE_HOME=/opt/jre
export PATH=$JRE_HOME/bin:$PATH>

these folders are made with symboly link : 

be a lil lazy linuxboy do apt-get and install couchdb, maven and git

download tomcat https://tomcat.apache.org/download-70.cgi
[installation guide](http://www.eclipse.org/webtools/jst/components/ws/M4/tutorials/InstallTomcat.html)

in the bashrc also, i can't remember why i got two different paths??

<export M2_HOME=/opt/apache-maven
export PATH=$M2_HOME/bin:$PATH

export MAVEN_HOME=/opt/apache-maven
export PATH=$MAVEN_HOME/bin:$PATH>

get eclipse (J2EE version) => https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/luna/R/eclipse-jee-luna-R-linux-gtk-x86_64.tar.gz&mirror_id=514

once on eclipse, import the project (file/import... then search and choose 'dynamic web module') 

ASK me or duckduckgo if you need any help!

on git don't push target (they are precomplied files so they are useless, u can't work on them they are already finished product)
