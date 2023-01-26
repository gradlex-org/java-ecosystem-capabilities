plugins {
    id("org.gradlex.java-ecosystem-capabilities")
    id("java-library")
}

dependencies {
    implementation("asm:asm:3.3.1")
    implementation("c3p0:c3p0:0.9.1.2")
    implementation("cglib:cglib-nodep:3.2.12")
    implementation("cglib:cglib:3.3.0")
    implementation("com.google.collections:google-collections:1.0")
    implementation("com.google.guava:guava-jdk5:17.0")
    implementation("com.google.guava:guava:31.1-jre")
    implementation("com.google.guava:listenablefuture:1.0")
    implementation("com.mchange:c3p0:0.9.5.5")
    implementation("com.sun.activation:javax.activation:1.2.0")
    implementation("com.sun.mail:jakarta.mail:2.0.1")
    implementation("com.sun.mail:javax.mail:1.6.2")
    implementation("com.sun.mail:mailapi:2.0.0")
    implementation("com.vividsolutions:jts-core:1.14.0")
    implementation("com.vividsolutions:jts:1.13")
    implementation("commons-io:commons-io:2.11.0")
    implementation("dom4j:dom4j:1.6.1")
    implementation("jakarta.activation:jakarta.activation-api:2.1.0")
    implementation("jakarta.annotation:jakarta.annotation-api:2.1.0")
    implementation("jakarta.ejb:jakarta.ejb-api:4.0.0")
    implementation("jakarta.el:jakarta.el-api:4.0.0")
    implementation("jakarta.inject:jakarta.inject-api:1.0.5")
    implementation("jakarta.jws:jakarta.jws-api:3.0.0")
    implementation("jakarta.mail:jakarta.mail-api:2.1.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    implementation("jakarta.servlet:jakarta.servlet-api:5.0.0")
    implementation("jakarta.validation:jakarta.validation-api:2.0.1")
    implementation("jakarta.ws.rs:jakarta.ws.rs-api:3.0.0")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:3.0.1")
    implementation("jakarta.xml.soap:jakarta.xml.soap-api:2.0.1")
    implementation("jakarta.xml.ws:jakarta.xml.ws-api:3.0.1")
    implementation("javassist:javassist:3.12.1.GA")
    implementation("javax.activation:activation:1.1.1")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("javax.annotation:jsr250-api:1.0")
    implementation("javax.ejb:ejb-api:3.0")
    implementation("javax.ejb:ejb:2.1")
    implementation("javax.ejb:javax.ejb-api:3.2.2")
    implementation("javax.el:el-api:2.2")
    implementation("javax.el:javax.el-api:3.0.0")
    implementation("javax.inject:javax.inject:1")
    implementation("javax.jws:javax.jws-api:1.1")
    implementation("javax.mail:mail:1.4.7")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("javax.servlet:servlet-api:2.5")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("javax.ws.rs:javax.ws.rs-api:2.1.1")
    implementation("javax.ws.rs:jsr311-api:1.1.1")
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("javax.xml.soap:javax.xml.soap-api:1.4.0")
    implementation("javax.xml.stream:stax-api:1.0")
    implementation("javax.xml.ws:jaxws-api:2.3.1")
    implementation("jboss:javassist:3.8.0.GA")
    implementation("junit:junit-dep:4.8")
    implementation("junit:junit:4.12")
    implementation("org.apache.commons:commons-io:1.3.2")
    implementation("org.apache.tomcat:servlet-api:6.0.53")
    implementation("org.apache.tomcat:tomcat-annotations-api:10.1.1")
    implementation("org.apache.tomcat:tomcat-servlet-api:10.1.1")
    implementation("org.apache.velocity:velocity-engine-core:2.3")
    implementation("org.apache.velocity:velocity:1.7")
    implementation("org.codehaus.woodstox:stax2-api:4.2.1")
    implementation("org.codehaus.woodstox:woodstox-core-asl:4.4.1")
    implementation("org.codehaus.woodstox:woodstox-core-lgpl:4.4.0")
    implementation("org.codehaus.woodstox:wstx-asl:4.0.6")
    implementation("org.codehaus.woodstox:wstx-lgpl:3.2.9")
    implementation("org.dom4j:dom4j:2.1.3")
    implementation("org.eclipse.angus:jakarta.mail:1.0.0")
    implementation("org.hamcrest:hamcrest-core:2.2")
    implementation("org.hamcrest:hamcrest-library:2.2")
    implementation("org.hamcrest:hamcrest:2.2")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.0-api:1.0.1.Final")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
    implementation("org.hibernate.javax.persistence:hibernate-jpa-2.2-api:1.0.0.Beta2")
    implementation("org.javassist:javassist:3.29.1-GA")
    implementation("org.jboss.resteasy:jaxrs-api:2.0.0.GA")
    implementation("org.jboss.spec.javax.ws.rs:jboss-jaxrs-api_1.1_spec:1.0.1.Final")
    implementation("org.jboss.spec.javax.ws.rs:jboss-jaxrs-api_2.0_spec:1.0.1.Final")
    implementation("org.jboss.spec.javax.ws.rs:jboss-jaxrs-api_2.1_spec:2.0.2.Final")
    implementation("org.jboss.spec.javax.ws.rs:jboss-jaxrs-api_3.0_spec:1.0.1.Final")
    implementation("net.java.dev.jna:platform:3.4.0")
    implementation("net.java.dev.jna:jna-platform:5.10.0")
    implementation("org.locationtech.jts:jts-core:1.19.0")
    implementation("org.ow2.asm:asm:9.2")
    implementation("org.postgresql:postgresql:42.5.0")
    implementation("postgresql:postgresql:9.1-901-1.jdbc4")
    implementation("stax:stax-api:1.0")
    implementation("velocity:velocity:1.4")
    implementation("woodstox:wstx-asl:2.9.3")
    implementation("com.sun.activation:jakarta.activation:2.0.1") // down here due to bug: https://github.com/gradle/gradle/issues/14220
    // implementation("woodstox:wstx-lgpl:3.2.7") - has no POM file
}
