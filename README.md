__Functionalities used__

Extract XML, update XML fields, fill PDF/XFA, flatten PDF/XFA
To start up, make sure that the run.sh file is executable after downloading (see step 12 below), and run that to install dependencies and code.

Using VSC


__Quick Setup__

1. Cmd + shift + p
2. Java: Create Java Project
3. Maven
4. maven-archetype-quickstart
5. Version
6. Group ID (com.poc)
7. Project name (demo)
8. Use javac -version to check your java version and change maven.compiler.source and maven.compiler.target to match
10. touch run.sh on the same level as the pom.xml
11. echo "mvn clean compile exec:exec" > path/to/run.sh (change package/class if necessary)
12.  chmod +x run.sh
13. ./run.sh to try everything

__iText setup__

14. Pom, right under opening project node:

```xml
  <repositories>
    <repository>
      <id>itext</id>
      <name>iText Repository - releases</name>
      <url>https://repo.itextsupport.com/releases</url>
    </repository>
  </repositories>
```

15. Pom, to dependencies:
```xml
  <dependency>
    <groupId>com.itextpdf</groupId>
    <artifactId>commons</artifactId>
    <version>9.2.0</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>kernel</artifactId>
      <version>9.2.0</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>io</artifactId>
      <version>9.2.0</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>layout</artifactId>
      <version>9.2.0</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>forms</artifactId>
      <version>9.2.0</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf</groupId>
      <artifactId>pdfxfa</artifactId>
      <version>5.0.2</version>
    </dependency>
    <dependency>
      <groupId>com.itextpdf.licensing</groupId>
      <artifactId>licensing-base</artifactId>
      <version>${itext.licensekey.version}</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-simple</artifactId>
      <version>2.0.16</version>
    </dependency>
```

...and properties:

```xml
    <itext.licensekey.version>4.2.2</itext.licensekey.version>
    <pdfxfa.version>5.0.2</pdfxfa.version>
  ```

__iText Licence Setup__

1. Download licence and place in root under itextkey.json
2. Load the key in your java code, as follows:

```java
import com.itextpdf.licensing.base.LicenseKey;

...

String pathLicenceKey = System.getProperty("user.dir") + "/itextkey.json";
LicenseKey.loadLicenseFile(new File(pathLicenceKey));
```


