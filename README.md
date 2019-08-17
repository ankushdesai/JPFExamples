This is a repo of examples using jpf. The jpf-core is added as submodule. 

- Simply using a git clone will create an empty `jpf-core` directory. To add the submodule files, inside `jpf-core` do: 
  - `git submodule init`
  - `git submodule update`
- Or, when doing a clone, simply do `git clone --recurse-submodules https://github.com/chaconinc/MainProject`
- To pull newest changes in the submodule, inside `jpf-core` folder, do:
  - `git fetch`
  - `git merge origin/master`

See more about git submodule [here](https://git-scm.com/book/en/v2/Git-Tools-Submodules).

- To build, `jpf-core`, see instructions [here](https://github.com/javapathfinder/jpf-core/wiki/How-to-install-JPF).



To run each test, add the corresponding class path `jpf-core.classpath` inside `jpf.properties` . For example, to run `ConcurrentListTest`, add `../ConcurrentList/build/test`, and inside `ConcurrentList` folder, do `ant test`. 