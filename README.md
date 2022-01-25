This CLI tool is designed to read a text file with lines of unorganized words and format them into trimmed and sanitized output printed in the terminal.
- it will break the string into a new line by 80 characters
- it will only show one line break when there are multiples between the paragraphs

For instance,

```
This is                        some very badly             formatted

text. It is going to be a quick but slightly challenging exercise for some
cli tooling related development more than data structure and algorithm.






However, this essentially comes down to the data structure and algorithm. 

Good luck!



```

into

```
This is some very badly formatted text. It is going to be a quick but slightly challenging exercise for some
cli tooling related development more than data structure and algorithm.

However, this essentially comes down to the data structure and algorithm. Good luck!
```

This applications may need the following areas to look at;
1. cli tool development options in java community (jcommand[https://jcommander.org/] or picoli[https://picocli.info/] and plain java implementation of it
2. data structure - what are we going to use when parsing the string; hash table? array?
3. algorithm - are we going to chunk the reading of the file in case it contains massive number of lines? how are we going to iterate or recurse?
4. performance - what are the important aspects of performance when reading many lines?
5. testability - what are the edge cases we must cover in the unit tests?
6. delivery - how are we going to deliver the compiled solution? graalvm[https://www.graalvm.org/22.0/docs/getting-started/]?
