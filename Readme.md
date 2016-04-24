# Upload to Maven Central

Base repository to demonstrate the process of uploading an `aar`/`jar` to maven central.

The process is as follows
1. Register for Nexus repository and also open a JIRA ticket at OSS Sonatype and wait for it to be resolved.
1. Create a android project in android studio.
1. Create a new module and choose `Android Library`.
1. Implement your library code.
1. Add the plugin by Chris Banes and define the required variables in the `gradle.properties`.
1. Run in terminal
  ```bash
  ./gradlew build clean uploadArchive
  ```
1. Login into Nexus repository and search for your package name.
1. Close the staged artifact.
1. Release the closed artifact.
1. Wait for some hours before everything gets synced with Maven Central.
1. Go get a coffee, for your done



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
