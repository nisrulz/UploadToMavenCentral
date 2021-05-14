# Android Library: Publish to MavenCentral

### Show some :heart:
[![GitHub stars](https://img.shields.io/github/stars/nisrulz/UploadToMavenCentral.svg?style=social&label=Star)](https://github.com/nisrulz/UploadToMavenCentral) [![GitHub forks](https://img.shields.io/github/forks/nisrulz/UploadToMavenCentral.svg?style=social&label=Fork)](https://github.com/nisrulz/UploadToMavenCentral/fork) [![GitHub watchers](https://img.shields.io/github/watchers/nisrulz/UploadToMavenCentral.svg?style=social&label=Watch)](https://github.com/nisrulz/UploadToMavenCentral) [![GitHub followers](https://img.shields.io/github/followers/nisrulz.svg?style=social&label=Follow)](https://github.com/nisrulz/UploadToMavenCentral)  
[![Twitter Follow](https://img.shields.io/twitter/follow/nisrulz.svg?style=social)](https://twitter.com/nisrulz) 

Base repository to demonstrate the process of uploading an [`aar`](https://sites.google.com/a/android.com/tools/tech-docs/new-build-system/aar-format)/[`jar`](https://en.wikipedia.org/wiki/JAR_(file_format)) to [MavenCentral](https://search.maven.org/).

**Blog Post :** [Guide to publishing your Android Library via MavenCentral](http://crushingcode.co/publish-your-android-library-via-mavencentral/) 

The process is as follows

1. Create an Android project or open an existing one in [Android Studio](https://en.wikipedia.org/wiki/Android_Studio)

1. Init the project with git and also create a repo on Github for the same. Each step here onwards represent a commit and should be pushed to github.

1. Create and add a new module and choose `Android Library`.
   > Goto `File>New>New Module..` and select `Android Library`.

1. Implement your library code inside the library module you created in the last step.

1. Next add the library module as a dependency to the app module.
    + Goto `File>Project Structure..`
    + Select `app` module in the sidebar
    + Select the `Dependencies` tab
    + At the bottom is a `+` icon, click that and select `Module dependency` and select your `library` module.
    + Press `apply` or `ok`.
   
1. Add the plugin by Chris Banes to your library's `build.gradle` file at the end
    
    > NOTE:  Below is a fork of the [original script written by Chris Banes](https://github.com/chrisbanes/gradle-mvn-push).
    
    ```gradle
    apply from: 'https://raw.github.com/nisrulz/gradle-mvn-push/master/gradle-mvn-push.gradle'
    ```
    
    and define the required variables in the `gradle.properties`.
    ```
    # Properties used by gradle maven-push plugin

    # Library info
    GROUP=<group_name>
    VERSION_NAME=1.0.0
    VERSION_CODE=1

    # POM info
    POM_NAME=<Library_Name>
    POM_ARTIFACT_ID=<library_name_smallcaps>
    POM_DESCRIPTION=<library_description>
    POM_URL=https://github.com/<username>/<repo_name>
    POM_SCM_URL=https://github.com/<username>/<repo_name>
    POM_SCM_CONNECTION=scm:git@github.com:<username>/<repo_name>.git
    POM_SCM_DEV_CONNECTION=scm:git@github.com:<username>/<repo_name>.git

    ```
  
1. Setup [GPG](http://blog.ghostinthemachines.com/2015/03/01/how-to-use-gpg-command-line/) and generate yourself a key.
  
     + Now list your gpg keys
       ```bash
       $ gpg --list-keys
       ```
       >There the first line will be like pub XXXXX/YYYYYYYY <date>. Remember that ‘YYYYYYYY’ part, it’s you key ID.
     
     + Next, publish your keys
       ```bash
       $ gpg --keyserver hkp://keyserver.ubuntu.com --send-keys YYYYYYYY
       $ gpg --keyserver hkp://pgp.mit.edu --send-keys YYYYYYYY
       ```
     + To ensure your keys were published
       ```bash
       $ gpg --keyserver hkp://pgp.mit.edu --search-keys 
       username@example.com # Use your email
       ```
     
1. Setup Sonatype account
     + Create a JIRA account on [Sonatype](https://issues.sonatype.org/secure/Signup!default.jspa)
     + Once you are logged in, [create a new issue](https://issues.sonatype.org/secure/CreateIssue.jspa?issuetype=21&pid=10134)
     + Fill out the form as below
  
       ```
       Group Id : com.github.<github_username>
       Project URL : https://github.com/<github_username>/<project_name>
       SCM url : https://github.com/<github_username>/<project_name>.git
       Username : <sonatype_username>
       Already Synced to Central : No
       ```

     + Next hit submit. After you submit, it can take up to 2 business days to process your issue. Then you will receive a confirmation that your configuration has been prepared and you can publish your library.
       > **IMPORTANT** : Do not deploy until after you have received an e-mail notice indicating that the ticket is Resolved.
       
     + Update the global `gradle.properties` on your local machine at location `~/.gradle/gradle.properties` and include
  
        ```
          NEXUS_USERNAME=sonatype_username
          NEXUS_PASSWORD=sonatype_password
          signing.keyId=gpg_key_id 
          signing.password=gpg_password
          signing.secretKeyRingFile=/Users/username/.gnupg/secring.gpg
          org.gradle.daemon=true
        ```

2. Run in terminal to publish your artifacts
   
    ```bash
    ./gradlew build clean uploadArchive
    ```

3. Login into [Nexus Repository Console](https://oss.sonatype.org/#stagingRepositories) and search for your package name.

4. Close the staged artifact.[wait]

5. Release the closed artifact (keep drop artifact selected).[wait]

6. Wait for some hours before everything gets synced with MavenCentral.

7. To use the published library you have do something like below

    ```gradle
    dependencies {
        implementation 'com.github.nisrulz:awesomelib:1.0'
    }
    ```

8. Let the world know of your **AwesomeLib** :smile:
    + Add a readme that explains how to integrate and use your Awesome library
    + Add a license block as in this repo
    + Promote your lib on social media so that others can know about it.
    + Always add a working sample app in your project that demonstrates your library in use.
    + Add screenshots if possible in your read


If you appreciate my work, consider [buying me](https://www.paypal.me/nisrulz/5usd) a cup of :coffee: to keep me recharged :metal: [[PayPal](https://www.paypal.me/nisrulz/5usd)]

License
=======

    Copyright 2016 Nishant Srivastava

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
