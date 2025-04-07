### ✅ **Manually Create Maven Structure**

If not already created, make the structure manually:

```bash
mkdir -p src/main/java/com/vehicleanalyzer/model
mkdir -p src/main/java/com/vehicleanalyzer/dao
mkdir -p src/main/java/com/vehicleanalyzer/util
mkdir -p src/main/java/com/vehicleanalyzer/servlet
mkdir -p src/main/webapp/WEB-INF
mkdir -p src/main/webapp/static/css
mkdir -p src/main/webapp/static/js
touch src/main/webapp/index.jsp
touch src/main/webapp/dashboard.jsp
touch src/main/webapp/WEB-INF/web.xml
```

### ✅  **Create `pom.xml` Manually**

At the root of `vehicle-analyzer/`, create a `pom.xml` file:

```xml

<project xmlns="http://maven.apache.org/POM/4.0.0" 
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.vehicleanalyzer</groupId>
  <artifactId>vehicle-analyzer</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <dependencies>
    <!-- Servlet API -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>

    <!-- JSP API -->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>javax.servlet.jsp-api</artifactId>
      <version>2.3.3</version>
      <scope>provided</scope>
    </dependency>

    <!-- Hibernate -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>5.6.15.Final</version>
    </dependency>

    <!-- Postgress SQL (or your DB driver) -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.6.0</version>
    </dependency>

    <!-- JUnit (optional for testing) -->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

  <build>
    <finalName>vehicle-analyzer</finalName>
    <plugins>
      <!-- Compiler plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.10.1</version>
        <configuration>
          <source>11</source>
          <target>11</target>
        </configuration>
      </plugin>

      <!-- WAR packaging plugin -->
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.3.2</version>
      </plugin>
    </plugins>
  </build>
</project>
```

### ✅ **Reload VS Code**

VS Code should now detect the `pom.xml` and offer to import the Maven project. If not:

* Press `Ctrl+Shift+P` → `Maven: Reload project`
* Or restart VS Code
