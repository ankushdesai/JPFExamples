- Note this repo is an example of regular system under test rather than jpf module, so there's no need to add JPFExamples in `site.properties`. But the `build.xml` does assume the following project structure:
  - jpf-core
  - JPFExamples
  - jpf-nhandler (needed for  `FileOperation.java`)
  - ...
- To invoke benchmarking, do `ant benchmark`. 
- To invoke jpf on examples, do `ant example`.
- To invoke junit tests, do `ant junit-test` . Note in order to run junit tests, one needs to manually set the path of `junit-*.jar` and `hamcrest-core-*.jar` inside `build.xml`.

