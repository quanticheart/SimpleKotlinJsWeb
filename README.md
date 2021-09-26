### Simple Kotlin/js Web
After clone project, run this command

 ```sh
 ./gradlew run
 ```

* [Serialization Plugin](https://github.com/Kotlin/kotlinx.serialization)


###Tip:
if you're creating a new project and you're faced with the problem with jcenter being discontinued, do this:

change the code in the build.gradle.kt file from:
 ```sh
repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.7.2")
}
 ```

to:
 ```sh
repositories {
    maven(url = "https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-html-js:0.7.3")
}
 ```

### remove JCenter
Jcenter is deprecated on new versions of gradle, read more in:
* [JFrog to Shut down JCenter and Bintray](https://www.infoq.com/news/2021/02/jfrog-jcenter-bintray-closure/).


* [The jCenter & Bintray is Shutting Down. Now What?](https://wajahatkarim.com/2021/02/jcenter-bintray-shutting-down/).


* [Into the Sunset on May 1st: Bintray, GoCenter, and ChartCenter](https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter/).


* [JCenter deprecation; impact on Gradle and Android](https://stackoverflow.com/questions/66651640/jcenter-deprecation-impact-on-gradle-and-android).


* [So, JCenter is shutting down...](https://blog.sebastiano.dev/so-jcenter-is-shutting-down/).

update:
replace code in

[read](https://github.com/Kotlin/kotlinx.html/issues/173#issuecomment-806910768).


### Problems
* [webpack-cli] Invalid configuration object. Object has been initialized using a configuration object that does not match the API schema.
[Read](https://youtrack.jetbrains.com/issue/KT-48273).


* Process 'Resolving NPM dependencies using yarn' returns 1
[Read](https://youtrack.jetbrains.com/issue/KT-39173).
